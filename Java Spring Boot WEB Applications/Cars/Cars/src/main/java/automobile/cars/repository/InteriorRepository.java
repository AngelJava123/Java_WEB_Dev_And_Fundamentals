package automobile.cars.repository;

import automobile.cars.model.entity.VehicleInterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorRepository extends JpaRepository<VehicleInterior, Long> {
}
