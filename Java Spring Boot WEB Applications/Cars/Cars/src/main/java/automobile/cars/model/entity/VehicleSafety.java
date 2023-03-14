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

    public VehicleSafety() {
    }

    public VehicleSafety(Long id,
                         boolean antiLockBrakingSystem,
                         boolean electronicStabilityControl,
                         boolean adaptiveCruiseControl,
                         boolean laneDepartureWarning,
                         boolean blindSpotDetection,
                         boolean forwardCollisionWarning,
                         boolean automaticEmergencyBraking,
                         boolean rearviewCamera) {
        this.id = id;
        this.antiLockBrakingSystem = antiLockBrakingSystem;
        this.electronicStabilityControl = electronicStabilityControl;
        this.adaptiveCruiseControl = adaptiveCruiseControl;
        this.laneDepartureWarning = laneDepartureWarning;
        this.blindSpotDetection = blindSpotDetection;
        this.forwardCollisionWarning = forwardCollisionWarning;
        this.automaticEmergencyBraking = automaticEmergencyBraking;
        this.rearviewCamera = rearviewCamera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAntiLockBrakingSystem() {
        return antiLockBrakingSystem;
    }

    public void setAntiLockBrakingSystem(boolean antiLockBrakingSystem) {
        this.antiLockBrakingSystem = antiLockBrakingSystem;
    }

    public boolean isElectronicStabilityControl() {
        return electronicStabilityControl;
    }

    public void setElectronicStabilityControl(boolean electronicStabilityControl) {
        this.electronicStabilityControl = electronicStabilityControl;
    }

    public boolean isAdaptiveCruiseControl() {
        return adaptiveCruiseControl;
    }

    public void setAdaptiveCruiseControl(boolean adaptiveCruiseControl) {
        this.adaptiveCruiseControl = adaptiveCruiseControl;
    }

    public boolean isLaneDepartureWarning() {
        return laneDepartureWarning;
    }

    public void setLaneDepartureWarning(boolean laneDepartureWarning) {
        this.laneDepartureWarning = laneDepartureWarning;
    }

    public boolean isBlindSpotDetection() {
        return blindSpotDetection;
    }

    public void setBlindSpotDetection(boolean blindSpotDetection) {
        this.blindSpotDetection = blindSpotDetection;
    }

    public boolean isForwardCollisionWarning() {
        return forwardCollisionWarning;
    }

    public void setForwardCollisionWarning(boolean forwardCollisionWarning) {
        this.forwardCollisionWarning = forwardCollisionWarning;
    }

    public boolean isAutomaticEmergencyBraking() {
        return automaticEmergencyBraking;
    }

    public void setAutomaticEmergencyBraking(boolean automaticEmergencyBraking) {
        this.automaticEmergencyBraking = automaticEmergencyBraking;
    }

    public boolean isRearviewCamera() {
        return rearviewCamera;
    }

    public void setRearviewCamera(boolean rearviewCamera) {
        this.rearviewCamera = rearviewCamera;
    }
}
