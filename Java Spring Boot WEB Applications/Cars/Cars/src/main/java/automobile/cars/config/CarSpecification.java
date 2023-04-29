package automobile.cars.config;

import automobile.cars.model.entity.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.JoinType;

import javax.persistence.criteria.Join;

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

    static Specification<Car> engineType(String engineType) {
        return (root, query, builder) -> {
            if (engineType == null || engineType.isEmpty()) {
                return null;
            }
            Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
            return builder.equal(engineJoin.get("engineType"), engineType);
        };
    }

    static Specification<Car> enginePower(String enginePower) {
        return (root, query, builder) -> {
            if (enginePower == null || enginePower.isEmpty()) {
                return null;
            }
            Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
            return builder.equal(engineJoin.get("power"), enginePower);
        };
    }

    static Specification<Car> engineEuroStandard(String engineEuroStandard) {
        return (root, query, builder) -> {
            if (engineEuroStandard == null || engineEuroStandard.isEmpty()) {
                return null;
            }
            Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
            return builder.equal(engineJoin.get("euroStandard"), engineEuroStandard);
        };
    }

    static Specification<Car> engineCubicCapacity(String engineCubicCapacity) {
        return (root, query, builder) -> {
            if (engineCubicCapacity == null || engineCubicCapacity.isEmpty()) {
                return null;
            }
            Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
            return builder.equal(engineJoin.get("cubicCapacity"), engineCubicCapacity);
        };
    }

    static Specification<Car> category(String category) {
        return (root, query, builder) -> {
            if (category == null || category.isEmpty()) {
                return null;
            }
            Join<Car, VehicleCategory> engineJoin = root.join("category", JoinType.LEFT);
            return builder.equal(engineJoin.get("category"), category);
        };
    }

    static Specification<Car> gearBox(String gearBox) {
        return (root, query, builder) -> {
            if (gearBox == null || gearBox.isEmpty()) {
                return null;
            }
            Join<Car, VehicleGearBox> engineJoin = root.join("gearBox", JoinType.LEFT);
            return builder.equal(engineJoin.get("gearBoxType"), gearBox);
        };
    }

    static Specification<Car> mileage(String mileage) {
        return (root, query, builder) -> {
            if (mileage == null || mileage.isEmpty()) {
                return null;
            }
            return builder.equal(root.get("mileage"), mileage);
        };
    }

    static Specification<Car> color(String color) {
        return (root, query, builder) -> {
            if (color == null || color.isEmpty()) {
                return null;
            }
            Join<Car, VehicleColor> engineJoin = root.join("color", JoinType.LEFT);
            return builder.equal(engineJoin.get("paint"), color);
        };
    }

    // Add more methods for other search fields
}

