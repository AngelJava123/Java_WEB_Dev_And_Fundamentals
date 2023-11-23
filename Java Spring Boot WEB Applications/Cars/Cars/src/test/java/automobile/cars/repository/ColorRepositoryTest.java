package automobile.cars.repository;

import automobile.cars.model.entity.VehicleColor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ColorRepositoryTest {

    @Mock
    private ColorRepository colorRepository;

    @Test
    void testFindByPaint() {
        // Arrange
        String paint = "Metallic";
        VehicleColor expectedColor = mock(VehicleColor.class);

        when(colorRepository.findByPaint(paint)).thenReturn(expectedColor);

        // Act
        VehicleColor resultColor = colorRepository.findByPaint(paint);

        // Assert
        assertThat(resultColor).isEqualTo(expectedColor);
    }
}
