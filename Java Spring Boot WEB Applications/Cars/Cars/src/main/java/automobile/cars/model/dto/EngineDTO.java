package automobile.cars.model.dto;

import javax.validation.constraints.NotNull;

public class EngineDTO {

    private Long id;

    @NotNull
    private String engineType;

    @NotNull
    private String power;

    @NotNull
    private String euroStandard;

    @NotNull
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
