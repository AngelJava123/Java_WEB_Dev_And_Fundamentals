package automobile.cars.model.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class CreateCarDTO {

    private Long id;
    @NotEmpty(message = "At least one image is required")
    private List<MultipartFile> imageFiles = new ArrayList<>();
    private String make;
    private String model;
    private String price;
    private String month;
    private String year;
    private EngineDTO engine;
    private CategoryDTO category;
    private GearBoxDTO gearBox;
    private String mileage;
    private ColorDTO color;
    private SafetyDTO safety;
    private ExteriorDTO exterior;
    private InteriorDTO interior;
    private ProtectionDTO protection;
    private ComfortDTO comfort;
    private OtherDTO other;
    private String additionalInformation;

    public CreateCarDTO() {
        this.engine = new EngineDTO();
        this.category = new CategoryDTO();
        this.gearBox = new GearBoxDTO();
        this.color = new ColorDTO();
        this.safety = new SafetyDTO();
        this.exterior = new ExteriorDTO();
        this.interior = new InteriorDTO();
        this.protection = new ProtectionDTO();
        this.comfort = new ComfortDTO();
        this.other = new OtherDTO();
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public EngineDTO getEngine() {
        return engine;
    }

    public void setEngine(EngineDTO engine) {
        this.engine = engine;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public GearBoxDTO getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBoxDTO gearBox) {
        this.gearBox = gearBox;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public ColorDTO getColor() {
        return color;
    }

    public void setColor(ColorDTO color) {
        this.color = color;
    }

    public SafetyDTO getSafety() {
        return safety;
    }

    public void setSafety(SafetyDTO safety) {
        this.safety = safety;
    }

    public ExteriorDTO getExterior() {
        return exterior;
    }

    public void setExterior(ExteriorDTO exterior) {
        this.exterior = exterior;
    }

    public InteriorDTO getInterior() {
        return interior;
    }

    public void setInterior(InteriorDTO interior) {
        this.interior = interior;
    }

    public ProtectionDTO getProtection() {
        return protection;
    }

    public void setProtection(ProtectionDTO protection) {
        this.protection = protection;
    }

    public ComfortDTO getComfort() {
        return comfort;
    }

    public void setComfort(ComfortDTO comfort) {
        this.comfort = comfort;
    }

    public OtherDTO getOther() {
        return other;
    }

    public void setOther(OtherDTO other) {
        this.other = other;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
