package automobile.cars.view;

public class VehicleExteriorViewModel {

    private boolean alloyWheels;
    private boolean powerSideMirrorAdjustment;
    private boolean rainSensingWipers;
    private boolean sunroof;
    private boolean ledHeadlights;
    private boolean fogLights;
    private boolean automaticHeadlights;

    public VehicleExteriorViewModel() {
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
