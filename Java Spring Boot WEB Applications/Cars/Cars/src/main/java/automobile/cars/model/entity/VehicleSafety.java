package automobile.cars.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "safeties")
public class VehicleSafety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "abs")
    private boolean antiLockBrakingSystem;

    @Column(name = "esc")
    private boolean electronicStabilityControl;

    @Column(name = "acc")
    private boolean adaptiveCruiseControl;

    @Column(name = "ldw")
    private boolean laneDepartureWarning;

    @Column(name = "bsd")
    private boolean blindSpotDetection;

    @Column(name = "fcw")
    private boolean forwardCollisionWarning;

    @Column(name = "aeb")
    private boolean automaticEmergencyBraking;

    @Column(name = "rvc")
    private boolean rearviewCamera;
}
