package automobile.cars.config;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class FileUploadUtilTest {

    private FileUploadUtil fileUploadUtil;

    @Before
    public void setup() {
        fileUploadUtil = new FileUploadUtil();
    }

    @Test
    public void testUploadFile() throws IOException {
        // Create a mock MultipartFile for testing with a valid image
        MultipartFile file = createMockMultipartFileWithValidImage();

        // Test uploading the file
        String url = fileUploadUtil.uploadFile(file);

        // Assert that the URL is not null or empty
        assertNotNull(url);
    }

    @Test
    public void testDeleteFiles() throws IOException {
        // Create a list of image file paths for testing
        List<String> imageFilePaths = new ArrayList<>();
        imageFilePaths.add("test_url_1");
        imageFilePaths.add("test_url_2");

        // Test deleting multiple files
        fileUploadUtil.deleteFiles(imageFilePaths);

        // No exception should be thrown if files are deleted successfully
    }

    @Test
    public void testDeleteFile() throws IOException {
        // Create a mock image file path for testing
        String imageFilePath = "test_url";

        // Test deleting a single file
        fileUploadUtil.deleteFile(imageFilePath);

        // No exception should be thrown if the file is deleted successfully
    }

    private MultipartFile createMockMultipartFileWithValidImage() throws IOException {
        // Create a temporary file with a valid image for testing
        File tempImageFile = File.createTempFile("test", ".jpg");
        try (InputStream is = getClass().getResourceAsStream("/valid_test_image.jpg")) {
            Files.copy(is, tempImageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        // Create a mock MultipartFile using Mockito
        MultipartFile mockFile = Mockito.mock(MultipartFile.class);
        Mockito.when(mockFile.getOriginalFilename()).thenReturn("test.jpg");
        Mockito.when(mockFile.getBytes()).thenReturn(Files.readAllBytes(tempImageFile.toPath()));
        Mockito.when(mockFile.getContentType()).thenReturn("image/jpeg");
        Mockito.when(mockFile.getSize()).thenReturn(tempImageFile.length());

        // Implement the transferTo method
        Mockito.doAnswer(invocation -> {
            File dest = (File) invocation.getArguments()[0];
            Files.copy(tempImageFile.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return null;
        }).when(mockFile).transferTo(Mockito.any(File.class));

        return mockFile;
    }
}



