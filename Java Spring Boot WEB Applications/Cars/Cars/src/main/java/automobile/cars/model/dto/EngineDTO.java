package automobile.cars.model.dto;

import javax.validation.constraints.*;

public class EngineDTO {

    private Long id;

    @NotNull
    private String engineType;

    @NotNull
    @Min(value = 1, message = "Value must be greater than zero")
    @Max(value = 3000, message = "Value cannot exceed 3000")
    private int power;

    private int powerFrom;
    private int powerTo;

    @NotNull
    private String euroStandard;

    @NotNull
    @Min(value = 1, message = "Value must be greater than zero")
    @Max(value = 5000, message = "Value cannot exceed 5000")
    private int cubicCapacity;

    private int cubicCapacityFrom;
    private int cubicCapacityTo;

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

    public int getCubicCapacityFrom() {
        return cubicCapacityFrom;
    }

    public void setCubicCapacityFrom(int cubicCapacityFrom) {
        this.cubicCapacityFrom = cubicCapacityFrom;
    }

    public int getCubicCapacityTo() {
        return cubicCapacityTo;
    }

    public void setCubicCapacityTo(int cubicCapacityTo) {
        this.cubicCapacityTo = cubicCapacityTo;
    }

    public int getPowerFrom() {
        return powerFrom;
    }

    public void setPowerFrom(int powerFrom) {
        this.powerFrom = powerFrom;
    }

    public int getPowerTo() {
        return powerTo;
    }

    public void setPowerTo(int powerTo) {
        this.powerTo = powerTo;
    }
}
