package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NumberOfGearsTest {

    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (NumberOfGears gears : NumberOfGears.values()) {
            assertNotNull(gears, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        NumberOfGears[] expectedGears = {
                NumberOfGears.FOUR_SPEED,
                NumberOfGears.FIVE_SPEED,
                NumberOfGears.SIX_SPEED,
                NumberOfGears.SEVEN_SPEED,
                NumberOfGears.EIGHT_SPEED
        };

        // Act & Assert
        assertEquals(expectedGears.length, NumberOfGears.values().length, "Enum size should match");

        for (int i = 0; i < expectedGears.length; i++) {
            assertEquals(expectedGears[i], NumberOfGears.values()[i], "Enum values should match");
        }
    }
}
