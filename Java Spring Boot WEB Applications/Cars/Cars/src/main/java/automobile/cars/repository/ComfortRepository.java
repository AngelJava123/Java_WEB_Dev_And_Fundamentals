package automobile.cars.repository;

import automobile.cars.model.entity.VehicleComfort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComfortRepository extends JpaRepository<VehicleComfort, Long> {
}
