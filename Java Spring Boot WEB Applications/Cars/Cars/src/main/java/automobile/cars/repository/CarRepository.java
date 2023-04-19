package automobile.cars.repository;

import automobile.cars.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
  
  Page<Car> findByUser(User user, Pageable pageable);
  
  Optional<Car> findByMileage(String mileage);
}
