package automobile.cars.repository;

import automobile.cars.model.entity.VehicleExterior;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExteriorRepositoryTest {

    @Mock
    private ExteriorRepository exteriorRepository;

    @Test
    void testSaveExterior() {
        // Arrange
        VehicleExterior exteriorToSave = mock(VehicleExterior.class);
        VehicleExterior savedExterior = mock(VehicleExterior.class);

        when(exteriorRepository.save(exteriorToSave)).thenReturn(savedExterior);

        // Act
        VehicleExterior resultExterior = exteriorRepository.save(exteriorToSave);

        // Assert
        assertThat(resultExterior).isEqualTo(savedExterior);
    }

    @Test
    void testFindById() {
        // Arrange
        Long exteriorId = 1L;
        VehicleExterior expectedExterior = mock(VehicleExterior.class);

        when(exteriorRepository.findById(exteriorId)).thenReturn(Optional.of(expectedExterior));

        // Act
        Optional<VehicleExterior> resultExterior = exteriorRepository.findById(exteriorId);

        // Assert
        assertThat(resultExterior).isPresent().contains(expectedExterior);
    }
}
