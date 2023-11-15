package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GearBoxTypeTest {

    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (GearBoxType gearBoxType : GearBoxType.values()) {
            assertNotNull(gearBoxType, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        GearBoxType[] expectedGearBoxTypes = {
                GearBoxType.MANUAL,
                GearBoxType.AUTOMATIC,
                GearBoxType.SEMI_AUTOMATIC,
                GearBoxType.CVT,
                GearBoxType.DCT,
                GearBoxType.AMT
        };

        // Act & Assert
        assertEquals(expectedGearBoxTypes.length, GearBoxType.values().length, "Enum size should match");

        for (int i = 0; i < expectedGearBoxTypes.length; i++) {
            assertEquals(expectedGearBoxTypes[i], GearBoxType.values()[i], "Enum values should match");
        }
    }
}
