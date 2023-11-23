package automobile.cars.repository;

import automobile.cars.model.entity.VehicleEngine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EngineRepositoryTest {

    @Mock
    private EngineRepository engineRepository;

    @Test
    void testSaveEngine() {
        // Arrange
        VehicleEngine engineToSave = mock(VehicleEngine.class);
        VehicleEngine savedEngine = mock(VehicleEngine.class);

        when(engineRepository.save(engineToSave)).thenReturn(savedEngine);

        // Act
        VehicleEngine resultEngine = engineRepository.save(engineToSave);

        // Assert
        assertThat(resultEngine).isEqualTo(savedEngine);
    }

    @Test
    void testFindById() {
        // Arrange
        Long engineId = 1L;
        VehicleEngine expectedEngine = mock(VehicleEngine.class);

        when(engineRepository.findById(engineId)).thenReturn(Optional.of(expectedEngine));

        // Act
        Optional<VehicleEngine> resultEngine = engineRepository.findById(engineId);

        // Assert
        assertThat(resultEngine).isPresent().contains(expectedEngine);
    }
}
