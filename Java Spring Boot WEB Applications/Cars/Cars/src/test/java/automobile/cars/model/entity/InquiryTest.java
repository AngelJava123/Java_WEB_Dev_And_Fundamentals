package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class InquiryTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    void testValidInquiry() {
        Inquiry inquiry = new Inquiry();
        inquiry.setName("John Doe");
        inquiry.setEmail("john.doe@example.com");
        inquiry.setMessage("This is a test message");
        inquiry.setMobile("0889584637");

        Set<ConstraintViolation<Inquiry>> violations = validator.validate(inquiry);

        assertTrue(violations.isEmpty(), "No validation errors expected. Violations found: " + violations);
    }

    @Test
    void testInvalidName() {
        Inquiry inquiry = new Inquiry();
        inquiry.setName("123"); // Invalid name with numbers

        Set<ConstraintViolation<Inquiry>> violations = validator.validate(inquiry);

        assertEquals(1, violations.size(), "One validation error expected");
        assertEquals("Name must contain only letters and spaces", violations.iterator().next().getMessage());
    }

    @Test
    void testInvalidEmail() {
        Inquiry inquiry = new Inquiry();
        inquiry.setEmail("invalid_email"); // Invalid email format

        Set<ConstraintViolation<Inquiry>> violations = validator.validate(inquiry);

        assertEquals(1, violations.size(), "One validation error expected");
        assertEquals("must be a well-formed email address", violations.iterator().next().getMessage());
    }

    @Test
    void testInvalidMobile() {
        Inquiry inquiry = new Inquiry();
        inquiry.setMobile("123"); // Invalid mobile number format

        Set<ConstraintViolation<Inquiry>> violations = validator.validate(inquiry);

        assertEquals(1, violations.size(), "One validation error expected");
        assertEquals("Invalid phone number", violations.iterator().next().getMessage());
    }
}
