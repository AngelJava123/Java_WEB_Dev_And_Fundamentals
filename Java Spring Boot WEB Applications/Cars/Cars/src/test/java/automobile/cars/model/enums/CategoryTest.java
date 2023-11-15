package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryTest {

    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (Category category : Category.values()) {
            assertNotNull(category, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        Category[] expectedCategories = {
                Category.SEDAN,
                Category.HATCHBACK,
                Category.SUV,
                Category.TRUCK,
                Category.SPORTS_CAR,
                Category.VAN
        };

        // Act & Assert
        assertEquals(expectedCategories.length, Category.values().length, "Enum size should match");

        for (int i = 0; i < expectedCategories.length; i++) {
            assertEquals(expectedCategories[i], Category.values()[i], "Enum values should match");
        }
    }
}
