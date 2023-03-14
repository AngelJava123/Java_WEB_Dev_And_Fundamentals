package automobile.cars.repository;

import automobile.cars.model.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<VehicleCategory, Long> {
}
