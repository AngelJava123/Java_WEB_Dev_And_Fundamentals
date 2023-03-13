package automobile.cars.service;

import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.model.entity.Car;
import automobile.cars.model.entity.Image;
import automobile.cars.repository.CarRepository;
import automobile.cars.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CreateService {

    private final ImageRepository imageRepository;
    private final CarRepository carRepository;

    public CreateService(ImageRepository imageRepository, CarRepository carRepository) {
        this.imageRepository = imageRepository;
        this.carRepository = carRepository;
    }

    public boolean create(CreateCarDTO createCarDTO) throws IOException {
        // Create a new car entity
        Car car = new Car();

        // Set the car properties from the DTO
        // car.setMake(createCarDTO.getMake());
        // car.setModel(createCarDTO.getModel());
        // car.getColor().getPaint()
        // car.setBodyType(createCarDTO.getBodyType());
        // car.setColor(createCarDTO.getColor());
        // car.setTransmission(createCarDTO.getTransmission());
        // car.setEngine(createCarDTO.getEngine());
        // car.setDriveType(createCarDTO.getDriveType());
        // car.setMileage(createCarDTO.getMileage());
        // car.setPrice(createCarDTO.getPrice());
        // car.setVin(createCarDTO.getVin());
        // car.setDescription(createCarDTO.getDescription());
        // car.setFuelType(createCarDTO.getFuelType());
        // car.setFuelEconomy(createCarDTO.getFuelEconomy());
        // car.setCondition(createCarDTO.getCondition());
        // car.setAirConditioning(createCarDTO.isAirConditioning());
        // car.setCruiseControl(createCarDTO.isCruiseControl());
        // car.setPowerSteering(createCarDTO.isPowerSteering());
        // car.setTiltSteeringWheel(createCarDTO.isTiltSteeringWheel());
        // car.setTelescopingSteeringWheel(createCarDTO.isTelescopingSteeringWheel());
        // car.setRearDefrost(createCarDTO.isRearDefrost());
        // car.setRemoteTrunkRelease(createCarDTO.isRemoteTrunkRelease());
        // car.setRemoteEngineStart(createCarDTO.isRemoteEngineStart());
        // car.setHeatedSteeringWheel(createCarDTO.isHeatedSteeringWheel());
        // car.setHeatedMirrors(createCarDTO.isHeatedMirrors());
        // car.setPowerTailgate(createCarDTO.isPowerTailgate());
        // car.setPanoramicSunroof(createCarDTO.isPanoramicSunroof());
        // car.setAdaptiveHeadlights(createCarDTO.isAdaptiveHeadlights());
        // car.setAppleCarPlay(createCarDTO.isAppleCarPlay());
        // car.setAndroidAuto(createCarDTO.isAndroidAuto());
        // car.setWirelessCharging(createCarDTO.isWirelessCharging());
        // car.setPremiumSoundSystem(createCarDTO.isPremiumSoundSystem());
        // car.setMultiZoneClimateControl(createCarDTO.isMultiZoneClimateControl());
        // car.setPowerAdjustablePedals(createCarDTO.isPowerAdjustablePedals());
        // car.setHeatedRearSeats(createCarDTO.isHeatedRearSeats());
        // car.setAdditionalInformation(createCarDTO.getAdditionalInformation());

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
