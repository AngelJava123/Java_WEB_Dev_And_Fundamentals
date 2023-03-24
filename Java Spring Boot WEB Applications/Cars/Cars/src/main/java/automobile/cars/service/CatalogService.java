package automobile.cars.service;

import automobile.cars.repository.CarRepository;
import automobile.cars.view.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {

    private final CarRepository carRepository;

    public CatalogService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public List<CarViewModel> getAllCars() {
        return carRepository.findAll()
                .stream().map(car -> {
                    CarViewModel carViewModel = new CarViewModel();

                    carViewModel.setId(car.getId());
                    carViewModel.setMake(car.getMake());
                    carViewModel.setModel(car.getModel());
                    carViewModel.setPrice(car.getPrice());
                    carViewModel.setMonth(car.getMonth());
                    carViewModel.setYear(car.getYear());
                    carViewModel.setImageFilePaths(car.getImageFilePaths());

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

                    return carViewModel;
                }).collect(Collectors.toList());
    }
}
