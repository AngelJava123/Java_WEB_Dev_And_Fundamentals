package automobile.cars.repository;

import automobile.cars.model.entity.Image;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ImageRepositoryTest {


    @Mock
    private ImageRepository imageRepository;

    @Test
    void testSaveImage() {
        // Arrange
        Image imageToSave = mock(Image.class);
        Image savedImage = mock(Image.class);

        when(imageRepository.save(imageToSave)).thenReturn(savedImage);

        // Act
        Image resultImage = imageRepository.save(imageToSave);

        // Assert
        assertThat(resultImage).isEqualTo(savedImage);
    }

    @Test
    void testFindById() {
        // Arrange
        Long imageId = 1L;
        Image expectedImage = mock(Image.class);

        when(imageRepository.findById(imageId)).thenReturn(Optional.of(expectedImage));

        // Act
        Optional<Image> resultImage = imageRepository.findById(imageId);

        // Assert
        assertThat(resultImage).isPresent().contains(expectedImage);
    }
}
