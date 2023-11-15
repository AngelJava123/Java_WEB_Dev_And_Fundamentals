package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaintTypeTest {

    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (PaintType paintType : PaintType.values()) {
            assertNotNull(paintType, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        PaintType[] expectedPaintTypes = {
                PaintType.METALLIC,
                PaintType.MATTE,
                PaintType.GLOSS
        };

        // Act & Assert
        assertEquals(expectedPaintTypes.length, PaintType.values().length, "Enum size should match");

        for (int i = 0; i < expectedPaintTypes.length; i++) {
            assertEquals(expectedPaintTypes[i], PaintType.values()[i], "Enum values should match");
        }
    }
}
