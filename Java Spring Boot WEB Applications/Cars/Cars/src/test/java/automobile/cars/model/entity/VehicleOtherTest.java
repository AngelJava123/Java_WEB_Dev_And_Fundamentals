package automobile.cars.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleOtherTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testNoValidationErrorsForDefaultValues() {
        // Arrange
        VehicleOther other = new VehicleOther();

        // Act
        Set<ConstraintViolation<VehicleOther>> violations = validator.validate(other);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors for default values");
    }

    @Test
    void testDefaultValues() {
        // Arrange
        VehicleOther other = new VehicleOther();

        // Act

        // Assert
        assertFalse(other.isPowerTailgate());
        assertFalse(other.isPanoramicSunroof());
        assertFalse(other.isAdaptiveHeadlights());
        assertFalse(other.isAppleCarPlay());
        assertFalse(other.isAndroidAuto());
        assertFalse(other.isWirelessCharging());
        assertFalse(other.isPremiumSoundSystem());
        assertFalse(other.isMultiZoneClimateControl());
        assertFalse(other.isPowerAdjustablePedals());
        assertFalse(other.isHeatedRearSeats());
    }

    @Test
    void testSettingValues() {
        // Arrange
        VehicleOther other = new VehicleOther();
        other.setPowerTailgate(true);
        other.setPanoramicSunroof(true);
        other.setAdaptiveHeadlights(true);
        other.setAppleCarPlay(true);
        other.setAndroidAuto(true);
        other.setWirelessCharging(true);
        other.setPremiumSoundSystem(true);
        other.setMultiZoneClimateControl(true);
        other.setPowerAdjustablePedals(true);
        other.setHeatedRearSeats(true);

        // Act

        // Assert
        assertTrue(other.isPowerTailgate());
        assertTrue(other.isPanoramicSunroof());
        assertTrue(other.isAdaptiveHeadlights());
        assertTrue(other.isAppleCarPlay());
        assertTrue(other.isAndroidAuto());
        assertTrue(other.isWirelessCharging());
        assertTrue(other.isPremiumSoundSystem());
        assertTrue(other.isMultiZoneClimateControl());
        assertTrue(other.isPowerAdjustablePedals());
        assertTrue(other.isHeatedRearSeats());
    }
}
