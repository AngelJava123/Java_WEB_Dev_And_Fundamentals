package automobile.cars.model.dto;

import javax.validation.constraints.NotNull;

public class GearBoxDTO {

    private Long id;

    @NotNull
    private String gearBoxType;

    public GearBoxDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGearBoxType() {
        return gearBoxType;
    }

    public void setGearBoxType(String gearBoxType) {
        this.gearBoxType = gearBoxType;
    }
}
