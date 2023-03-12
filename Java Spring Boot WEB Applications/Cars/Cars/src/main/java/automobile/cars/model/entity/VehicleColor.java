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

}
