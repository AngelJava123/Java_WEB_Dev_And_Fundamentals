package automobile.cars.service;

import automobile.cars.config.CarSpecification;
import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.model.entity.Car;
import automobile.cars.repository.CarRepository;
import automobile.cars.view.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class SearchService {

    private final CarRepository carRepository;

    public SearchService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Page<CarViewModel> searchCars(CreateCarDTO car, Pageable pageable) {
        Specification<Car> spec = Specification.where(null);

        if (car.getMake() != null && !car.getMake().isEmpty()) {
            spec = spec.and(CarSpecification.make(car.getMake()));
        }

        if (car.getModel() != null && !car.getModel().isEmpty()) {
            spec = spec.and(CarSpecification.model(car.getModel()));
        }

        if (car.getFromPrice() > 0 || car.getToPrice() > 0) {
            spec = spec.and(CarSpecification.price(car.getFromPrice(), car.getToPrice()));
        }

        if (car.getYear() != null && !car.getYear().isEmpty()) {
            spec = spec.and(CarSpecification.year(car.getYear()));
        }

        if (car.getEngine().getEngineType() != null && !car.getEngine().getEngineType().isEmpty()) {
            spec = spec.and(CarSpecification.engineType(car.getEngine().getEngineType()));
        }

        if (car.getEngine().getPowerFrom() > 0 || car.getEngine().getPowerTo() > 0) {
            spec = spec.and(CarSpecification.enginePower(car.getEngine().getPowerFrom(), car.getEngine().getPowerTo()));
        }

        if (car.getEngine().getEuroStandard() != null && !car.getEngine().getEuroStandard().isEmpty()) {
            spec = spec.and(CarSpecification.engineEuroStandard(car.getEngine().getEuroStandard()));
        }

        if (car.getEngine().getCubicCapacityFrom() > 0 || car.getEngine().getCubicCapacityTo() > 0) {
            spec = spec.and(CarSpecification.engineCubicCapacity(car.getEngine().getCubicCapacityFrom(), car.getEngine().getCubicCapacityTo()));
        }

        if (car.getCategory().getCategory() != null && !car.getCategory().getCategory().isEmpty()) {
            spec = spec.and(CarSpecification.category(car.getCategory().getCategory()));
        }

        if (car.getGearBox().getGearBoxType() != null && !car.getGearBox().getGearBoxType().isEmpty()) {
            spec = spec.and(CarSpecification.gearBox(car.getGearBox().getGearBoxType()));
        }

        if (car.getMileage() > 0) {
            spec = spec.and(CarSpecification.mileage(car.getMileage()));
        }

        if (car.getColor().getPaint() != null && !car.getColor().getPaint().isEmpty()) {
            spec = spec.and(CarSpecification.color(car.getColor().getPaint()));
        }

        if (car.getSafety() != null) {
            spec = spec.and(CarSpecification.safetyFeatures(
                    car.getSafety().isAntiLockBrakingSystem(),
                    car.getSafety().isElectronicStabilityControl(),
                    car.getSafety().isAdaptiveCruiseControl(),
                    car.getSafety().isLaneDepartureWarning(),
                    car.getSafety().isBlindSpotDetection(),
                    car.getSafety().isForwardCollisionWarning(),
                    car.getSafety().isAutomaticEmergencyBraking(),
                    car.getSafety().isRearviewCamera()
            ));
        }

        if (car.getExterior() != null) {
            spec = spec.and(CarSpecification.exteriorFeatures(
                    car.getExterior().isAlloyWheels(),
                    car.getExterior().isPowerSideMirrorAdjustment(),
                    car.getExterior().isRainSensingWipers(),
                    car.getExterior().isSunroof(),
                    car.getExterior().isLedHeadlights(),
                    car.getExterior().isFogLights(),
                    car.getExterior().isAutomaticHeadlights()
            ));
        }

        if (car.getInterior() != null) {
            spec = spec.and(CarSpecification.interiorFeatures(
                    car.getInterior().isLeatherSeats(),
                    car.getInterior().isHeatedSeats(),
                    car.getInterior().isPowerWindows(),
                    car.getInterior().isPowerLocks(),
                    car.getInterior().isSunroof(),
                    car.getInterior().isNavigationSystem(),
                    car.getInterior().isBluetooth(),
                    car.getInterior().isBackupCamera(),
                    car.getInterior().isPushButtonStart(),
                    car.getInterior().isDualClimateControl()
            ));
        }

        if (car.getProtection() != null) {
            spec = spec.and(CarSpecification.protectionFeatures(
                    car.getProtection().isAntiTheftSystem(),
                    car.getProtection().isRemoteKeylessEntry(),
                    car.getProtection().isAlarmSystem(),
                    car.getProtection().isAirbags(),
                    car.getProtection().isParkingSensors(),
                    car.getProtection().isBackupCamera(),
                    car.getProtection().isTirePressureMonitoring()
            ));
        }

        if (car.getComfort() != null) {
            spec = spec.and(CarSpecification.comfortFeatures(
                    car.getComfort().isAirConditioning(),
                    car.getComfort().isCruiseControl(),
                    car.getComfort().isPowerSteering(),
                    car.getComfort().isTiltSteeringWheel(),
                    car.getComfort().isTelescopingSteeringWheel(),
                    car.getComfort().isRearDefrost(),
                    car.getComfort().isRemoteTrunkRelease(),
                    car.getComfort().isRemoteEngineStart(),
                    car.getComfort().isHeatedSteeringWheel(),
                    car.getComfort().isHeatedMirrors()
            ));
        }

        if (car.getOther() != null) {
            spec = spec.and(CarSpecification.otherFeatures(
                    car.getOther().isPowerTailgate(),
                    car.getOther().isPanoramicSunroof(),
                    car.getOther().isAdaptiveHeadlights(),
                    car.getOther().isAppleCarPlay(),
                    car.getOther().isAndroidAuto(),
                    car.getOther().isWirelessCharging(),
                    car.getOther().isPremiumSoundSystem(),
                    car.getOther().isMultiZoneClimateControl(),
                    car.getOther().isPowerAdjustablePedals(),
                    car.getOther().isHeatedRearSeats()
            ));
        }

        // Add more conditions for other search fields

        Page<Car> cars = carRepository.findAll(spec, pageable);

        return cars.map(this::mapToCarViewModel);
    }


    private CarViewModel mapToCarViewModel(Car car) {
        CarViewModel carViewModel = new CarViewModel();

        carViewModel.setId(car.getId());
        carViewModel.setMake(car.getMake());
        carViewModel.setModel(car.getModel());
        carViewModel.setPrice(car.getPrice());
        carViewModel.setMonth(car.getMonth());
        carViewModel.setYear(car.getYear());
        carViewModel.setPhoneNumber(car.getPhoneNumber());
        carViewModel.setLocation(car.getLocation());
        carViewModel.setImageFilePaths(Collections.singletonList(car.getImageFilePaths().get(0)));

        // Engine
        VehicleEngineViewModel engineViewModel = new VehicleEngineViewModel();
        engineViewModel.setEngineType(car.getEngine().getEngineType());
        engineViewModel.setCubicCapacity(car.getEngine().getCubicCapacity());
        engineViewModel.setEuroStandard(car.getEngine().getEuroStandard());
        engineViewModel.setPower(car.getEngine().getPower());
        carViewModel.setEngineViewModel(engineViewModel);

        carViewModel.setCategory(car.getCategory().getCategory());
        carViewModel.setGearBoxType(car.getGearBox().getGearBoxType());
        carViewModel.setMileage(car.getMileage());
        carViewModel.setPaint(car.getColor().getPaint());

        // Safety
        VehicleSafetyViewModel safetyViewModel = new VehicleSafetyViewModel();
        safetyViewModel.setAntiLockBrakingSystem(car.getSafety().isAntiLockBrakingSystem());
        safetyViewModel.setElectronicStabilityControl(car.getSafety().isElectronicStabilityControl());
        safetyViewModel.setAdaptiveCruiseControl(car.getSafety().isAdaptiveCruiseControl());
        safetyViewModel.setLaneDepartureWarning(car.getSafety().isLaneDepartureWarning());
        safetyViewModel.setBlindSpotDetection(car.getSafety().isBlindSpotDetection());
        safetyViewModel.setForwardCollisionWarning(car.getSafety().isForwardCollisionWarning());
        safetyViewModel.setAutomaticEmergencyBraking(car.getSafety().isAutomaticEmergencyBraking());
        safetyViewModel.setRearviewCamera(car.getSafety().isRearviewCamera());
        carViewModel.setSafetyViewModel(safetyViewModel);

        // Exterior
        VehicleExteriorViewModel exteriorViewModel = new VehicleExteriorViewModel();
        exteriorViewModel.setAlloyWheels(car.getExterior().isAlloyWheels());
        exteriorViewModel.setPowerSideMirrorAdjustment(car.getExterior().isPowerSideMirrorAdjustment());
        exteriorViewModel.setRainSensingWipers(car.getExterior().isRainSensingWipers());
        exteriorViewModel.setSunroof(car.getExterior().isSunroof());
        exteriorViewModel.setLedHeadlights(car.getExterior().isLedHeadlights());
        exteriorViewModel.setFogLights(car.getExterior().isFogLights());
        exteriorViewModel.setAutomaticHeadlights(car.getExterior().isAutomaticHeadlights());
        carViewModel.setExteriorViewModel(exteriorViewModel);

        // Interior
        VehicleInteriorViewModel interiorViewModel = new VehicleInteriorViewModel();
        interiorViewModel.setLeatherSeats(car.getInterior().isLeatherSeats());
        interiorViewModel.setHeatedSeats(car.getInterior().isHeatedSeats());
        interiorViewModel.setPowerWindows(car.getInterior().isPowerWindows());
        interiorViewModel.setPowerLocks(car.getInterior().isPowerLocks());
        interiorViewModel.setSunroof(car.getInterior().isSunroof());
        interiorViewModel.setNavigationSystem(car.getInterior().isNavigationSystem());
        interiorViewModel.setBluetooth(car.getInterior().isBluetooth());
        interiorViewModel.setBackupCamera(car.getInterior().isBackupCamera());
        interiorViewModel.setPushButtonStart(car.getInterior().isPushButtonStart());
        interiorViewModel.setDualClimateControl(car.getInterior().isDualClimateControl());
        carViewModel.setInteriorViewModel(interiorViewModel);

        // Protection
        VehicleProtectionViewModel protectionViewModel = new VehicleProtectionViewModel();
        protectionViewModel.setAntiTheftSystem(car.getProtection().isAntiTheftSystem());
        protectionViewModel.setRemoteKeylessEntry(car.getProtection().isRemoteKeylessEntry());
        protectionViewModel.setAlarmSystem(car.getProtection().isAlarmSystem());
        protectionViewModel.setAirbags(car.getProtection().isAirbags());
        protectionViewModel.setParkingSensors(car.getProtection().isParkingSensors());
        protectionViewModel.setBackupCamera(car.getProtection().isBackupCamera());
        protectionViewModel.setTirePressureMonitoring(car.getProtection().isTirePressureMonitoring());
        carViewModel.setProtectionViewModel(protectionViewModel);

        // Comfort
        VehicleComfortViewModel comfortViewModel = new VehicleComfortViewModel();
        comfortViewModel.setAirConditioning(car.getComfort().isAirConditioning());
        comfortViewModel.setCruiseControl(car.getComfort().isCruiseControl());
        comfortViewModel.setPowerSteering(car.getComfort().isPowerSteering());
        comfortViewModel.setTiltSteeringWheel(car.getComfort().isTiltSteeringWheel());
        comfortViewModel.setTelescopingSteeringWheel(car.getComfort().isTelescopingSteeringWheel());
        comfortViewModel.setRearDefrost(car.getComfort().isRearDefrost());
        comfortViewModel.setRemoteTrunkRelease(car.getComfort().isRemoteTrunkRelease());
        comfortViewModel.setRemoteEngineStart(car.getComfort().isRemoteEngineStart());
        comfortViewModel.setHeatedSteeringWheel(car.getComfort().isHeatedSteeringWheel());
        comfortViewModel.setHeatedMirrors(car.getComfort().isHeatedMirrors());
        carViewModel.setComfortViewModel(comfortViewModel);

        // Other
        VehicleOtherViewModel otherViewModel = new VehicleOtherViewModel();
        otherViewModel.setPowerTailgate(car.getOther().isPowerTailgate());
        otherViewModel.setPanoramicSunroof(car.getOther().isPanoramicSunroof());
        otherViewModel.setAdaptiveHeadlights(car.getOther().isAdaptiveHeadlights());
        otherViewModel.setAppleCarPlay(car.getOther().isAppleCarPlay());
        otherViewModel.setAndroidAuto(car.getOther().isAndroidAuto());
        otherViewModel.setWirelessCharging(car.getOther().isWirelessCharging());
        otherViewModel.setPremiumSoundSystem(car.getOther().isPremiumSoundSystem());
        otherViewModel.setMultiZoneClimateControl(car.getOther().isMultiZoneClimateControl());
        otherViewModel.setPowerAdjustablePedals(car.getOther().isPowerAdjustablePedals());
        otherViewModel.setHeatedRearSeats(car.getOther().isHeatedRearSeats());
        carViewModel.setOtherViewModel(otherViewModel);

        carViewModel.setAdditionalInformation(car.getAdditionalInformation());
        carViewModel.setDateAdded(car.getDateAdded());
        carViewModel.setFavourite(car.isFavourite());

        return carViewModel;
    }
}
