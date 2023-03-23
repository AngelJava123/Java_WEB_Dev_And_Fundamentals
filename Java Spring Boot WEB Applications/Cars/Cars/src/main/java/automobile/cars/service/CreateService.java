package automobile.cars.service;

import automobile.cars.config.FileUploadUtil;
import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.model.entity.*;
import automobile.cars.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CreateService {

    private final static String uploadDir = "C:\\Users\\tasheva\\Desktop\\Cars\\Cars\\src\\main\\resources\\static\\assets\\uploads\\";

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

    public CreateService(CarRepository carRepository,
                         ColorRepository colorRepository,
                         EngineRepository engineRepository,
                         CategoryRepository categoryRepository,
                         GearBoxRepository gearBoxRepository,
                         SafetyRepository safetyRepository, ExteriorRepository exteriorRepository, InteriorRepository interiorRepository, ProtectionRepository protectionRepository, ComfortRepository comfortRepository, OtherRepository otherRepository) {
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
    }

    public boolean create(CreateCarDTO createCarDTO) throws IOException {
        // Create a new car entity

        Car car = new Car();

        // Set the car properties from the DTO

        car.setMake(createCarDTO.getMake());
        car.setModel(createCarDTO.getModel());

        // Price

        car.setPrice(createCarDTO.getPrice());

        // Month

        car.setMonth(createCarDTO.getMonth());

        // Year

        car.setYear(createCarDTO.getYear());

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
        LocalDateTime newDateTime = now.plusHours(2);
        car.setDateAdded(newDateTime);

        // Additional Information

        car.setAdditionalInformation(createCarDTO.getAdditionalInformation());

        // handle images
        List<String> imageFilePaths = new ArrayList<>();
        for (MultipartFile imageFile : createCarDTO.getImageFiles()) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(imageFile.getOriginalFilename()));
            String filePath = uploadDir + fileName;
            FileUploadUtil.saveFile(uploadDir, fileName, imageFile);
            imageFilePaths.add(filePath);
        }

        // Set the image files to the car entity
        car.setImageFilePaths(imageFilePaths);

        // Save the car entity to the database
        Car savedCar = carRepository.save(car);

        return savedCar.getId() != null;
    }
}
