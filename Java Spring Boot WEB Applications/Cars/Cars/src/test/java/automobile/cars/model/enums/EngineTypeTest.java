package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EngineTypeTest {

    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (EngineType engineType : EngineType.values()) {
            assertNotNull(engineType, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        EngineType[] expectedEngineTypes = {
                EngineType.GASOLINE,
                EngineType.DIESEL,
                EngineType.ELECTRIC,
                EngineType.HYBRID
        };

        // Act & Assert
        assertEquals(expectedEngineTypes.length, EngineType.values().length, "Enum size should match");

        for (int i = 0; i < expectedEngineTypes.length; i++) {
            assertEquals(expectedEngineTypes[i], EngineType.values()[i], "Enum values should match");
        }
    }
}
