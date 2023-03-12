package automobile.cars.model.dto;

import javax.validation.constraints.NotNull;

public class MileageDTO {

    private Long id;

    @NotNull
    private String currentMileage;

    public MileageDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(String currentMileage) {
        this.currentMileage = currentMileage;
    }
}
