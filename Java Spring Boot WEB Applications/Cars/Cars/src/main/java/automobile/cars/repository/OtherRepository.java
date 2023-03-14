package automobile.cars.repository;

import automobile.cars.model.entity.VehicleOther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherRepository extends JpaRepository<VehicleOther, Long> {
}
