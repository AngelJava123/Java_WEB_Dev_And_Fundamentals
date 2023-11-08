package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InteriorDTOTest {

    private InteriorDTO interiorDTO;

    @Before
    public void setup() {
        interiorDTO = new InteriorDTO();
    }

    @Test
    public void testDefaultConstructor() {
        // Check that all interior features are initially set to false
        assertFalse(interiorDTO.isLeatherSeats());
        assertFalse(interiorDTO.isHeatedSeats());
        assertFalse(interiorDTO.isPowerWindows());
        assertFalse(interiorDTO.isPowerLocks());
        assertFalse(interiorDTO.isSunroof());
        assertFalse(interiorDTO.isNavigationSystem());
        assertFalse(interiorDTO.isBluetooth());
        assertFalse(interiorDTO.isBackupCamera());
        assertFalse(interiorDTO.isPushButtonStart());
        assertFalse(interiorDTO.isDualClimateControl());
    }

    @Test
    public void testGettersAndSetters() {
        // Set the interior features to true using the setter methods
        interiorDTO.setLeatherSeats(true);
        interiorDTO.setHeatedSeats(true);
        interiorDTO.setPowerWindows(true);
        interiorDTO.setPowerLocks(true);
        interiorDTO.setSunroof(true);
        interiorDTO.setNavigationSystem(true);
        interiorDTO.setBluetooth(true);
        interiorDTO.setBackupCamera(true);
        interiorDTO.setPushButtonStart(true);
        interiorDTO.setDualClimateControl(true);

        // Check that the getter methods return the correct values
        assertTrue(interiorDTO.isLeatherSeats());
        assertTrue(interiorDTO.isHeatedSeats());
        assertTrue(interiorDTO.isPowerWindows());
        assertTrue(interiorDTO.isPowerLocks());
        assertTrue(interiorDTO.isSunroof());
        assertTrue(interiorDTO.isNavigationSystem());
        assertTrue(interiorDTO.isBluetooth());
        assertTrue(interiorDTO.isBackupCamera());
        assertTrue(interiorDTO.isPushButtonStart());
        assertTrue(interiorDTO.isDualClimateControl());
    }
}
