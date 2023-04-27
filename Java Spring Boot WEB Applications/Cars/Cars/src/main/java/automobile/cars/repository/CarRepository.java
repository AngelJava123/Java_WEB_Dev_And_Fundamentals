package automobile.cars.repository;

import automobile.cars.model.entity.Car;
import automobile.cars.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Page<Car> findByUser(User user, Pageable pageable);

    Optional<Car> findByMileage(String mileage);

    Page<Car> findByFavouriteTrue(Pageable pageable);

    Page<Car> findAllByMakeAndModel(String make, String model, Pageable pageable);

    @Query(value = "SELECT * FROM cars WHERE make = COALESCE(:make, make) AND model = COALESCE(:model, model) AND year = COALESCE(:year, year)", nativeQuery = true)
    Page<Car> searchCars(@Param("make") String make,
                         @Param("model") String model,
                         @Param("year") String year,
                         Pageable pageable);


}
