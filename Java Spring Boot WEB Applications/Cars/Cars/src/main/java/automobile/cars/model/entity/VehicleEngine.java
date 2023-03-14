package automobile.cars.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String power;

    @NotNull
    @Column(name = "euro_standard")
    private String euroStandard;

    @NotNull
    @Column(name = "cubic_capacity")
    private  String cubicCapacity;

    public VehicleEngine() {
    }

    public VehicleEngine(Long id, String engineType, String power, String euroStandard, String cubicCapacity) {
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

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getEuroStandard() {
        return euroStandard;
    }

    public void setEuroStandard(String euroStandard) {
        this.euroStandard = euroStandard;
    }

    public String getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(String cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }
}
