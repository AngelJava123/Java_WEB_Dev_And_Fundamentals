package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.*;

public class GearBoxDTOTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        GearBoxDTO gearBoxDTO = new GearBoxDTO();
        assertNull(gearBoxDTO.getId());
        assertNull(gearBoxDTO.getGearBoxType());
    }

    @Test
    public void testGettersAndSetters() {
        GearBoxDTO gearBoxDTO = new GearBoxDTO();

        Long id = 1L;
        String gearBoxType = "Automatic";

        gearBoxDTO.setId(id);
        gearBoxDTO.setGearBoxType(gearBoxType);

        assertEquals(id, gearBoxDTO.getId());
        assertEquals(gearBoxType, gearBoxDTO.getGearBoxType());
    }

    @Test
    public void testValidGearBoxType() {
        GearBoxDTO gearBoxDTO = new GearBoxDTO();
        gearBoxDTO.setGearBoxType("Manual");

        Set<ConstraintViolation<GearBoxDTO>> violations = validator.validate(gearBoxDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidGearBoxType() {
        GearBoxDTO gearBoxDTO = new GearBoxDTO();

        Set<ConstraintViolation<GearBoxDTO>> violations = validator.validate(gearBoxDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "gearBoxType".equals(violation.getPropertyPath().toString())));
    }
}
