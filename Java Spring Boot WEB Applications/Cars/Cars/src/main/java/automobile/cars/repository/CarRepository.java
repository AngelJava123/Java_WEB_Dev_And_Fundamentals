package automobile.cars.repository;

import automobile.cars.model.entity.Car;
import automobile.cars.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Page<Car> findByUser(User user, Pageable pageable);

    Optional<Car> findByMileage(String mileage);

    Page<Car> findByFavouriteTrue(Pageable pageable);

    Page<Car> findAll(Specification<Car> spec, Pageable pageable);

}
