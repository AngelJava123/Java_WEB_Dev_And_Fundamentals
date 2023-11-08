package automobile.cars.model.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExteriorDTOTest {

    private ExteriorDTO exteriorDTO;

    @Before
    public void setup() {
        exteriorDTO = new ExteriorDTO();
    }

    @Test
    public void testDefaultConstructor() {
        // Check that all exterior features are initially set to false
        assertFalse(exteriorDTO.isAlloyWheels());
        assertFalse(exteriorDTO.isPowerSideMirrorAdjustment());
        assertFalse(exteriorDTO.isRainSensingWipers());
        assertFalse(exteriorDTO.isSunroof());
        assertFalse(exteriorDTO.isLedHeadlights());
        assertFalse(exteriorDTO.isFogLights());
        assertFalse(exteriorDTO.isAutomaticHeadlights());
    }

    @Test
    public void testGettersAndSetters() {
        // Set the exterior features to true using the setter methods
        exteriorDTO.setAlloyWheels(true);
        exteriorDTO.setPowerSideMirrorAdjustment(true);
        exteriorDTO.setRainSensingWipers(true);
        exteriorDTO.setSunroof(true);
        exteriorDTO.setLedHeadlights(true);
        exteriorDTO.setFogLights(true);
        exteriorDTO.setAutomaticHeadlights(true);

        // Check that the getter methods return the correct values
        assertTrue(exteriorDTO.isAlloyWheels());
        assertTrue(exteriorDTO.isPowerSideMirrorAdjustment());
        assertTrue(exteriorDTO.isRainSensingWipers());
        assertTrue(exteriorDTO.isSunroof());
        assertTrue(exteriorDTO.isLedHeadlights());
        assertTrue(exteriorDTO.isFogLights());
        assertTrue(exteriorDTO.isAutomaticHeadlights());
    }
}
