package automobile.cars.model.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "engines")
public class VehicleEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "engine_type")
    private String engineType;

    @NotNull
    @Min(value = 1, message = "Value must be greater than zero")
    @Max(value = 3000, message = "Value cannot exceed 3000")
    private int power;

    @NotNull
    @Column(name = "euro_standard")
    private String euroStandard;

    @NotNull
    @Min(value = 1, message = "Value must be greater than zero")
    @Max(value = 5000, message = "Value cannot exceed 5000")
    private int cubicCapacity;

    public VehicleEngine() {
    }

    public VehicleEngine(Long id, String engineType, int power, String euroStandard, int cubicCapacity) {
        this.id = id;
        this.engineType = engineType;
        this.power = power;
        this.euroStandard = euroStandard;
        this.cubicCapacity = cubicCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getEuroStandard() {
        return euroStandard;
    }

    public void setEuroStandard(String euroStandard) {
        this.euroStandard = euroStandard;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }
}
