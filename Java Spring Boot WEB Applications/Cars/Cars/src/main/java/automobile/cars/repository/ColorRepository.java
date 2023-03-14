package automobile.cars.repository;

import automobile.cars.model.entity.VehicleColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<VehicleColor, Long> {
}
