package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.*;

public class InquiryDTOTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        InquiryDTO inquiryDTO = new InquiryDTO();
        assertNull(inquiryDTO.getName());
        assertNull(inquiryDTO.getEmail());
        assertNull(inquiryDTO.getMessage());
        assertNull(inquiryDTO.getMobile());
    }

    @Test
    public void testGettersAndSetters() {
        InquiryDTO inquiryDTO = new InquiryDTO();

        String name = "John Doe";
        String email = "johndoe@example.com";
        String message = "Test inquiry message";
        String mobile = "0878912345";

        inquiryDTO.setName(name);
        inquiryDTO.setEmail(email);
        inquiryDTO.setMessage(message);
        inquiryDTO.setMobile(mobile);

        assertEquals(name, inquiryDTO.getName());
        assertEquals(email, inquiryDTO.getEmail());
        assertEquals(message, inquiryDTO.getMessage());
        assertEquals(mobile, inquiryDTO.getMobile());
    }

    @Test
    public void testValidInquiry() {
        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setName("John Doe");
        inquiryDTO.setEmail("johndoe@example.com");
        inquiryDTO.setMessage("Test inquiry message");
        inquiryDTO.setMobile("0878912345");

        Set<ConstraintViolation<InquiryDTO>> violations = validator.validate(inquiryDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidName() {
        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setName("1234");

        Set<ConstraintViolation<InquiryDTO>> violations = validator.validate(inquiryDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "name".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testInvalidEmail() {
        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setEmail("invalid-email");

        Set<ConstraintViolation<InquiryDTO>> violations = validator.validate(inquiryDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "email".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testInvalidMobile() {
        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setMobile("123456789");

        Set<ConstraintViolation<InquiryDTO>> violations = validator.validate(inquiryDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "mobile".equals(violation.getPropertyPath().toString())));
    }
}
