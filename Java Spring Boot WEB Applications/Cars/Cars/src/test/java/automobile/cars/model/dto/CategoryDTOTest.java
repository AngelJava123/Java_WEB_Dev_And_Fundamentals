package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CategoryDTOTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        CategoryDTO categoryDTO = new CategoryDTO();
        assertNull(categoryDTO.getId());
        assertNull(categoryDTO.getCategory());
    }

    @Test
    public void testParameterizedConstructor() {
        Long id = 1L;
        String category = "Test Category";
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(id);
        categoryDTO.setCategory(category);

        assertEquals(id, categoryDTO.getId());
        assertEquals(category, categoryDTO.getCategory());
    }


    @Test
    public void testGettersAndSetters() {
        CategoryDTO categoryDTO = new CategoryDTO();

        Long id = 2L;
        String category = "Another Category";

        categoryDTO.setId(id);
        categoryDTO.setCategory(category);

        assertEquals(id, categoryDTO.getId());
        assertEquals(category, categoryDTO.getCategory());
    }

    @Test
    public void testCategoryNotNullValidation() {
        CategoryDTO categoryDTO = new CategoryDTO();
        Set<ConstraintViolation<CategoryDTO>> violations = validator.validate(categoryDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "category".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testCategoryNullValidation() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategory(null);
        Set<ConstraintViolation<CategoryDTO>> violations = validator.validate(categoryDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "category".equals(violation.getPropertyPath().toString())));
    }
}
