package automobile.cars.model.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private List<MultipartFile> imageFiles;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Image> images;

    @NotNull
    private String price;

    @NotNull
    @OneToOne
    private VehicleProductionDate productionDate;

    @NotNull
    @OneToOne
    private VehicleEngine engine;

    @NotNull
    @OneToOne
    private VehicleCategory category;

    @NotNull
    @OneToOne
    private VehicleGearBox gearBox;

    @NotNull
    @OneToOne
    private VehicleMileage mileage;

    @NotNull
    @OneToOne
    private VehicleColor color;

    @NotNull
    @OneToOne
    private VehicleSafety safety;

    @NotNull
    @OneToOne
    private VehicleExterior exterior;

    @NotNull
    @OneToOne
    private VehicleInterior interior;

    @NotNull
    @OneToOne
    private VehicleProtection protection;

    @NotNull
    @OneToOne
    private VehicleComfort comfort;

    @NotNull
    @OneToOne
    private VehicleOther other;

    @NotNull
    @Column(name = "additional_information", columnDefinition = "TEXT")
    private String additionalInformation;

    public void addImage(Image image) {
        if (images == null) {
            images = new ArrayList<>();
        }
        images.add(image);
        image.setCar(this);
    }

    public void setImagesFromFiles() throws IOException {
        if (imageFiles != null && !imageFiles.isEmpty()) {
            for (MultipartFile file : imageFiles) {
                Image image = new Image();
                image.setCar(this);
                image.setUrl(file.getOriginalFilename());
                addImage(image);
            }
        }
    }
}
