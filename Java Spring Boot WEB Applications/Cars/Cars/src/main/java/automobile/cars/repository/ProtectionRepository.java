package automobile.cars.repository;

import automobile.cars.model.entity.VehicleProtection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtectionRepository extends JpaRepository<VehicleProtection, Long> {
}
