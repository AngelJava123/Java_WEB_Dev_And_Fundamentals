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

public class ChangeEmailDTOTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        ChangeEmailDTO changeEmailDTO = new ChangeEmailDTO();
        assertNull(changeEmailDTO.getNewEmail());
        assertNull(changeEmailDTO.getConfirmNewEmail());
    }

    @Test
    public void testGettersAndSetters() {
        ChangeEmailDTO changeEmailDTO = new ChangeEmailDTO();

        String newEmail = "newemail@example.com";
        String confirmNewEmail = "newemail@example.com";

        changeEmailDTO.setNewEmail(newEmail);
        changeEmailDTO.setConfirmNewEmail(confirmNewEmail);

        assertEquals(newEmail, changeEmailDTO.getNewEmail());
        assertEquals(confirmNewEmail, changeEmailDTO.getConfirmNewEmail());
    }

    @Test
    public void testValidEmails() {
        ChangeEmailDTO changeEmailDTO = new ChangeEmailDTO();
        changeEmailDTO.setNewEmail("valid@example.com");
        changeEmailDTO.setConfirmNewEmail("valid@example.com");

        Set<ConstraintViolation<ChangeEmailDTO>> violations = validator.validate(changeEmailDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testValidEmailFormat() {
        ChangeEmailDTO changeEmailDTO = new ChangeEmailDTO();
        changeEmailDTO.setNewEmail("valid.email@example.com");
        changeEmailDTO.setConfirmNewEmail("valid.email@example.com");

        Set<ConstraintViolation<ChangeEmailDTO>> violations = validator.validate(changeEmailDTO);

        assertTrue(violations.isEmpty());
    }


    @Test
    public void testNullEmail() {
        ChangeEmailDTO changeEmailDTO = new ChangeEmailDTO();
        changeEmailDTO.setNewEmail(null);
        changeEmailDTO.setConfirmNewEmail(null);

        Set<ConstraintViolation<ChangeEmailDTO>> violations = validator.validate(changeEmailDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "newEmail".equals(violation.getPropertyPath().toString())));
        assertTrue(violations.stream()
                .anyMatch(violation -> "confirmNewEmail".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testMismatchedEmails() {
        ChangeEmailDTO changeEmailDTO = new ChangeEmailDTO();
        changeEmailDTO.setNewEmail("email1@example.com");
        changeEmailDTO.setConfirmNewEmail("email2@example.com");

        Set<ConstraintViolation<ChangeEmailDTO>> violations = validator.validate(changeEmailDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "confirmNewEmail".equals(violation.getPropertyPath().toString())));
    }
}
