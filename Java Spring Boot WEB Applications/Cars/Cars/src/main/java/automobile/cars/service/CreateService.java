package automobile.cars.service;

import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.model.entity.*;
import automobile.cars.repository.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CreateService {

    private final ImageRepository imageRepository;
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

    public CreateService(ImageRepository imageRepository,
                         CarRepository carRepository,
                         ColorRepository colorRepository,
                         EngineRepository engineRepository,
                         CategoryRepository categoryRepository,
                         GearBoxRepository gearBoxRepository,
                         SafetyRepository safetyRepository, ExteriorRepository exteriorRepository, InteriorRepository interiorRepository, ProtectionRepository protectionRepository, ComfortRepository comfortRepository, OtherRepository otherRepository) {
        this.imageRepository = imageRepository;
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

        VehicleCategory category = new VehicleCategory(createCarDTO.getCategory().getId(),
                createCarDTO.getCategory().getCategory());

        this.categoryRepository.save(category);

        car.setCategory(category);

        // GearBox

        VehicleGearBox gearBox = new VehicleGearBox(createCarDTO.getGearBox().getId(),
                createCarDTO.getGearBox().getGearBoxType());

        this.gearBoxRepository.save(gearBox);

        car.setGearBox(gearBox);

        // Mileage

        car.setMileage(createCarDTO.getMileage());

        // Color

        VehicleColor vehicleColor = new VehicleColor(createCarDTO.getColor().getId(),
                createCarDTO.getColor().getPaint());

        this.colorRepository.save(vehicleColor);

        car.setColor(vehicleColor);

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

        // Additional Information

        car.setAdditionalInformation(createCarDTO.getAdditionalInformation());

        // Save the car entity to the database
        carRepository.save(car);

        // Set the image files to the car entity
        car.setImageFiles(createCarDTO.getImageFiles());

        // Convert the image files to image entities and save them to the database
        List<Image> images = car.getImages();
        if (images != null && !images.isEmpty()) {
            for (Image image : images) {
                imageRepository.save(image);
            }
        }

        return true;
    }

}
