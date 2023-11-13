package automobile.cars.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class VehicleProtectionTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testNoValidationErrorsForDefaultValues() {
        // Arrange
        VehicleProtection protection = new VehicleProtection();

        // Act
        Set<ConstraintViolation<VehicleProtection>> violations = validator.validate(protection);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors for default values");
    }

    @Test
    void testSettingValues() {
        // Arrange
        VehicleProtection protection = new VehicleProtection();
        protection.setAntiTheftSystem(true);
        protection.setRemoteKeylessEntry(true);
        protection.setAlarmSystem(true);
        protection.setAirbags(true);
        protection.setParkingSensors(true);
        protection.setBackupCamera(true);
        protection.setTirePressureMonitoring(true);

        // Act
        Set<ConstraintViolation<VehicleProtection>> violations = validator.validate(protection);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors when setting values");
    }
}
