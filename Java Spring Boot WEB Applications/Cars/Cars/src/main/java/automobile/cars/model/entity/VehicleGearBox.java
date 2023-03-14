package automobile.cars.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gearBoxes")
public class VehicleGearBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String gearBoxType;

    public VehicleGearBox() {
    }

    public VehicleGearBox(Long id, String gearBoxType) {
        this.id = id;
        this.gearBoxType = gearBoxType;
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
