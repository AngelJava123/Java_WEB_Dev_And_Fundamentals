package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.*;

public class UserRegisterDTOTest {

    private UserRegisterDTO userRegisterDTO;
    private Validator validator;

    @Before
    public void setup() {
        userRegisterDTO = new UserRegisterDTO();
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        assertNull(userRegisterDTO.getUsername());
        assertNull(userRegisterDTO.getEmail());
        assertNull(userRegisterDTO.getPassword());
        assertNull(userRegisterDTO.getConfirmPassword());
    }

    @Test
    public void testGettersAndSetters() {
        // Set values for the UserRegisterDTO
        userRegisterDTO.setUsername("testUser");
        userRegisterDTO.setEmail("test@example.com");
        userRegisterDTO.setPassword("password");
        userRegisterDTO.setConfirmPassword("password");

        assertEquals("testUser", userRegisterDTO.getUsername());
        assertEquals("test@example.com", userRegisterDTO.getEmail());
        assertEquals("password", userRegisterDTO.getPassword());
        assertEquals("password", userRegisterDTO.getConfirmPassword());
    }

    @Test
    public void testValidUserRegistration() {
        userRegisterDTO.setUsername("testUser");
        userRegisterDTO.setEmail("test@example.com");
        userRegisterDTO.setPassword("password");
        userRegisterDTO.setConfirmPassword("password");

        Set<ConstraintViolation<UserRegisterDTO>> violations = validator.validate(userRegisterDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidPasswordConfirmation() {
        userRegisterDTO.setUsername("testUser");
        userRegisterDTO.setEmail("test@example.com");
        userRegisterDTO.setPassword("password");
        userRegisterDTO.setConfirmPassword("differentPassword");

        Set<ConstraintViolation<UserRegisterDTO>> violations = validator.validate(userRegisterDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "confirmPassword".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testInvalidUsername() {
        userRegisterDTO.setUsername("u"); // Username is too short

        Set<ConstraintViolation<UserRegisterDTO>> violations = validator.validate(userRegisterDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "username".equals(violation.getPropertyPath().toString())));
    }
}
