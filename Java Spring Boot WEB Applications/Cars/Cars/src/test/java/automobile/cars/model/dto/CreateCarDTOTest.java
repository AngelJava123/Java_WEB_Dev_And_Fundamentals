package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class CreateCarDTOTest {

    private CreateCarDTO createCarDTO;
    private Validator validator;

    @Before
    public void setup() {
        createCarDTO = new CreateCarDTO();
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        assertNull(createCarDTO.getId());
        assertTrue(createCarDTO.getImageFiles().isEmpty());
        assertNull(createCarDTO.getMake());
        assertNull(createCarDTO.getModel());
        assertEquals(0, createCarDTO.getPrice());
        assertNull(createCarDTO.getMonth());
        assertNull(createCarDTO.getYear());
        assertNotNull(createCarDTO.getEngine());
        assertNotNull(createCarDTO.getCategory());
        assertNotNull(createCarDTO.getGearBox());
        assertEquals(0, createCarDTO.getMileage());
        assertNotNull(createCarDTO.getColor());
        assertNotNull(createCarDTO.getSafety());
        assertNotNull(createCarDTO.getExterior());
        assertNotNull(createCarDTO.getInterior());
        assertNotNull(createCarDTO.getProtection());
        assertNotNull(createCarDTO.getComfort());
        assertNotNull(createCarDTO.getOther());
        assertNull(createCarDTO.getAdditionalInformation());
        assertNull(createCarDTO.getPhoneNumber());
        assertNull(createCarDTO.getLocation());
        assertEquals(0, createCarDTO.getFromPrice());
        assertEquals(0, createCarDTO.getToPrice());
    }

    @Test
    public void testGettersAndSetters() {
        createCarDTO.setId(1L);

        List<MultipartFile> imageFiles = new ArrayList<>();
        MockMultipartFile image1 = new MockMultipartFile("image1", "image1.jpg", "image/jpeg", new byte[0]);
        imageFiles.add(image1);
        createCarDTO.setImageFiles(imageFiles);

        createCarDTO.setMake("Toyota");
        createCarDTO.setModel("Camry");
        createCarDTO.setPrice(25000);
        createCarDTO.setMonth("January");
        createCarDTO.setYear("2023");

        createCarDTO.setEngine(null);
        createCarDTO.setCategory(null);
        createCarDTO.setGearBox(null);
        createCarDTO.setMileage(5000);
        createCarDTO.setColor(null);
        createCarDTO.setSafety(null);
        createCarDTO.setExterior(null);
        createCarDTO.setInterior(null);
        createCarDTO.setProtection(null);
        createCarDTO.setComfort(null);
        createCarDTO.setOther(null);

        createCarDTO.setAdditionalInformation("This is a test car.");
        createCarDTO.setPhoneNumber("0801234567");
        createCarDTO.setLocation("New York");
        createCarDTO.setFromPrice(20000);
        createCarDTO.setToPrice(30000);

        assertEquals(1L, (long) createCarDTO.getId());
        assertEquals(1, createCarDTO.getImageFiles().size());
        assertEquals("Toyota", createCarDTO.getMake());
        assertEquals("Camry", createCarDTO.getModel());
        assertEquals(25000, createCarDTO.getPrice());
        assertEquals("January", createCarDTO.getMonth());
        assertEquals("2023", createCarDTO.getYear());
        assertNull(createCarDTO.getEngine());
        assertNull(createCarDTO.getCategory());
        assertNull(createCarDTO.getGearBox());
        assertEquals(5000, createCarDTO.getMileage());
        assertNull(createCarDTO.getColor());
        assertNull(createCarDTO.getSafety());
        assertNull(createCarDTO.getExterior());
        assertNull(createCarDTO.getInterior());
        assertNull(createCarDTO.getProtection());
        assertNull(createCarDTO.getComfort());
        assertNull(createCarDTO.getOther());
        assertEquals("This is a test car.", createCarDTO.getAdditionalInformation());
        assertEquals("0801234567", createCarDTO.getPhoneNumber());
        assertEquals("New York", createCarDTO.getLocation());
        assertEquals(20000, createCarDTO.getFromPrice());
        assertEquals(30000, createCarDTO.getToPrice());
    }

    @Test
    public void testValidCreateCarDTO() {
        createCarDTO.setMake("Toyota");
        createCarDTO.setModel("Camry");
        createCarDTO.setPrice(25000);
        createCarDTO.setMonth("January");
        createCarDTO.setYear("2023");
        createCarDTO.setMileage(5000);
        createCarDTO.setAdditionalInformation("This is a test car.");
        createCarDTO.setPhoneNumber("0801234567");
        createCarDTO.setLocation("New York");

        Set<ConstraintViolation<CreateCarDTO>> violations = validator.validate(createCarDTO);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testInvalidMake() {
        createCarDTO.setModel("Camry");
        createCarDTO.setPrice(25000);
        createCarDTO.setMonth("January");
        createCarDTO.setYear("2023");
        createCarDTO.setMileage(5000);
        createCarDTO.setAdditionalInformation("This is a test car.");
        createCarDTO.setPhoneNumber("0801234567");
        createCarDTO.setLocation("New York");

        Set<ConstraintViolation<CreateCarDTO>> violations = validator.validate(createCarDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "make".equals(violation.getPropertyPath().toString())));
    }
}
