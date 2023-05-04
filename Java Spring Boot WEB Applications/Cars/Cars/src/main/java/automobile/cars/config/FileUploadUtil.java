package automobile.cars.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class FileUploadUtil {

    private final Cloudinary cloudinary;

    public FileUploadUtil() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dms1ciius",
                "api_key", "916444979765684",
                "api_secret", "HXxr20NSx7tcGERn5Jq27HVNt4k"));
    }

    public String uploadFile(MultipartFile file) throws IOException {
        // Generate a unique filename
        String filename = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());

        // Upload the file to Cloudinary
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "folder", "AutoGeniusImages",
                "public_id", filename));

        // Return the public URL of the uploaded file
        return (String) uploadResult.get("secure_url");
    }

    public void deleteFiles(List<String> imageFilePaths) throws IOException {
        for (String path : imageFilePaths) {
            // Extract the public ID from the image URL
            Pattern pattern = Pattern.compile("upload/v\\d+/(.*?)(\\.[^.]*$|$)");
            Matcher matcher = pattern.matcher(path);
            if (matcher.find()) {
                String publicId = matcher.group(1);
                // Delete the file from Cloudinary
                cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            }
        }
    }

}
