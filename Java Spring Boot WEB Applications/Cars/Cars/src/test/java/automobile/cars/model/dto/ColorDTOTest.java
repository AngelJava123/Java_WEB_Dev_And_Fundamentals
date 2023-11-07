package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ColorDTOTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        ColorDTO colorDTO = new ColorDTO();
        assertNull(colorDTO.getId());
        assertNull(colorDTO.getPaint());
    }

    @Test
    public void testGettersAndSetters() {
        ColorDTO colorDTO = new ColorDTO();

        Long id = 1L;
        String paint = "Red";

        colorDTO.setId(id);
        colorDTO.setPaint(paint);

        assertEquals(id, colorDTO.getId());
        assertEquals(paint, colorDTO.getPaint());
    }

    @Test
    public void testValidColor() {
        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setPaint("Blue");

        Set<ConstraintViolation<ColorDTO>> violations = validator.validate(colorDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testNullColor() {
        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setPaint(null);

        Set<ConstraintViolation<ColorDTO>> violations = validator.validate(colorDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "paint".equals(violation.getPropertyPath().toString())));
    }
}
