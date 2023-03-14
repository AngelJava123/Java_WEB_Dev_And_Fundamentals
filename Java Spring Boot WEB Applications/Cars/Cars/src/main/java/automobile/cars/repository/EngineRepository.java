package automobile.cars.repository;

import automobile.cars.model.entity.VehicleEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<VehicleEngine, Long> {
}
