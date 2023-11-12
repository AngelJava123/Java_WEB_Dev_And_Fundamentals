package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleCategoryTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Long categoryId = 1L;
        String categoryName = "Sedan";

        // Act
        VehicleCategory category = new VehicleCategory();
        category.setId(categoryId);
        category.setCategory(categoryName);

        // Assert
        assertEquals(categoryId, category.getId());
        assertEquals(categoryName, category.getCategory());
    }

    @Test
    void testParameterizedConstructor() {
        // Arrange
        Long categoryId = 1L;
        String categoryName = "SUV";

        // Act
        VehicleCategory category = new VehicleCategory(categoryId, categoryName);

        // Assert
        assertEquals(categoryId, category.getId());
        assertEquals(categoryName, category.getCategory());
    }

    @Test
    void testNotNullConstraints() {
        // Act
        VehicleCategory category = new VehicleCategory();

        // Assert
        assertNull(category.getId()); // Assuming id is null until generated by the database
        assertNull(category.getCategory()); // Expecting category to be null initially
    }
}
