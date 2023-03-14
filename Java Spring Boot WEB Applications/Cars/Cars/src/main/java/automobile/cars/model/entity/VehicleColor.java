package automobile.cars.model.entity;

import automobile.cars.model.enums.PaintType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "colors")
public class VehicleColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String paint;

    public VehicleColor() {
    }

    public VehicleColor(Long id, String paint) {
        this.id = id;
        this.paint = paint;
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
