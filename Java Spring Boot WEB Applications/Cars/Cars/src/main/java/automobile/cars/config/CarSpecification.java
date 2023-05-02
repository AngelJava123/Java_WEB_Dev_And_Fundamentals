package automobile.cars.config;

import automobile.cars.model.entity.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.JoinType;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

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

    static Specification<Car> price(int fromPrice, int toPrice) {
        return (root, query, builder) -> {
            if (fromPrice > 0 && toPrice > 0) {
                return builder.between(root.get("price"), fromPrice, toPrice);
            } else if (fromPrice > 0) {
                return builder.greaterThanOrEqualTo(root.get("price"), fromPrice);
            } else if (toPrice > 0) {
                return builder.lessThanOrEqualTo(root.get("price"), toPrice);
            } else {
                return null;
            }
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

    static Specification<Car> enginePower(int powerFrom, int powerTo) {
        return (root, query, builder) -> {
            if (powerFrom > 0 && powerTo > 0) {
                Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
                return builder.between(engineJoin.get("power"), powerFrom, powerTo);
            } else if (powerFrom > 0) {
                Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
                return builder.greaterThanOrEqualTo(engineJoin.get("power"), powerFrom);
            } else if (powerTo > 0) {
                Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
                return builder.lessThanOrEqualTo(engineJoin.get("power"), powerTo);
            } else {
                return null;
            }
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

    static Specification<Car> engineCubicCapacity(int cubicCapacityFrom, int cubicCapacityTo) {
        return (root, query, builder) -> {
            if (cubicCapacityFrom > 0 && cubicCapacityTo > 0) {
                Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
                return builder.between(engineJoin.get("cubicCapacity"), cubicCapacityFrom, cubicCapacityTo);
            } else if (cubicCapacityFrom > 0) {
                Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
                return builder.greaterThanOrEqualTo(engineJoin.get("cubicCapacity"), cubicCapacityFrom);
            } else if (cubicCapacityTo > 0) {
                Join<Car, VehicleEngine> engineJoin = root.join("engine", JoinType.LEFT);
                return builder.lessThanOrEqualTo(engineJoin.get("cubicCapacity"), cubicCapacityTo);
            } else {
                return null;
            }
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

    static Specification<Car> mileage(int mileage) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("mileage"), mileage);
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

    static Specification<Car> safetyFeatures(boolean abs, boolean esc, boolean acc, boolean ldw, boolean bsd, boolean fcw,
                                             boolean aeb, boolean rvc) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Car, VehicleSafety> safetyJoin = root.join("safety");
            if (abs) {
                predicates.add(builder.isTrue(safetyJoin.get("antiLockBrakingSystem")));
            }

            if (esc) {
                predicates.add(builder.isTrue(safetyJoin.get("electronicStabilityControl")));
            }

            if (acc) {
                predicates.add(builder.isTrue(safetyJoin.get("adaptiveCruiseControl")));
            }

            if (ldw) {
                predicates.add(builder.isTrue(safetyJoin.get("laneDepartureWarning")));
            }

            if (bsd) {
                predicates.add(builder.isTrue(safetyJoin.get("blindSpotDetection")));
            }

            if (fcw) {
                predicates.add(builder.isTrue(safetyJoin.get("forwardCollisionWarning")));
            }

            if (aeb) {
                predicates.add(builder.isTrue(safetyJoin.get("automaticEmergencyBraking")));
            }

            if (rvc) {
                predicates.add(builder.isTrue(safetyJoin.get("rearviewCamera")));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    static Specification<Car> exteriorFeatures(boolean alloyWheels, boolean powerSideMirrorAdjustment,
                                               boolean rainSensingWipers, boolean sunroof, boolean ledHeadlights,
                                               boolean fogLights, boolean automaticHeadlights) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<Car, VehicleExterior> vehicleExteriorJoin = root.join("exterior");

            if (alloyWheels) {
                predicates.add(builder.isTrue(vehicleExteriorJoin.get("alloyWheels")));
            }

            if (powerSideMirrorAdjustment) {
                predicates.add(builder.isTrue(vehicleExteriorJoin.get("powerSideMirrorAdjustment")));
            }

            if (rainSensingWipers) {
                predicates.add(builder.isTrue(vehicleExteriorJoin.get("rainSensingWipers")));
            }

            if (sunroof) {
                predicates.add(builder.isTrue(vehicleExteriorJoin.get("sunroof")));
            }

            if (ledHeadlights) {
                predicates.add(builder.isTrue(vehicleExteriorJoin.get("ledHeadlights")));
            }

            if (fogLights) {
                predicates.add(builder.isTrue(vehicleExteriorJoin.get("fogLights")));
            }

            if (automaticHeadlights) {
                predicates.add(builder.isTrue(vehicleExteriorJoin.get("automaticHeadlights")));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    static Specification<Car> interiorFeatures(boolean leatherSeats, boolean heatedSeats, boolean powerWindows,
                                               boolean powerLocks, boolean sunroof, boolean navigationSystem,
                                               boolean bluetooth, boolean backupCamera, boolean pushButtonStart,
                                               boolean dualClimateControl) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<Car, VehicleInterior> vehicleInteriorJoin = root.join("interior");

            if (leatherSeats) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("leatherSeats")));
            }

            if (heatedSeats) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("heatedSeats")));
            }

            if (powerWindows) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("powerWindows")));
            }

            if (powerLocks) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("powerLocks")));
            }

            if (sunroof) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("sunroof")));
            }

            if (navigationSystem) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("navigationSystem")));
            }

            if (bluetooth) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("bluetooth")));
            }

            if (backupCamera) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("backupCamera")));
            }

            if (pushButtonStart) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("pushButtonStart")));
            }

            if (dualClimateControl) {
                predicates.add(builder.isTrue(vehicleInteriorJoin.get("dualClimateControl")));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    static Specification<Car> protectionFeatures(boolean antiTheftSystem, boolean remoteKeylessEntry,
                                                 boolean alarmSystem, boolean airbags, boolean parkingSensors,
                                                 boolean backupCamera, boolean tirePressureMonitoring) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<Car, VehicleProtection> vehicleProtectionJoin = root.join("protection");

            if (antiTheftSystem) {
                predicates.add(builder.isTrue(vehicleProtectionJoin.get("antiTheftSystem")));
            }

            if (remoteKeylessEntry) {
                predicates.add(builder.isTrue(vehicleProtectionJoin.get("remoteKeylessEntry")));
            }

            if (alarmSystem) {
                predicates.add(builder.isTrue(vehicleProtectionJoin.get("alarmSystem")));
            }

            if (airbags) {
                predicates.add(builder.isTrue(vehicleProtectionJoin.get("airbags")));
            }

            if (parkingSensors) {
                predicates.add(builder.isTrue(vehicleProtectionJoin.get("parkingSensors")));
            }

            if (backupCamera) {
                predicates.add(builder.isTrue(vehicleProtectionJoin.get("backupCamera")));
            }

            if (tirePressureMonitoring) {
                predicates.add(builder.isTrue(vehicleProtectionJoin.get("tirePressureMonitoring")));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    static Specification<Car> comfortFeatures(boolean airConditioning, boolean cruiseControl, boolean powerSteering,
                                              boolean tiltSteeringWheel, boolean telescopingSteeringWheel, boolean rearDefrost,
                                              boolean remoteTrunkRelease, boolean remoteEngineStart, boolean heatedSteeringWheel,
                                              boolean heatedMirrors) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<Car, VehicleComfort> vehicleComfortJoin = root.join("comfort");

            if (airConditioning) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("airConditioning")));
            }

            if (cruiseControl) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("cruiseControl")));
            }

            if (powerSteering) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("powerSteering")));
            }

            if (tiltSteeringWheel) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("tiltSteeringWheel")));
            }

            if (telescopingSteeringWheel) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("telescopingSteeringWheel")));
            }

            if (rearDefrost) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("rearDefrost")));
            }

            if (remoteTrunkRelease) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("remoteTrunkRelease")));
            }

            if (remoteEngineStart) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("remoteEngineStart")));
            }

            if (heatedSteeringWheel) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("heatedSteeringWheel")));
            }

            if (heatedMirrors) {
                predicates.add(builder.isTrue(vehicleComfortJoin.get("heatedMirrors")));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    static Specification<Car> otherFeatures(boolean powerTailgate, boolean panoramicSunroof, boolean adaptiveHeadlights,
                                            boolean appleCarPlay, boolean androidAuto, boolean wirelessCharging,
                                            boolean premiumSoundSystem, boolean multiZoneClimateControl,
                                            boolean powerAdjustablePedals, boolean heatedRearSeats) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<Car, VehicleOther> vehicleOtherJoin = root.join("other");

            if (powerTailgate) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("powerTailgate")));
            }

            if (panoramicSunroof) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("panoramicSunroof")));
            }

            if (adaptiveHeadlights) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("adaptiveHeadlights")));
            }

            if (appleCarPlay) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("appleCarPlay")));
            }

            if (androidAuto) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("androidAuto")));
            }

            if (wirelessCharging) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("wirelessCharging")));
            }

            if (premiumSoundSystem) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("premiumSoundSystem")));
            }

            if (multiZoneClimateControl) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("multiZoneClimateControl")));
            }

            if (powerAdjustablePedals) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("powerAdjustablePedals")));
            }

            if (heatedRearSeats) {
                predicates.add(builder.isTrue(vehicleOtherJoin.get("heatedRearSeats")));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }


    // Add more methods for other search fields
}

