package automobile.cars.repository;
import automobile.cars.model.entity.VehicleSafety;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SafetyRepositoryTest {

    @Mock
    private SafetyRepository safetyRepository;

    @Test
    void testSaveSafety() {
        // Arrange
        VehicleSafety safetyToSave = mock(VehicleSafety.class);
        VehicleSafety savedSafety = mock(VehicleSafety.class);

        when(safetyRepository.save(safetyToSave)).thenReturn(savedSafety);

        // Act
        VehicleSafety resultSafety = safetyRepository.save(safetyToSave);

        // Assert
        assertThat(resultSafety).isEqualTo(savedSafety);
    }

    @Test
    void testFindById() {
        // Arrange
        Long safetyId = 1L;
        VehicleSafety expectedSafety = mock(VehicleSafety.class);

        when(safetyRepository.findById(safetyId)).thenReturn(Optional.of(expectedSafety));

        // Act
        Optional<VehicleSafety> resultSafety = safetyRepository.findById(safetyId);

        // Assert
        assertThat(resultSafety).isPresent().contains(expectedSafety);
    }
}
