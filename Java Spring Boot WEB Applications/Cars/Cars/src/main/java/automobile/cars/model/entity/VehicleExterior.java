package automobile.cars.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "exteriors")
public class VehicleExterior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alloy_wheels")
    private boolean alloyWheels;

    @Column(name = "power_side_mirror_adjustment")
    private boolean powerSideMirrorAdjustment;

    @Column(name = "rain_sensing_wipers")
    private boolean rainSensingWipers;

    @Column(name = "sunroof")
    private boolean sunroof;

    @Column(name = "led_headlights")
    private boolean ledHeadlights;

    @Column(name = "fog_lights")
    private boolean fogLights;

    @Column(name = "automatic_headlights")
    private boolean automaticHeadlights;

}
