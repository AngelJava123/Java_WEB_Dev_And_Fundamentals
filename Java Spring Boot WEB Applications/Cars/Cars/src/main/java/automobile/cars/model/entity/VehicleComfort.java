package automobile.cars.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "comforts")
public class VehicleComfort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "air_conditioning")
    private boolean airConditioning;

    @Column(name = "cruise_control")
    private boolean cruiseControl;

    @Column(name = "power_steering")
    private boolean powerSteering;

    @Column(name = "tilt_steering_wheel")
    private boolean tiltSteeringWheel;

    @Column(name = "telescoping_steering_wheel")
    private boolean telescopingSteeringWheel;

    @Column(name = "rear_defrost")
    private boolean rearDefrost;

    @Column(name = "remote_trunk_release")
    private boolean remoteTrunkRelease;

    @Column(name = "remote_engine_start")
    private boolean remoteEngineStart;

    @Column(name = "heated_steering_wheel")
    private boolean heatedSteeringWheel;

    @Column(name = "heated_mirrors")
    private boolean heatedMirrors;

    public VehicleComfort() {
    }

    public VehicleComfort(Long id,
                          boolean airConditioning,
                          boolean cruiseControl,
                          boolean powerSteering,
                          boolean tiltSteeringWheel,
                          boolean telescopingSteeringWheel,
                          boolean rearDefrost,
                          boolean remoteTrunkRelease,
                          boolean remoteEngineStart,
                          boolean heatedSteeringWheel,
                          boolean heatedMirrors) {
        this.id = id;
        this.airConditioning = airConditioning;
        this.cruiseControl = cruiseControl;
        this.powerSteering = powerSteering;
        this.tiltSteeringWheel = tiltSteeringWheel;
        this.telescopingSteeringWheel = telescopingSteeringWheel;
        this.rearDefrost = rearDefrost;
        this.remoteTrunkRelease = remoteTrunkRelease;
        this.remoteEngineStart = remoteEngineStart;
        this.heatedSteeringWheel = heatedSteeringWheel;
        this.heatedMirrors = heatedMirrors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public boolean isPowerSteering() {
        return powerSteering;
    }

    public void setPowerSteering(boolean powerSteering) {
        this.powerSteering = powerSteering;
    }

    public boolean isTiltSteeringWheel() {
        return tiltSteeringWheel;
    }

    public void setTiltSteeringWheel(boolean tiltSteeringWheel) {
        this.tiltSteeringWheel = tiltSteeringWheel;
    }

    public boolean isTelescopingSteeringWheel() {
        return telescopingSteeringWheel;
    }

    public void setTelescopingSteeringWheel(boolean telescopingSteeringWheel) {
        this.telescopingSteeringWheel = telescopingSteeringWheel;
    }

    public boolean isRearDefrost() {
        return rearDefrost;
    }

    public void setRearDefrost(boolean rearDefrost) {
        this.rearDefrost = rearDefrost;
    }

    public boolean isRemoteTrunkRelease() {
        return remoteTrunkRelease;
    }

    public void setRemoteTrunkRelease(boolean remoteTrunkRelease) {
        this.remoteTrunkRelease = remoteTrunkRelease;
    }

    public boolean isRemoteEngineStart() {
        return remoteEngineStart;
    }

    public void setRemoteEngineStart(boolean remoteEngineStart) {
        this.remoteEngineStart = remoteEngineStart;
    }

    public boolean isHeatedSteeringWheel() {
        return heatedSteeringWheel;
    }

    public void setHeatedSteeringWheel(boolean heatedSteeringWheel) {
        this.heatedSteeringWheel = heatedSteeringWheel;
    }

    public boolean isHeatedMirrors() {
        return heatedMirrors;
    }

    public void setHeatedMirrors(boolean heatedMirrors) {
        this.heatedMirrors = heatedMirrors;
    }
}
