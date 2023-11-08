package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProtectionDTOTest {

    private ProtectionDTO protectionDTO;

    @Before
    public void setup() {
        protectionDTO = new ProtectionDTO();
    }

    @Test
    public void testDefaultConstructor() {
        // Check that all protection features are initially set to false
        assertFalse(protectionDTO.isAntiTheftSystem());
        assertFalse(protectionDTO.isRemoteKeylessEntry());
        assertFalse(protectionDTO.isAlarmSystem());
        assertFalse(protectionDTO.isAirbags());
        assertFalse(protectionDTO.isParkingSensors());
        assertFalse(protectionDTO.isBackupCamera());
        assertFalse(protectionDTO.isTirePressureMonitoring());
    }

    @Test
    public void testGettersAndSetters() {
        // Set the protection features to true using the setter methods
        protectionDTO.setAntiTheftSystem(true);
        protectionDTO.setRemoteKeylessEntry(true);
        protectionDTO.setAlarmSystem(true);
        protectionDTO.setAirbags(true);
        protectionDTO.setParkingSensors(true);
        protectionDTO.setBackupCamera(true);
        protectionDTO.setTirePressureMonitoring(true);

        // Check that the getter methods return the correct values
        assertTrue(protectionDTO.isAntiTheftSystem());
        assertTrue(protectionDTO.isRemoteKeylessEntry());
        assertTrue(protectionDTO.isAlarmSystem());
        assertTrue(protectionDTO.isAirbags());
        assertTrue(protectionDTO.isParkingSensors());
        assertTrue(protectionDTO.isBackupCamera());
        assertTrue(protectionDTO.isTirePressureMonitoring());
    }
}
