package automobile.cars.repository;

import automobile.cars.model.entity.VehicleComfort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ComfortRepositoryTest {

    @Mock
    private ComfortRepository comfortRepository;

    @Test
    void testSaveComfort() {
        // Arrange
        VehicleComfort comfortToSave = mock(VehicleComfort.class);
        VehicleComfort savedComfort = mock(VehicleComfort.class);

        when(comfortRepository.save(comfortToSave)).thenReturn(savedComfort);

        // Act
        VehicleComfort resultComfort = comfortRepository.save(comfortToSave);

        // Assert
        assertThat(resultComfort).isEqualTo(savedComfort);
    }

    @Test
    void testFindById() {
        // Arrange
        Long comfortId = 1L;
        VehicleComfort expectedComfort = mock(VehicleComfort.class);

        when(comfortRepository.findById(comfortId)).thenReturn(Optional.of(expectedComfort));

        // Act
        Optional<VehicleComfort> resultComfort = comfortRepository.findById(comfortId);

        // Assert
        assertThat(resultComfort).isPresent().contains(expectedComfort);
    }
}
