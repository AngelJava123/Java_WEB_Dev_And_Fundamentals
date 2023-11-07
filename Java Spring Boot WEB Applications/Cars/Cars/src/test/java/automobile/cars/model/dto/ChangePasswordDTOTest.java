package automobile.cars.model.dto;

import automobile.cars.model.validation.FieldMatch;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ChangePasswordDTOTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        assertNull(changePasswordDTO.getCurrentPassword());
        assertNull(changePasswordDTO.getNewPassword());
        assertNull(changePasswordDTO.getConfirmNewPassword());
    }

    @Test
    public void testGettersAndSetters() {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();

        String currentPassword = "current123";
        String newPassword = "new123";
        String confirmNewPassword = "new123";

        changePasswordDTO.setCurrentPassword(currentPassword);
        changePasswordDTO.setNewPassword(newPassword);
        changePasswordDTO.setConfirmNewPassword(confirmNewPassword);

        assertEquals(currentPassword, changePasswordDTO.getCurrentPassword());
        assertEquals(newPassword, changePasswordDTO.getNewPassword());
        assertEquals(confirmNewPassword, changePasswordDTO.getConfirmNewPassword());
    }

    @Test
    public void testValidPasswords() {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setCurrentPassword("current123");
        changePasswordDTO.setNewPassword("new123");
        changePasswordDTO.setConfirmNewPassword("new123");

        Set<ConstraintViolation<ChangePasswordDTO>> violations = validator.validate(changePasswordDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidPasswordSize() {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setCurrentPassword("curr");
        changePasswordDTO.setNewPassword("new");
        changePasswordDTO.setConfirmNewPassword("new");

        Set<ConstraintViolation<ChangePasswordDTO>> violations = validator.validate(changePasswordDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "currentPassword".equals(violation.getPropertyPath().toString())));
        assertTrue(violations.stream()
                .anyMatch(violation -> "newPassword".equals(violation.getPropertyPath().toString())));
        assertTrue(violations.stream()
                .anyMatch(violation -> "confirmNewPassword".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testPasswordMismatch() {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setCurrentPassword("current123");
        changePasswordDTO.setNewPassword("new123");
        changePasswordDTO.setConfirmNewPassword("new456");

        Set<ConstraintViolation<ChangePasswordDTO>> violations = validator.validate(changePasswordDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "confirmNewPassword".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testFieldMatchValidation() {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setNewPassword("password1");
        changePasswordDTO.setConfirmNewPassword("password2");

        Set<ConstraintViolation<ChangePasswordDTO>> violations = validator.validate(changePasswordDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> violation.getConstraintDescriptor()
                        .getAnnotation().annotationType().equals(FieldMatch.class)));
    }
}
