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

    public VehicleExterior() {
    }

    public VehicleExterior(Long id,
                           boolean alloyWheels,
                           boolean powerSideMirrorAdjustment,
                           boolean rainSensingWipers,
                           boolean sunroof,
                           boolean ledHeadlights,
                           boolean fogLights,
                           boolean automaticHeadlights) {
        this.id = id;
        this.alloyWheels = alloyWheels;
        this.powerSideMirrorAdjustment = powerSideMirrorAdjustment;
        this.rainSensingWipers = rainSensingWipers;
        this.sunroof = sunroof;
        this.ledHeadlights = ledHeadlights;
        this.fogLights = fogLights;
        this.automaticHeadlights = automaticHeadlights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAlloyWheels() {
        return alloyWheels;
    }

    public void setAlloyWheels(boolean alloyWheels) {
        this.alloyWheels = alloyWheels;
    }

    public boolean isPowerSideMirrorAdjustment() {
        return powerSideMirrorAdjustment;
    }

    public void setPowerSideMirrorAdjustment(boolean powerSideMirrorAdjustment) {
        this.powerSideMirrorAdjustment = powerSideMirrorAdjustment;
    }

    public boolean isRainSensingWipers() {
        return rainSensingWipers;
    }

    public void setRainSensingWipers(boolean rainSensingWipers) {
        this.rainSensingWipers = rainSensingWipers;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public boolean isLedHeadlights() {
        return ledHeadlights;
    }

    public void setLedHeadlights(boolean ledHeadlights) {
        this.ledHeadlights = ledHeadlights;
    }

    public boolean isFogLights() {
        return fogLights;
    }

    public void setFogLights(boolean fogLights) {
        this.fogLights = fogLights;
    }

    public boolean isAutomaticHeadlights() {
        return automaticHeadlights;
    }

    public void setAutomaticHeadlights(boolean automaticHeadlights) {
        this.automaticHeadlights = automaticHeadlights;
    }
}
