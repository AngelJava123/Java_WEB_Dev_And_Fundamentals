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
    private String make;

    @NotNull
    private String model;

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
    private String mileage;

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

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MultipartFile> getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(List<MultipartFile> imageFiles) {
        this.imageFiles = imageFiles;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public VehicleProductionDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(VehicleProductionDate productionDate) {
        this.productionDate = productionDate;
    }

    public VehicleEngine getEngine() {
        return engine;
    }

    public void setEngine(VehicleEngine engine) {
        this.engine = engine;
    }

    public VehicleCategory getCategory() {
        return category;
    }

    public void setCategory(VehicleCategory category) {
        this.category = category;
    }

    public VehicleGearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(VehicleGearBox gearBox) {
        this.gearBox = gearBox;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public VehicleColor getColor() {
        return color;
    }

    public void setColor(VehicleColor color) {
        this.color = color;
    }

    public VehicleSafety getSafety() {
        return safety;
    }

    public void setSafety(VehicleSafety safety) {
        this.safety = safety;
    }

    public VehicleExterior getExterior() {
        return exterior;
    }

    public void setExterior(VehicleExterior exterior) {
        this.exterior = exterior;
    }

    public VehicleInterior getInterior() {
        return interior;
    }

    public void setInterior(VehicleInterior interior) {
        this.interior = interior;
    }

    public VehicleProtection getProtection() {
        return protection;
    }

    public void setProtection(VehicleProtection protection) {
        this.protection = protection;
    }

    public VehicleComfort getComfort() {
        return comfort;
    }

    public void setComfort(VehicleComfort comfort) {
        this.comfort = comfort;
    }

    public VehicleOther getOther() {
        return other;
    }

    public void setOther(VehicleOther other) {
        this.other = other;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
