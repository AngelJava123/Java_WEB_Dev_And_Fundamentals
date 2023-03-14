package automobile.cars.repository;

import automobile.cars.model.entity.VehicleExterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExteriorRepository extends JpaRepository<VehicleExterior, Long> {
}
