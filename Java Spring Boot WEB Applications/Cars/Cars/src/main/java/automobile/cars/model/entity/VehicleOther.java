package automobile.cars.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "others")
public class VehicleOther {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "power_tailgate")
    private boolean powerTailgate;

    @Column(name = "panoramic_sunroof")
    private boolean panoramicSunroof;

    @Column(name = "adaptive_headlights")
    private boolean adaptiveHeadlights;

    @Column(name = "apple_carplay")
    private boolean appleCarPlay;

    @Column(name = "android_auto")
    private boolean androidAuto;

    @Column(name = "wireless_charging")
    private boolean wirelessCharging;

    @Column(name = "premium_sound_system")
    private boolean premiumSoundSystem;

    @Column(name = "multi_zone_climate_control")
    private boolean multiZoneClimateControl;

    @Column(name = "power_adjustable_pedals")
    private boolean powerAdjustablePedals;

    @Column(name = "heated_rear_seats")
    private boolean heatedRearSeats;

    public VehicleOther() {
    }

    public VehicleOther(Long id,
                        boolean powerTailgate,
                        boolean panoramicSunroof,
                        boolean adaptiveHeadlights,
                        boolean appleCarPlay,
                        boolean androidAuto,
                        boolean wirelessCharging,
                        boolean premiumSoundSystem,
                        boolean multiZoneClimateControl,
                        boolean powerAdjustablePedals,
                        boolean heatedRearSeats) {
        this.id = id;
        this.powerTailgate = powerTailgate;
        this.panoramicSunroof = panoramicSunroof;
        this.adaptiveHeadlights = adaptiveHeadlights;
        this.appleCarPlay = appleCarPlay;
        this.androidAuto = androidAuto;
        this.wirelessCharging = wirelessCharging;
        this.premiumSoundSystem = premiumSoundSystem;
        this.multiZoneClimateControl = multiZoneClimateControl;
        this.powerAdjustablePedals = powerAdjustablePedals;
        this.heatedRearSeats = heatedRearSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPowerTailgate() {
        return powerTailgate;
    }

    public void setPowerTailgate(boolean powerTailgate) {
        this.powerTailgate = powerTailgate;
    }

    public boolean isPanoramicSunroof() {
        return panoramicSunroof;
    }

    public void setPanoramicSunroof(boolean panoramicSunroof) {
        this.panoramicSunroof = panoramicSunroof;
    }

    public boolean isAdaptiveHeadlights() {
        return adaptiveHeadlights;
    }

    public void setAdaptiveHeadlights(boolean adaptiveHeadlights) {
        this.adaptiveHeadlights = adaptiveHeadlights;
    }

    public boolean isAppleCarPlay() {
        return appleCarPlay;
    }

    public void setAppleCarPlay(boolean appleCarPlay) {
        this.appleCarPlay = appleCarPlay;
    }

    public boolean isAndroidAuto() {
        return androidAuto;
    }

    public void setAndroidAuto(boolean androidAuto) {
        this.androidAuto = androidAuto;
    }

    public boolean isWirelessCharging() {
        return wirelessCharging;
    }

    public void setWirelessCharging(boolean wirelessCharging) {
        this.wirelessCharging = wirelessCharging;
    }

    public boolean isPremiumSoundSystem() {
        return premiumSoundSystem;
    }

    public void setPremiumSoundSystem(boolean premiumSoundSystem) {
        this.premiumSoundSystem = premiumSoundSystem;
    }

    public boolean isMultiZoneClimateControl() {
        return multiZoneClimateControl;
    }

    public void setMultiZoneClimateControl(boolean multiZoneClimateControl) {
        this.multiZoneClimateControl = multiZoneClimateControl;
    }

    public boolean isPowerAdjustablePedals() {
        return powerAdjustablePedals;
    }

    public void setPowerAdjustablePedals(boolean powerAdjustablePedals) {
        this.powerAdjustablePedals = powerAdjustablePedals;
    }

    public boolean isHeatedRearSeats() {
        return heatedRearSeats;
    }

    public void setHeatedRearSeats(boolean heatedRearSeats) {
        this.heatedRearSeats = heatedRearSeats;
    }
}
