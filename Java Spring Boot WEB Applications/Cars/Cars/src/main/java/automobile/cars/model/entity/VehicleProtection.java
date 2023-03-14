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

    public VehicleProtection() {
    }

    public VehicleProtection(Long id,
                             boolean antiTheftSystem,
                             boolean remoteKeylessEntry,
                             boolean alarmSystem,
                             boolean airbags,
                             boolean parkingSensors,
                             boolean backupCamera,
                             boolean tirePressureMonitoring) {
        this.id = id;
        this.antiTheftSystem = antiTheftSystem;
        this.remoteKeylessEntry = remoteKeylessEntry;
        this.alarmSystem = alarmSystem;
        this.airbags = airbags;
        this.parkingSensors = parkingSensors;
        this.backupCamera = backupCamera;
        this.tirePressureMonitoring = tirePressureMonitoring;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAntiTheftSystem() {
        return antiTheftSystem;
    }

    public void setAntiTheftSystem(boolean antiTheftSystem) {
        this.antiTheftSystem = antiTheftSystem;
    }

    public boolean isRemoteKeylessEntry() {
        return remoteKeylessEntry;
    }

    public void setRemoteKeylessEntry(boolean remoteKeylessEntry) {
        this.remoteKeylessEntry = remoteKeylessEntry;
    }

    public boolean isAlarmSystem() {
        return alarmSystem;
    }

    public void setAlarmSystem(boolean alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    public boolean isAirbags() {
        return airbags;
    }

    public void setAirbags(boolean airbags) {
        this.airbags = airbags;
    }

    public boolean isParkingSensors() {
        return parkingSensors;
    }

    public void setParkingSensors(boolean parkingSensors) {
        this.parkingSensors = parkingSensors;
    }

    public boolean isBackupCamera() {
        return backupCamera;
    }

    public void setBackupCamera(boolean backupCamera) {
        this.backupCamera = backupCamera;
    }

    public boolean isTirePressureMonitoring() {
        return tirePressureMonitoring;
    }

    public void setTirePressureMonitoring(boolean tirePressureMonitoring) {
        this.tirePressureMonitoring = tirePressureMonitoring;
    }
}
