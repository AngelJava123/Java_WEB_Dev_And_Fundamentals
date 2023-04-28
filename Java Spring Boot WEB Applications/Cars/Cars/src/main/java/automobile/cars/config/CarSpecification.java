package automobile.cars.config;

import automobile.cars.model.entity.Car;
import org.springframework.data.jpa.domain.Specification;

public interface CarSpecification {
    static Specification<Car> make(String make) {
        return (root, query, builder) -> {
            if (make == null || make.isEmpty()) {
                return null;
            }
            return builder.equal(root.get("make"), make);
        };
    }

    static Specification<Car> model(String model) {
        return (root, query, builder) -> {
            if (model == null || model.isEmpty()) {
                return null;
            }
            return builder.equal(root.get("model"), model);
        };
    }

    static Specification<Car> price(String price) {
        return (root, query, builder) -> {
            if (price == null || price.isEmpty()) {
                return null;
            }
            return builder.equal(root.get("price"), price);
        };
    }

    static Specification<Car> year(String year) {
        return (root, query, builder) -> {
            if (year == null || year.isEmpty()) {
                return null;
            }
            return builder.equal(root.get("year"), year);
        };
    }

    // Add more methods for other search fields
}

