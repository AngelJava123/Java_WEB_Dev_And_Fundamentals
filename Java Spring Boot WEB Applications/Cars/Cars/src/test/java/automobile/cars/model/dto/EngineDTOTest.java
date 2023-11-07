package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class EngineDTOTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testDefaultConstructor() {
        EngineDTO engineDTO = new EngineDTO();
        assertNull(engineDTO.getId());
        assertNull(engineDTO.getEngineType());
        assertEquals(0, engineDTO.getPower());
        assertEquals(0, engineDTO.getPowerFrom());
        assertEquals(0, engineDTO.getPowerTo());
        assertNull(engineDTO.getEuroStandard());
        assertEquals(0, engineDTO.getCubicCapacity());
        assertEquals(0, engineDTO.getCubicCapacityFrom());
        assertEquals(0, engineDTO.getCubicCapacityTo());
    }

    @Test
    public void testGettersAndSetters() {
        EngineDTO engineDTO = new EngineDTO();

        Long id = 1L;
        String engineType = "Petrol";
        int power = 150;
        int powerFrom = 100;
        int powerTo = 200;
        String euroStandard = "Euro 6";
        int cubicCapacity = 2000;
        int cubicCapacityFrom = 1500;
        int cubicCapacityTo = 2500;

        engineDTO.setId(id);
        engineDTO.setEngineType(engineType);
        engineDTO.setPower(power);
        engineDTO.setPowerFrom(powerFrom);
        engineDTO.setPowerTo(powerTo);
        engineDTO.setEuroStandard(euroStandard);
        engineDTO.setCubicCapacity(cubicCapacity);
        engineDTO.setCubicCapacityFrom(cubicCapacityFrom);
        engineDTO.setCubicCapacityTo(cubicCapacityTo);

        assertEquals(id, engineDTO.getId());
        assertEquals(engineType, engineDTO.getEngineType());
        assertEquals(power, engineDTO.getPower());
        assertEquals(powerFrom, engineDTO.getPowerFrom());
        assertEquals(powerTo, engineDTO.getPowerTo());
        assertEquals(euroStandard, engineDTO.getEuroStandard());
        assertEquals(cubicCapacity, engineDTO.getCubicCapacity());
        assertEquals(cubicCapacityFrom, engineDTO.getCubicCapacityFrom());
        assertEquals(cubicCapacityTo, engineDTO.getCubicCapacityTo());
    }

    @Test
    public void testValidPowerAndCubicCapacity() {
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setPower(1500);
        engineDTO.setCubicCapacity(2500);

        Set<ConstraintViolation<EngineDTO>> violations = validator.validate(engineDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidPower() {
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setPower(0);

        Set<ConstraintViolation<EngineDTO>> violations = validator.validate(engineDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "power".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testInvalidCubicCapacity() {
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setCubicCapacity(0);

        Set<ConstraintViolation<EngineDTO>> violations = validator.validate(engineDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "cubicCapacity".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testOutOfRangePower() {
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setPower(3500);

        Set<ConstraintViolation<EngineDTO>> violations = validator.validate(engineDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "power".equals(violation.getPropertyPath().toString())));
    }

    @Test
    public void testOutOfRangeCubicCapacity() {
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setCubicCapacity(5500);

        Set<ConstraintViolation<EngineDTO>> violations = validator.validate(engineDTO);

        assertTrue(violations.stream()
                .anyMatch(violation -> "cubicCapacity".equals(violation.getPropertyPath().toString())));
    }
}
