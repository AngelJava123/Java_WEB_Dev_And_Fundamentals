package automobile.cars.repository;
import automobile.cars.model.entity.VehicleOther;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OtherRepositoryTest {

    @Mock
    private OtherRepository otherRepository;

    @Test
    void testSaveOther() {
        // Arrange
        VehicleOther otherToSave = mock(VehicleOther.class);
        VehicleOther savedOther = mock(VehicleOther.class);

        when(otherRepository.save(otherToSave)).thenReturn(savedOther);

        // Act
        VehicleOther resultOther = otherRepository.save(otherToSave);

        // Assert
        assertThat(resultOther).isEqualTo(savedOther);
    }

    @Test
    void testFindById() {
        // Arrange
        Long otherId = 1L;
        VehicleOther expectedOther = mock(VehicleOther.class);

        when(otherRepository.findById(otherId)).thenReturn(Optional.of(expectedOther));

        // Act
        Optional<VehicleOther> resultOther = otherRepository.findById(otherId);

        // Assert
        assertThat(resultOther).isPresent().contains(expectedOther);
    }
}
