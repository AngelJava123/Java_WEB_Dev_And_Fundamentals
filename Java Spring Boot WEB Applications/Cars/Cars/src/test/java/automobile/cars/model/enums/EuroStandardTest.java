package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EuroStandardTest {
    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (EuroStandard euroStandard : EuroStandard.values()) {
            assertNotNull(euroStandard, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        EuroStandard[] expectedEuroStandards = {
                EuroStandard.EURO_1,
                EuroStandard.EURO_2,
                EuroStandard.EURO_3,
                EuroStandard.EURO_4,
                EuroStandard.EURO_5,
                EuroStandard.EURO_6,
                EuroStandard.EURO_6D,
                EuroStandard.EURO_6D_TEMP,
                EuroStandard.EURO_7
        };

        // Act & Assert
        assertEquals(expectedEuroStandards.length, EuroStandard.values().length, "Enum size should match");

        for (int i = 0; i < expectedEuroStandards.length; i++) {
            assertEquals(expectedEuroStandards[i], EuroStandard.values()[i], "Enum values should match");
        }
    }
}
