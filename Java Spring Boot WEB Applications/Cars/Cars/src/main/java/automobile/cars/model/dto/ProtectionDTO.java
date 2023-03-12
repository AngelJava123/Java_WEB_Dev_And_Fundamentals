package automobile.cars.model.dto;

public class ProtectionDTO {

    private Long id;
    private boolean antiTheftSystem;
    private boolean remoteKeylessEntry;
    private boolean alarmSystem;
    private boolean airbags;
    private boolean parkingSensors;
    private boolean backupCamera;
    private boolean tirePressureMonitoring;

    public ProtectionDTO() {
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
