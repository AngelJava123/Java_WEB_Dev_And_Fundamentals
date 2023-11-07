package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComfortDTOTest {

    private ComfortDTO comfortDTO;

    @Before
    public void setup() {
        comfortDTO = new ComfortDTO();
    }

    @Test
    public void testDefaultConstructor() {
        // Check that all comfort features are initially set to false
        assertFalse(comfortDTO.isAirConditioning());
        assertFalse(comfortDTO.isCruiseControl());
        assertFalse(comfortDTO.isPowerSteering());
        assertFalse(comfortDTO.isTiltSteeringWheel());
        assertFalse(comfortDTO.isTelescopingSteeringWheel());
        assertFalse(comfortDTO.isRearDefrost());
        assertFalse(comfortDTO.isRemoteTrunkRelease());
        assertFalse(comfortDTO.isRemoteEngineStart());
        assertFalse(comfortDTO.isHeatedSteeringWheel());
        assertFalse(comfortDTO.isHeatedMirrors());
    }

    @Test
    public void testGettersAndSetters() {
        // Set the comfort features to true using the setter methods
        comfortDTO.setAirConditioning(true);
        comfortDTO.setCruiseControl(true);
        comfortDTO.setPowerSteering(true);
        comfortDTO.setTiltSteeringWheel(true);
        comfortDTO.setTelescopingSteeringWheel(true);
        comfortDTO.setRearDefrost(true);
        comfortDTO.setRemoteTrunkRelease(true);
        comfortDTO.setRemoteEngineStart(true);
        comfortDTO.setHeatedSteeringWheel(true);
        comfortDTO.setHeatedMirrors(true);

        // Check that the getter methods return the correct values
        assertTrue(comfortDTO.isAirConditioning());
        assertTrue(comfortDTO.isCruiseControl());
        assertTrue(comfortDTO.isPowerSteering());
        assertTrue(comfortDTO.isTiltSteeringWheel());
        assertTrue(comfortDTO.isTelescopingSteeringWheel());
        assertTrue(comfortDTO.isRearDefrost());
        assertTrue(comfortDTO.isRemoteTrunkRelease());
        assertTrue(comfortDTO.isRemoteEngineStart());
        assertTrue(comfortDTO.isHeatedSteeringWheel());
        assertTrue(comfortDTO.isHeatedMirrors());
    }
}
