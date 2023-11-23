package automobile.cars.repository;

import automobile.cars.model.entity.VehicleInterior;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InteriorRepositoryTest {

    @Mock
    private InteriorRepository interiorRepository;

    @Test
    void testSaveInterior() {
        // Arrange
        VehicleInterior interiorToSave = mock(VehicleInterior.class);
        VehicleInterior savedInterior = mock(VehicleInterior.class);

        when(interiorRepository.save(interiorToSave)).thenReturn(savedInterior);

        // Act
        VehicleInterior resultInterior = interiorRepository.save(interiorToSave);

        // Assert
        assertThat(resultInterior).isEqualTo(savedInterior);
    }

    @Test
    void testFindById() {
        // Arrange
        Long interiorId = 1L;
        VehicleInterior expectedInterior = mock(VehicleInterior.class);

        when(interiorRepository.findById(interiorId)).thenReturn(Optional.of(expectedInterior));

        // Act
        Optional<VehicleInterior> resultInterior = interiorRepository.findById(interiorId);

        // Assert
        assertThat(resultInterior).isPresent().contains(expectedInterior);
    }
}
