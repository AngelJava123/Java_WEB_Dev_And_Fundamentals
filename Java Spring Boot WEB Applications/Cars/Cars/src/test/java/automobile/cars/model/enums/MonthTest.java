package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MonthTest {
    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (Month month : Month.values()) {
            assertNotNull(month, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        Month[] expectedMonths = {
                Month.JANUARY,
                Month.FEBRUARY,
                Month.MARCH,
                Month.APRIL,
                Month.MAY,
                Month.JUNE,
                Month.JULY,
                Month.AUGUST,
                Month.SEPTEMBER,
                Month.OCTOBER,
                Month.NOVEMBER,
                Month.DECEMBER
        };

        // Act & Assert
        assertEquals(expectedMonths.length, Month.values().length, "Enum size should match");

        for (int i = 0; i < expectedMonths.length; i++) {
            assertEquals(expectedMonths[i], Month.values()[i], "Enum values should match");
        }
    }
}
