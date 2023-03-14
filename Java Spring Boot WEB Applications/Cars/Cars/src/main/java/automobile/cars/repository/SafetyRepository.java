package automobile.cars.repository;

import automobile.cars.model.entity.VehicleSafety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafetyRepository extends JpaRepository<VehicleSafety, Long> {
}