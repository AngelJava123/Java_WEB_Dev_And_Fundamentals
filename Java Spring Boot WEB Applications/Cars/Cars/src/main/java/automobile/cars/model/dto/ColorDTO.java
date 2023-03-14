package automobile.cars.model.dto;

import javax.validation.constraints.NotNull;

public class ColorDTO {

    private Long id;

    @NotNull
    private String paint;

    public ColorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }
}
