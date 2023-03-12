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
}
