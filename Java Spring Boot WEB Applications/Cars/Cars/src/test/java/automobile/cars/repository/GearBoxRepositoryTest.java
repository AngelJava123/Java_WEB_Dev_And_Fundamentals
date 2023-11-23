package automobile.cars.repository;

import automobile.cars.model.entity.VehicleGearBox;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GearBoxRepositoryTest {

    @Mock
    private GearBoxRepository gearBoxRepository;

    @Test
    void testSaveGearBox() {
        // Arrange
        VehicleGearBox gearBoxToSave = mock(VehicleGearBox.class);
        VehicleGearBox savedGearBox = mock(VehicleGearBox.class);

        when(gearBoxRepository.save(gearBoxToSave)).thenReturn(savedGearBox);

        // Act
        VehicleGearBox resultGearBox = gearBoxRepository.save(gearBoxToSave);

        // Assert
        assertThat(resultGearBox).isEqualTo(savedGearBox);
    }

    @Test
    void testFindByGearBoxType() {
        // Arrange
        String gearBoxType = "Automatic";
        VehicleGearBox expectedGearBox = mock(VehicleGearBox.class);

        when(gearBoxRepository.findByGearBoxType(gearBoxType)).thenReturn(expectedGearBox);

        // Act
        Optional<VehicleGearBox> resultGearBoxOptional = Optional.ofNullable(gearBoxRepository.findByGearBoxType(gearBoxType));

        // Assert
        assertThat(resultGearBoxOptional).isPresent().contains(expectedGearBox);
    }


}
