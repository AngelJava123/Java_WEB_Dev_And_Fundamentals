package automobile.cars.repository;

import automobile.cars.model.entity.VehicleCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryRepositoryTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void testFindByCategory() {
        // Arrange
        String category = "SUV";
        VehicleCategory expectedCategory = mock(VehicleCategory.class);

        when(categoryRepository.findByCategory(category)).thenReturn(expectedCategory);

        // Act
        VehicleCategory resultCategory = categoryRepository.findByCategory(category);

        // Assert
        assertThat(resultCategory).isEqualTo(expectedCategory);
    }
}
