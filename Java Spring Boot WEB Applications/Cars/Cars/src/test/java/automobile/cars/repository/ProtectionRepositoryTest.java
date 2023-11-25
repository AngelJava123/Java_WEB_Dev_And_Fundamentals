package automobile.cars.repository;
import automobile.cars.model.entity.VehicleProtection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProtectionRepositoryTest {

    @Mock
    private ProtectionRepository protectionRepository;

    @Test
    void testSaveProtection() {
        // Arrange
        VehicleProtection protectionToSave = mock(VehicleProtection.class);
        VehicleProtection savedProtection = mock(VehicleProtection.class);

        when(protectionRepository.save(protectionToSave)).thenReturn(savedProtection);

        // Act
        VehicleProtection resultProtection = protectionRepository.save(protectionToSave);

        // Assert
        assertThat(resultProtection).isEqualTo(savedProtection);
    }

    @Test
    void testFindById() {
        // Arrange
        Long protectionId = 1L;
        VehicleProtection expectedProtection = mock(VehicleProtection.class);

        when(protectionRepository.findById(protectionId)).thenReturn(Optional.of(expectedProtection));

        // Act
        Optional<VehicleProtection> resultProtection = protectionRepository.findById(protectionId);

        // Assert
        assertThat(resultProtection).isPresent().contains(expectedProtection);
    }
}
