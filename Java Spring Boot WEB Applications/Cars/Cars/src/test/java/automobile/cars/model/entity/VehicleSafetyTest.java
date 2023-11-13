package automobile.cars.model.entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class VehicleSafetyTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testNoValidationErrorsForDefaultValues() {
        // Arrange
        VehicleSafety safety = new VehicleSafety();

        // Act
        Set<ConstraintViolation<VehicleSafety>> violations = validator.validate(safety);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors for default values");
    }

    @Test
    void testSettingValues() {
        // Arrange
        VehicleSafety safety = new VehicleSafety();
        safety.setAntiLockBrakingSystem(true);
        safety.setElectronicStabilityControl(true);
        safety.setAdaptiveCruiseControl(true);
        safety.setLaneDepartureWarning(true);
        safety.setBlindSpotDetection(true);
        safety.setForwardCollisionWarning(true);
        safety.setAutomaticEmergencyBraking(true);
        safety.setRearviewCamera(true);

        // Act
        Set<ConstraintViolation<VehicleSafety>> violations = validator.validate(safety);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors when setting values");
    }
}
