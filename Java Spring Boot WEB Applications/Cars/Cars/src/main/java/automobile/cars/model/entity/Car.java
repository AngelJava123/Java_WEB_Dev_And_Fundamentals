package automobile.cars.model.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "car_image_paths", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "image_path")
    private List<String> imageFilePaths = new ArrayList<>();

    @NotNull
    private String make;

    @NotNull
    private String model;

    @NotNull
    @Pattern(regexp = "^(?!0)(\\d{1,6}|1000000)$")
    private String price;

    @NotNull
    private String month;

    @NotNull
    private String year;

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
    @Size(max = 6)
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
    @Pattern(regexp="08[789]\\d{7}", message="Invalid phone number")
    private String phoneNumber;

    @NotNull
    @NotBlank(message="Location cannot be blank")
    private String location;

    @NotNull
    @Column(name = "additional_information", columnDefinition = "TEXT")
    @Size(min = 50, message = "Additional information should be at least 50 characters long")
    private String additionalInformation;

    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    @ManyToOne
    private User user;

    public Car() {
    }

    public List<String> getImageFilePaths() {
        return imageFilePaths;
    }

    public void setImageFilePaths(List<String> imageFilePaths) {
        this.imageFilePaths = imageFilePaths;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
