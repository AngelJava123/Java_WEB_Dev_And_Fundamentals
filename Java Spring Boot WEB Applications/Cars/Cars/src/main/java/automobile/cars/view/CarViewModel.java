package automobile.cars.view;

import java.time.LocalDateTime;
import java.util.List;

public class CarViewModel {

    private Long id;
    private List<String> imageFilePaths;
    private String make;
    private String model;
    private String price;
    private String month;
    private String year;

    private VehicleEngineViewModel engineViewModel;

    // private VehicleCategory category;

    private String category;

    // private VehicleGearBox gearBox;

    private String gearBoxType;

    private String mileage;

    // private VehicleColor color;

    private String paint;

    private VehicleSafetyViewModel safetyViewModel;
    private VehicleExteriorViewModel exteriorViewModel;
    private VehicleInteriorViewModel interiorViewModel;
    private VehicleProtectionViewModel protectionViewModel;
    private VehicleComfortViewModel comfortViewModel;
    private VehicleOtherViewModel otherViewModel;
    private String additionalInformation;
    private LocalDateTime dateAdded;

    public CarViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getImageFilePaths() {
        return imageFilePaths;
    }

    public void setImageFilePaths(List<String> imageFilePaths) {
        this.imageFilePaths = imageFilePaths;
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

    public VehicleEngineViewModel getEngineViewModel() {
        return engineViewModel;
    }

    public void setEngineViewModel(VehicleEngineViewModel engineViewModel) {
        this.engineViewModel = engineViewModel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGearBoxType() {
        return gearBoxType;
    }

    public void setGearBoxType(String gearBoxType) {
        this.gearBoxType = gearBoxType;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    public VehicleSafetyViewModel getSafetyViewModel() {
        return safetyViewModel;
    }

    public void setSafetyViewModel(VehicleSafetyViewModel safetyViewModel) {
        this.safetyViewModel = safetyViewModel;
    }

    public VehicleExteriorViewModel getExteriorViewModel() {
        return exteriorViewModel;
    }

    public void setExteriorViewModel(VehicleExteriorViewModel exteriorViewModel) {
        this.exteriorViewModel = exteriorViewModel;
    }

    public VehicleInteriorViewModel getInteriorViewModel() {
        return interiorViewModel;
    }

    public void setInteriorViewModel(VehicleInteriorViewModel interiorViewModel) {
        this.interiorViewModel = interiorViewModel;
    }

    public VehicleProtectionViewModel getProtectionViewModel() {
        return protectionViewModel;
    }

    public void setProtectionViewModel(VehicleProtectionViewModel protectionViewModel) {
        this.protectionViewModel = protectionViewModel;
    }

    public VehicleComfortViewModel getComfortViewModel() {
        return comfortViewModel;
    }

    public void setComfortViewModel(VehicleComfortViewModel comfortViewModel) {
        this.comfortViewModel = comfortViewModel;
    }

    public VehicleOtherViewModel getOtherViewModel() {
        return otherViewModel;
    }

    public void setOtherViewModel(VehicleOtherViewModel otherViewModel) {
        this.otherViewModel = otherViewModel;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}