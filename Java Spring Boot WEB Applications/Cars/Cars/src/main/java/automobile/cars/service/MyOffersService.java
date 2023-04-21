package automobile.cars.service;

import automobile.cars.config.FileUploadUtil;
import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.model.entity.*;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.repository.*;
import automobile.cars.view.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MyOffersService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ColorRepository colorRepository;
    private final EngineRepository engineRepository;
    private final CategoryRepository categoryRepository;
    private final GearBoxRepository gearBoxRepository;
    private final SafetyRepository safetyRepository;
    private final ExteriorRepository exteriorRepository;
    private final InteriorRepository interiorRepository;
    private final ProtectionRepository protectionRepository;
    private final ComfortRepository comfortRepository;
    private final OtherRepository otherRepository;
    private final FileUploadUtil fileUploadUtil;

    public MyOffersService(UserRepository userRepository,
                           CarRepository carRepository,
                           ColorRepository colorRepository,
                           EngineRepository engineRepository,
                           CategoryRepository categoryRepository,
                           GearBoxRepository gearBoxRepository,
                           SafetyRepository safetyRepository,
                           ExteriorRepository exteriorRepository,
                           InteriorRepository interiorRepository,
                           ProtectionRepository protectionRepository,
                           ComfortRepository comfortRepository,
                           OtherRepository otherRepository,
                           FileUploadUtil fileUploadUtil) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.colorRepository = colorRepository;
        this.engineRepository = engineRepository;
        this.categoryRepository = categoryRepository;
        this.gearBoxRepository = gearBoxRepository;
        this.safetyRepository = safetyRepository;
        this.exteriorRepository = exteriorRepository;
        this.interiorRepository = interiorRepository;
        this.protectionRepository = protectionRepository;
        this.comfortRepository = comfortRepository;
        this.otherRepository = otherRepository;
        this.fileUploadUtil = fileUploadUtil;
    }

    @Transactional
    public Page<CarViewModel> getMyOffers(Pageable pageable, CarsDealershipUserDetails userDetails) {

        Optional<User> currentUser = this.userRepository.findByEmail(userDetails.getUsername());

        return carRepository.findByUser(currentUser.get(), pageable)
                .map(car -> {
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

                    return carViewModel;
                });
    }

    public void deleteById(Long id) {
        this.carRepository.deleteById(id);
    }

    public Optional<Car> getCarById(Long id) {
        return this.carRepository.findById(id);
    }

    public void updateCar(CreateCarDTO createCarDTO, Long carId) throws IOException {
        // Create a new car entity

        Optional<Car> optionalCar = getCarById(carId);

        Car car = optionalCar.get();

        // Set the car properties from the DTO

        car.setMake(createCarDTO.getMake());
        car.setModel(createCarDTO.getModel());

        // Price

        car.setPrice(createCarDTO.getPrice());

        // Month

        car.setMonth(createCarDTO.getMonth());

        // Year

        car.setYear(createCarDTO.getYear());

        // Contact Info

        car.setPhoneNumber(createCarDTO.getPhoneNumber());

        // Location

        car.setLocation(createCarDTO.getLocation());

        // Engine

        VehicleEngine engine = new VehicleEngine(createCarDTO.getEngine().getId(),
                createCarDTO.getEngine().getEngineType(),
                createCarDTO.getEngine().getPower(),
                createCarDTO.getEngine().getEuroStandard(),
                createCarDTO.getEngine().getCubicCapacity());

        this.engineRepository.save(engine);

        car.setEngine(engine);

        // Category

        VehicleCategory category = this.categoryRepository.findByCategory(createCarDTO.getCategory().getCategory());

        car.setCategory(category);

        // GearBox

        VehicleGearBox gearBox = this.gearBoxRepository.findByGearBoxType(createCarDTO.getGearBox().getGearBoxType());

        car.setGearBox(gearBox);

        // Mileage

        car.setMileage(createCarDTO.getMileage());

        // Color

        VehicleColor color = this.colorRepository.findByPaint(createCarDTO.getColor().getPaint());

        car.setColor(color);

        // Safety Features

        VehicleSafety safety = new VehicleSafety(createCarDTO.getSafety().getId(),
                createCarDTO.getSafety().isAntiLockBrakingSystem(),
                createCarDTO.getSafety().isElectronicStabilityControl(),
                createCarDTO.getSafety().isAdaptiveCruiseControl(),
                createCarDTO.getSafety().isLaneDepartureWarning(),
                createCarDTO.getSafety().isBlindSpotDetection(),
                createCarDTO.getSafety().isForwardCollisionWarning(),
                createCarDTO.getSafety().isAutomaticEmergencyBraking(),
                createCarDTO.getSafety().isRearviewCamera());

        this.safetyRepository.save(safety);

        car.setSafety(safety);

        // Exterior Features

        VehicleExterior exterior = new VehicleExterior(createCarDTO.getExterior().getId(),
                createCarDTO.getExterior().isAlloyWheels(),
                createCarDTO.getExterior().isPowerSideMirrorAdjustment(),
                createCarDTO.getExterior().isRainSensingWipers(),
                createCarDTO.getExterior().isSunroof(),
                createCarDTO.getExterior().isLedHeadlights(),
                createCarDTO.getExterior().isFogLights(),
                createCarDTO.getExterior().isAutomaticHeadlights());

        this.exteriorRepository.save(exterior);

        car.setExterior(exterior);

        // Interior Features

        VehicleInterior interior = new VehicleInterior(createCarDTO.getInterior().getId(),
                createCarDTO.getInterior().isLeatherSeats(),
                createCarDTO.getInterior().isHeatedSeats(),
                createCarDTO.getInterior().isPowerWindows(),
                createCarDTO.getInterior().isPowerLocks(),
                createCarDTO.getInterior().isSunroof(),
                createCarDTO.getInterior().isNavigationSystem(),
                createCarDTO.getInterior().isBluetooth(),
                createCarDTO.getInterior().isBackupCamera(),
                createCarDTO.getInterior().isPushButtonStart(),
                createCarDTO.getInterior().isDualClimateControl());

        this.interiorRepository.save(interior);

        car.setInterior(interior);

        // Protection Features

        VehicleProtection protection = new VehicleProtection(createCarDTO.getProtection().getId(),
                createCarDTO.getProtection().isAntiTheftSystem(),
                createCarDTO.getProtection().isRemoteKeylessEntry(),
                createCarDTO.getProtection().isAlarmSystem(),
                createCarDTO.getProtection().isAirbags(),
                createCarDTO.getProtection().isParkingSensors(),
                createCarDTO.getProtection().isBackupCamera(),
                createCarDTO.getProtection().isTirePressureMonitoring());

        this.protectionRepository.save(protection);

        car.setProtection(protection);

        // Comfort Features

        VehicleComfort comfort = new VehicleComfort(createCarDTO.getComfort().getId(),
                createCarDTO.getComfort().isAirConditioning(),
                createCarDTO.getComfort().isCruiseControl(),
                createCarDTO.getComfort().isPowerSteering(),
                createCarDTO.getComfort().isTiltSteeringWheel(),
                createCarDTO.getComfort().isTelescopingSteeringWheel(),
                createCarDTO.getComfort().isRearDefrost(),
                createCarDTO.getComfort().isRemoteTrunkRelease(),
                createCarDTO.getComfort().isRemoteEngineStart(),
                createCarDTO.getComfort().isHeatedSteeringWheel(),
                createCarDTO.getComfort().isHeatedMirrors());

        this.comfortRepository.save(comfort);

        car.setComfort(comfort);

        // Other Features

        VehicleOther other = new VehicleOther(createCarDTO.getOther().getId(),
                createCarDTO.getOther().isPowerTailgate(),
                createCarDTO.getOther().isPanoramicSunroof(),
                createCarDTO.getOther().isAdaptiveHeadlights(),
                createCarDTO.getOther().isAppleCarPlay(),
                createCarDTO.getOther().isAndroidAuto(),
                createCarDTO.getOther().isWirelessCharging(),
                createCarDTO.getOther().isPremiumSoundSystem(),
                createCarDTO.getOther().isMultiZoneClimateControl(),
                createCarDTO.getOther().isPowerAdjustablePedals(),
                createCarDTO.getOther().isHeatedRearSeats());

        this.otherRepository.save(other);

        car.setOther(other);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime newDateTime = now.plusHours(3);
        car.setDateAdded(newDateTime);

        // Additional Information

        car.setAdditionalInformation(createCarDTO.getAdditionalInformation());

        // Upload the images to Cloudinary and add the public URLs to the Car object
        List<String> imagePaths = new ArrayList<>();
        for (MultipartFile image : createCarDTO.getImageFiles()) {
            String imagePath = fileUploadUtil.uploadFile(image);
            imagePaths.add(imagePath);
        }

        // Set the image files to the car entity
        car.setImageFilePaths(imagePaths);

        // Save the car entity to the database

        carRepository.save(car);
    }
}
