package automobile.cars.service;

import automobile.cars.model.entity.Car;
import automobile.cars.repository.CarRepository;
import automobile.cars.view.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarDetailsService {

    private final CarRepository carRepository;

    public CarDetailsService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarViewModel findById(Long id) {
        CarViewModel carViewModel = new CarViewModel();

        Optional<Car> car = carRepository.findById(id);

        if (car.isPresent()) {
            carViewModel.setId(car.get().getId());
            carViewModel.setMake(car.get().getMake());
            carViewModel.setModel(car.get().getModel());
            carViewModel.setPrice(car.get().getPrice());
            carViewModel.setMonth(car.get().getMonth());
            carViewModel.setYear(car.get().getYear());
            carViewModel.setImageFilePaths(car.get().getImageFilePaths());

            // Engine
            VehicleEngineViewModel engineViewModel = new VehicleEngineViewModel();
            engineViewModel.setEngineType(car.get().getEngine().getEngineType());
            engineViewModel.setCubicCapacity(car.get().getEngine().getCubicCapacity());
            engineViewModel.setEuroStandard(car.get().getEngine().getEuroStandard());
            engineViewModel.setPower(car.get().getEngine().getPower());
            carViewModel.setEngineViewModel(engineViewModel);

            carViewModel.setCategory(car.get().getCategory().getCategory());
            carViewModel.setGearBoxType(car.get().getGearBox().getGearBoxType());
            carViewModel.setMileage(car.get().getMileage());
            carViewModel.setPaint(car.get().getColor().getPaint());

            // Safety
            VehicleSafetyViewModel safetyViewModel = new VehicleSafetyViewModel();
            safetyViewModel.setAntiLockBrakingSystem(car.get().getSafety().isAntiLockBrakingSystem());
            safetyViewModel.setElectronicStabilityControl(car.get().getSafety().isElectronicStabilityControl());
            safetyViewModel.setAdaptiveCruiseControl(car.get().getSafety().isAdaptiveCruiseControl());
            safetyViewModel.setLaneDepartureWarning(car.get().getSafety().isLaneDepartureWarning());
            safetyViewModel.setBlindSpotDetection(car.get().getSafety().isBlindSpotDetection());
            safetyViewModel.setForwardCollisionWarning(car.get().getSafety().isForwardCollisionWarning());
            safetyViewModel.setAutomaticEmergencyBraking(car.get().getSafety().isAutomaticEmergencyBraking());
            safetyViewModel.setRearviewCamera(car.get().getSafety().isRearviewCamera());
            carViewModel.setSafetyViewModel(safetyViewModel);

            // Exterior
            VehicleExteriorViewModel exteriorViewModel = new VehicleExteriorViewModel();
            exteriorViewModel.setAlloyWheels(car.get().getExterior().isAlloyWheels());
            exteriorViewModel.setPowerSideMirrorAdjustment(car.get().getExterior().isPowerSideMirrorAdjustment());
            exteriorViewModel.setRainSensingWipers(car.get().getExterior().isRainSensingWipers());
            exteriorViewModel.setSunroof(car.get().getExterior().isSunroof());
            exteriorViewModel.setLedHeadlights(car.get().getExterior().isLedHeadlights());
            exteriorViewModel.setFogLights(car.get().getExterior().isFogLights());
            exteriorViewModel.setAutomaticHeadlights(car.get().getExterior().isAutomaticHeadlights());
            carViewModel.setExteriorViewModel(exteriorViewModel);

            // Interior
            VehicleInteriorViewModel interiorViewModel = new VehicleInteriorViewModel();
            interiorViewModel.setLeatherSeats(car.get().getInterior().isLeatherSeats());
            interiorViewModel.setHeatedSeats(car.get().getInterior().isHeatedSeats());
            interiorViewModel.setPowerWindows(car.get().getInterior().isPowerWindows());
            interiorViewModel.setPowerLocks(car.get().getInterior().isPowerLocks());
            interiorViewModel.setSunroof(car.get().getInterior().isSunroof());
            interiorViewModel.setNavigationSystem(car.get().getInterior().isNavigationSystem());
            interiorViewModel.setBluetooth(car.get().getInterior().isBluetooth());
            interiorViewModel.setBackupCamera(car.get().getInterior().isBackupCamera());
            interiorViewModel.setPushButtonStart(car.get().getInterior().isPushButtonStart());
            interiorViewModel.setDualClimateControl(car.get().getInterior().isDualClimateControl());
            carViewModel.setInteriorViewModel(interiorViewModel);

            // Protection
            VehicleProtectionViewModel protectionViewModel = new VehicleProtectionViewModel();
            protectionViewModel.setAntiTheftSystem(car.get().getProtection().isAntiTheftSystem());
            protectionViewModel.setRemoteKeylessEntry(car.get().getProtection().isRemoteKeylessEntry());
            protectionViewModel.setAlarmSystem(car.get().getProtection().isAlarmSystem());
            protectionViewModel.setAirbags(car.get().getProtection().isAirbags());
            protectionViewModel.setParkingSensors(car.get().getProtection().isParkingSensors());
            protectionViewModel.setBackupCamera(car.get().getProtection().isBackupCamera());
            protectionViewModel.setTirePressureMonitoring(car.get().getProtection().isTirePressureMonitoring());
            carViewModel.setProtectionViewModel(protectionViewModel);

            // Comfort
            VehicleComfortViewModel comfortViewModel = new VehicleComfortViewModel();
            comfortViewModel.setAirConditioning(car.get().getComfort().isAirConditioning());
            comfortViewModel.setCruiseControl(car.get().getComfort().isCruiseControl());
            comfortViewModel.setPowerSteering(car.get().getComfort().isPowerSteering());
            comfortViewModel.setTiltSteeringWheel(car.get().getComfort().isTiltSteeringWheel());
            comfortViewModel.setTelescopingSteeringWheel(car.get().getComfort().isTelescopingSteeringWheel());
            comfortViewModel.setRearDefrost(car.get().getComfort().isRearDefrost());
            comfortViewModel.setRemoteTrunkRelease(car.get().getComfort().isRemoteTrunkRelease());
            comfortViewModel.setRemoteEngineStart(car.get().getComfort().isRemoteEngineStart());
            comfortViewModel.setHeatedSteeringWheel(car.get().getComfort().isHeatedSteeringWheel());
            comfortViewModel.setHeatedMirrors(car.get().getComfort().isHeatedMirrors());
            carViewModel.setComfortViewModel(comfortViewModel);

            // Other
            VehicleOtherViewModel otherViewModel = new VehicleOtherViewModel();
            otherViewModel.setPowerTailgate(car.get().getOther().isPowerTailgate());
            otherViewModel.setPanoramicSunroof(car.get().getOther().isPanoramicSunroof());
            otherViewModel.setAdaptiveHeadlights(car.get().getOther().isAdaptiveHeadlights());
            otherViewModel.setAppleCarPlay(car.get().getOther().isAppleCarPlay());
            otherViewModel.setAndroidAuto(car.get().getOther().isAndroidAuto());
            otherViewModel.setWirelessCharging(car.get().getOther().isWirelessCharging());
            otherViewModel.setPremiumSoundSystem(car.get().getOther().isPremiumSoundSystem());
            otherViewModel.setMultiZoneClimateControl(car.get().getOther().isMultiZoneClimateControl());
            otherViewModel.setPowerAdjustablePedals(car.get().getOther().isPowerAdjustablePedals());
            otherViewModel.setHeatedRearSeats(car.get().getOther().isHeatedRearSeats());
            carViewModel.setOtherViewModel(otherViewModel);

            carViewModel.setAdditionalInformation(car.get().getAdditionalInformation());
            carViewModel.setDateAdded(car.get().getDateAdded());
        }

        return carViewModel;
    }
}
