package automobile.cars.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EngineDTO {

    private Long id;

    @NotNull
    private String engineType;

    @NotNull
    @Size(max = 5)
    @Digits(integer = 5, fraction = 0)
    private String power;

    @NotNull
    private String euroStandard;

    @NotNull
    @Column(name = "cubic_capacity")
    @Size(max = 4)
    @Digits(integer = 4, fraction = 0)
    private  String cubicCapacity;

    public EngineDTO() {
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
