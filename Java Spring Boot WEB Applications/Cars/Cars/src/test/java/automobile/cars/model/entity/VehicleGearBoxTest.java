package automobile.cars.model.entity;

import org.junit.jupiter.api.BeforeEach;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;
import javax.validation.ConstraintViolation;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleGearBoxTest extends BaseEntityTest {

    @Test
    void testNotNullConstraints() {
        // Arrange
        VehicleGearBox gearBox = new VehicleGearBox();

        // Act
        Set<ConstraintViolation<VehicleGearBox>> violations = validator.validate(gearBox);

        // Assert
        assertFalse(violations.isEmpty(), "There should be validation errors for null constraints");
    }

    @Test
    void testValidGearBox() {
        // Arrange
        VehicleGearBox gearBox = new VehicleGearBox();
        gearBox.setId(1L);
        gearBox.setGearBoxType("Automatic");

        // Act
        Set<ConstraintViolation<VehicleGearBox>> violations = validator.validate(gearBox);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors for a valid gear box");
    }

    @Test
    void testInvalidGearBoxType() {
        // Arrange
        VehicleGearBox gearBox = new VehicleGearBox();
        gearBox.setId(1L);
        gearBox.setGearBoxType("Invalid123");

        // Act
        Set<ConstraintViolation<VehicleGearBox>> violations = validator.validate(gearBox);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors");
    }

}

class BaseEntityTest {

    protected Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
}
