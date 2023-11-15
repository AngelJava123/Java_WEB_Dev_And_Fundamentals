package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoleEnumTest {

    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (RoleEnum role : RoleEnum.values()) {
            assertNotNull(role, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        RoleEnum[] expectedRoles = {
                RoleEnum.PRIVATE_USERS,
                RoleEnum.DEALERS
        };

        // Act & Assert
        assertEquals(expectedRoles.length, RoleEnum.values().length, "Enum size should match");

        for (int i = 0; i < expectedRoles.length; i++) {
            assertEquals(expectedRoles[i], RoleEnum.values()[i], "Enum values should match");
        }
    }
}
