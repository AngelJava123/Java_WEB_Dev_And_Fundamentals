package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleEngineTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testNotNullConstraints() {
        // Arrange
        VehicleEngine engine = new VehicleEngine();

        // Act
        Set<ConstraintViolation<VehicleEngine>> violations = validator.validate(engine);

        // Assert
        assertFalse(violations.isEmpty(), "There should be validation errors for null constraints");
    }





    @Test
    void testMinAndMaxConstraints() {
        // Arrange
        VehicleEngine engine = new VehicleEngine();
        engine.setPower(0);
        engine.setCubicCapacity(5001);

        // Act
        Set<ConstraintViolation<VehicleEngine>> violations = validator.validate(engine);

        // Assert
        assertTrue(violations.stream().anyMatch(
                violation -> violation.getMessage().startsWith("Value must be greater than zero")));
        assertTrue(violations.stream().anyMatch(
                violation -> violation.getMessage().startsWith("Value cannot exceed 5000")));
    }

    @Test
    void testValidEngine() {
        // Arrange
        VehicleEngine engine = new VehicleEngine();
        engine.setId(1L);
        engine.setEngineType("Petrol");
        engine.setPower(150);
        engine.setEuroStandard("Euro 6");
        engine.setCubicCapacity(2000);

        // Act
        Set<ConstraintViolation<VehicleEngine>> violations = validator.validate(engine);

        // Assert
        assertTrue(violations.isEmpty());
    }

    @Test
    void testInvalidEngineType() {
        // Arrange
        VehicleEngine engine = new VehicleEngine();
        engine.setId(1L);
        engine.setEngineType("Invalid123");
        engine.setPower(150);
        engine.setEuroStandard("Euro 6");
        engine.setCubicCapacity(2000);

        // Act
        Set<ConstraintViolation<VehicleEngine>> violations = validator.validate(engine);

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors for invalid engine type");
    }
}
