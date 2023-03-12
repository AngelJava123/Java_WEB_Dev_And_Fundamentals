package automobile.cars.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "protections")
public class VehicleProtection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "anti_theft_system")
    private boolean antiTheftSystem;

    @Column(name = "remote_keyless_entry")
    private boolean remoteKeylessEntry;

    @Column(name = "alarm_system")
    private boolean alarmSystem;

    @Column(name = "airbags")
    private boolean airbags;

    @Column(name = "parking_sensors")
    private boolean parkingSensors;

    @Column(name = "backup_camera")
    private boolean backupCamera;

    @Column(name = "tire_pressure_monitoring")
    private boolean tirePressureMonitoring;
}
