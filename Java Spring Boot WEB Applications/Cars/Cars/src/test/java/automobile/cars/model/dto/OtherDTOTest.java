package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OtherDTOTest {

    private OtherDTO otherDTO;

    @Before
    public void setup() {
        otherDTO = new OtherDTO();
    }

    @Test
    public void testDefaultConstructor() {
        // Check that all other features are initially set to false
        assertFalse(otherDTO.isPowerTailgate());
        assertFalse(otherDTO.isPanoramicSunroof());
        assertFalse(otherDTO.isAdaptiveHeadlights());
        assertFalse(otherDTO.isAppleCarPlay());
        assertFalse(otherDTO.isAndroidAuto());
        assertFalse(otherDTO.isWirelessCharging());
        assertFalse(otherDTO.isPremiumSoundSystem());
        assertFalse(otherDTO.isMultiZoneClimateControl());
        assertFalse(otherDTO.isPowerAdjustablePedals());
        assertFalse(otherDTO.isHeatedRearSeats());
    }

    @Test
    public void testGettersAndSetters() {
        // Set the other features to true using the setter methods
        otherDTO.setPowerTailgate(true);
        otherDTO.setPanoramicSunroof(true);
        otherDTO.setAdaptiveHeadlights(true);
        otherDTO.setAppleCarPlay(true);
        otherDTO.setAndroidAuto(true);
        otherDTO.setWirelessCharging(true);
        otherDTO.setPremiumSoundSystem(true);
        otherDTO.setMultiZoneClimateControl(true);
        otherDTO.setPowerAdjustablePedals(true);
        otherDTO.setHeatedRearSeats(true);

        // Check that the getter methods return the correct values
        assertTrue(otherDTO.isPowerTailgate());
        assertTrue(otherDTO.isPanoramicSunroof());
        assertTrue(otherDTO.isAdaptiveHeadlights());
        assertTrue(otherDTO.isAppleCarPlay());
        assertTrue(otherDTO.isAndroidAuto());
        assertTrue(otherDTO.isWirelessCharging());
        assertTrue(otherDTO.isPremiumSoundSystem());
        assertTrue(otherDTO.isMultiZoneClimateControl());
        assertTrue(otherDTO.isPowerAdjustablePedals());
        assertTrue(otherDTO.isHeatedRearSeats());
    }
}
