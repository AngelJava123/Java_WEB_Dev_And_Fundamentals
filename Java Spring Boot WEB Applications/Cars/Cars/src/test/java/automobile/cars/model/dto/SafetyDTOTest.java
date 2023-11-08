package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SafetyDTOTest {

    private SafetyDTO safetyDTO;

    @Before
    public void setup() {
        safetyDTO = new SafetyDTO();
    }

    @Test
    public void testDefaultConstructor() {
        // Check that all safety features are initially set to false
        assertFalse(safetyDTO.isAntiLockBrakingSystem());
        assertFalse(safetyDTO.isElectronicStabilityControl());
        assertFalse(safetyDTO.isAdaptiveCruiseControl());
        assertFalse(safetyDTO.isLaneDepartureWarning());
        assertFalse(safetyDTO.isBlindSpotDetection());
        assertFalse(safetyDTO.isForwardCollisionWarning());
        assertFalse(safetyDTO.isAutomaticEmergencyBraking());
        assertFalse(safetyDTO.isRearviewCamera());
    }

    @Test
    public void testGettersAndSetters() {
        // Set the safety features to true using the setter methods
        safetyDTO.setAntiLockBrakingSystem(true);
        safetyDTO.setElectronicStabilityControl(true);
        safetyDTO.setAdaptiveCruiseControl(true);
        safetyDTO.setLaneDepartureWarning(true);
        safetyDTO.setBlindSpotDetection(true);
        safetyDTO.setForwardCollisionWarning(true);
        safetyDTO.setAutomaticEmergencyBraking(true);
        safetyDTO.setRearviewCamera(true);

        // Check that the getter methods return the correct values
        assertTrue(safetyDTO.isAntiLockBrakingSystem());
        assertTrue(safetyDTO.isElectronicStabilityControl());
        assertTrue(safetyDTO.isAdaptiveCruiseControl());
        assertTrue(safetyDTO.isLaneDepartureWarning());
        assertTrue(safetyDTO.isBlindSpotDetection());
        assertTrue(safetyDTO.isForwardCollisionWarning());
        assertTrue(safetyDTO.isAutomaticEmergencyBraking());
        assertTrue(safetyDTO.isRearviewCamera());
    }
}
