package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
public class VehicleExteriorTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    void testNotNullConstraints() {
        // Arrange
        VehicleExterior exterior = new VehicleExterior();

        // Debugging information
        System.out.println("VehicleExterior object before validation: " + exterior);

        // Act
        Set<ConstraintViolation<VehicleExterior>> violations = validator.validate(exterior);

        // Log violations for debugging
        System.out.println("Number of Violations: " + violations.size());
        for (ConstraintViolation<VehicleExterior> violation : violations) {
            System.out.println("Violation: " + violation.getPropertyPath() + " - " + violation.getMessage());
        }

        // Assert
        assertTrue(violations.isEmpty(), "There should be no validation errors for null constraints");
    }

    @Test
    void testDefaultValues() {
        // Arrange
        VehicleExterior exterior = new VehicleExterior();

        // Act

        // Assert
        assertFalse(exterior.isAlloyWheels());
        assertFalse(exterior.isPowerSideMirrorAdjustment());
        assertFalse(exterior.isRainSensingWipers());
        assertFalse(exterior.isSunroof());
        assertFalse(exterior.isLedHeadlights());
        assertFalse(exterior.isFogLights());
        assertFalse(exterior.isAutomaticHeadlights());
    }

    @Test
    void testSetterAndGetter() {
        // Arrange
        VehicleExterior exterior = new VehicleExterior();

        // Act
        exterior.setAlloyWheels(true);
        exterior.setPowerSideMirrorAdjustment(true);
        exterior.setRainSensingWipers(true);
        exterior.setSunroof(true);
        exterior.setLedHeadlights(true);
        exterior.setFogLights(true);
        exterior.setAutomaticHeadlights(true);

        // Assert
        assertTrue(exterior.isAlloyWheels());
        assertTrue(exterior.isPowerSideMirrorAdjustment());
        assertTrue(exterior.isRainSensingWipers());
        assertTrue(exterior.isSunroof());
        assertTrue(exterior.isLedHeadlights());
        assertTrue(exterior.isFogLights());
        assertTrue(exterior.isAutomaticHeadlights());
    }
}
