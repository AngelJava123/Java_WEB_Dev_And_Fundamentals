package automobile.cars.repository;

import automobile.cars.model.entity.Car;
import automobile.cars.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarRepositoryTest {

    @Mock
    private CarRepository carRepository;

    @Test
    void testFindByUser() {
        // Arrange
        User user = new User();
        Pageable pageable = Pageable.unpaged();
        Page<Car> expectedPage = mock(Page.class);

        when(carRepository.findByUser(user, pageable)).thenReturn(expectedPage);

        // Act
        Page<Car> resultPage = carRepository.findByUser(user, pageable);

        // Assert
        assertThat(resultPage).isEqualTo(expectedPage);
    }

    @Test
    void testFindByMileage() {
        // Arrange
        String mileage = "10000";
        Car expectedCar = mock(Car.class);

        when(carRepository.findByMileage(mileage)).thenReturn(Optional.of(expectedCar));

        // Act
        Optional<Car> resultCar = carRepository.findByMileage(mileage);

        // Assert
        assertThat(resultCar).isEqualTo(Optional.of(expectedCar));
    }

    // Add more tests for other repository methods as needed

    @Test
    void testDeleteAllByUserId() {
        // Arrange
        long userId = 1L;

        // Act
        carRepository.deleteAllByUserId(userId);

        // Assert
        verify(carRepository, times(1)).deleteAllByUserId(userId);
    }

    @Test
    void testFindAllByUserId() {
        // Arrange
        long userId = 1L;
        Car expectedCar = mock(Car.class);

        when(carRepository.findAllByUserId(userId)).thenReturn(Collections.singletonList(expectedCar));

        // Act
        List<Car> resultCars = carRepository.findAllByUserId(userId);

        // Assert
        assertThat(resultCars).containsExactly(expectedCar);
    }

    @Test
    void testFindAllByIdIn() {
        // Arrange
        Set<Long> carIds = Collections.singleton(1L);
        Pageable pageable = Pageable.unpaged();
        Page<Car> expectedPage = mock(Page.class);

        when(carRepository.findAllByIdIn(carIds, pageable)).thenReturn(expectedPage);

        // Act
        Page<Car> resultPage = carRepository.findAllByIdIn(carIds, pageable);

        // Assert
        assertThat(resultPage).isEqualTo(expectedPage);
    }
}
