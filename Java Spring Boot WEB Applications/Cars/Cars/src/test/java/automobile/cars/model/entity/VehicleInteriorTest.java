package automobile.cars.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleInteriorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testNoValidationErrorsForDefaultValues() {
        // Arrange
        VehicleInterior interior = new VehicleInterior();

        // Act
        Set<ConstraintViolation<VehicleInterior>> violations = validator.validate(interior);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors for default values");
    }

    @Test
    void testDefaultValues() {
        // Arrange
        VehicleInterior interior = new VehicleInterior();

        // Act

        // Assert
        assertFalse(interior.isLeatherSeats());
        assertFalse(interior.isHeatedSeats());
        assertFalse(interior.isPowerWindows());
        assertFalse(interior.isPowerLocks());
        assertFalse(interior.isSunroof());
        assertFalse(interior.isNavigationSystem());
        assertFalse(interior.isBluetooth());
        assertFalse(interior.isBackupCamera());
        assertFalse(interior.isPushButtonStart());
        assertFalse(interior.isDualClimateControl());
    }

    @Test
    void testSettingValues() {
        // Arrange
        VehicleInterior interior = new VehicleInterior();
        interior.setLeatherSeats(true);
        interior.setHeatedSeats(true);
        interior.setPowerWindows(true);
        interior.setPowerLocks(true);
        interior.setSunroof(true);
        interior.setNavigationSystem(true);
        interior.setBluetooth(true);
        interior.setBackupCamera(true);
        interior.setPushButtonStart(true);
        interior.setDualClimateControl(true);

        // Act

        // Assert
        assertTrue(interior.isLeatherSeats());
        assertTrue(interior.isHeatedSeats());
        assertTrue(interior.isPowerWindows());
        assertTrue(interior.isPowerLocks());
        assertTrue(interior.isSunroof());
        assertTrue(interior.isNavigationSystem());
        assertTrue(interior.isBluetooth());
        assertTrue(interior.isBackupCamera());
        assertTrue(interior.isPushButtonStart());
        assertTrue(interior.isDualClimateControl());
    }
}
