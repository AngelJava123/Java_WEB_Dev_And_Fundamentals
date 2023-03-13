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
}
