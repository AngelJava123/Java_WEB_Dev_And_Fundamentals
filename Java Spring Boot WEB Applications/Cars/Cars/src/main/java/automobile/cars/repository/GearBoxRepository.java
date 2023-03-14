package automobile.cars.repository;

import automobile.cars.model.entity.VehicleGearBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearBoxRepository extends JpaRepository<VehicleGearBox, Long> {
}
