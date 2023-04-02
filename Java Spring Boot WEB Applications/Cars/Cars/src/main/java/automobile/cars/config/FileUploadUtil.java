package automobile.cars.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Configuration
public class FileUploadUtil {

    private final Cloudinary cloudinary;

    public FileUploadUtil() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "my_cloud_name",
                "api_key", "my_api_key",
                "api_secret", "my_api_secret"));
    }
    
    // I will give the cloudinary details for access on demand, since it is a sensitive information and should not be public.

    public String uploadFile(MultipartFile file) throws IOException {
        // Generate a unique filename
        String filename = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());

        // Upload the file to Cloudinary
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "folder", "my_folder_name",
                "public_id", filename));

        // Return the public URL of the uploaded file
        return (String) uploadResult.get("secure_url");
    }
}
