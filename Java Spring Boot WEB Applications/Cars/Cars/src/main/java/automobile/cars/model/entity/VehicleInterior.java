package automobile.cars.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "interiors")
public class VehicleInterior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "leather_seats")
    private boolean leatherSeats;

    @Column(name = "heated_seats")
    private boolean heatedSeats;

    @Column(name = "power_windows")
    private boolean powerWindows;

    @Column(name = "power_locks")
    private boolean powerLocks;

    @Column(name = "sunroof")
    private boolean sunroof;

    @Column(name = "navigation_system")
    private boolean navigationSystem;

    @Column(name = "bluetooth")
    private boolean bluetooth;

    @Column(name = "backup_camera")
    private boolean backupCamera;

    @Column(name = "push_button_start")
    private boolean pushButtonStart;

    @Column(name = "dual_climate_control")
    private boolean dualClimateControl;

    public VehicleInterior() {
    }

    public VehicleInterior(Long id,
                           boolean leatherSeats,
                           boolean heatedSeats,
                           boolean powerWindows,
                           boolean powerLocks,
                           boolean sunroof,
                           boolean navigationSystem,
                           boolean bluetooth,
                           boolean backupCamera,
                           boolean pushButtonStart,
                           boolean dualClimateControl) {
        this.id = id;
        this.leatherSeats = leatherSeats;
        this.heatedSeats = heatedSeats;
        this.powerWindows = powerWindows;
        this.powerLocks = powerLocks;
        this.sunroof = sunroof;
        this.navigationSystem = navigationSystem;
        this.bluetooth = bluetooth;
        this.backupCamera = backupCamera;
        this.pushButtonStart = pushButtonStart;
        this.dualClimateControl = dualClimateControl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLeatherSeats() {
        return leatherSeats;
    }

    public void setLeatherSeats(boolean leatherSeats) {
        this.leatherSeats = leatherSeats;
    }

    public boolean isHeatedSeats() {
        return heatedSeats;
    }

    public void setHeatedSeats(boolean heatedSeats) {
        this.heatedSeats = heatedSeats;
    }

    public boolean isPowerWindows() {
        return powerWindows;
    }

    public void setPowerWindows(boolean powerWindows) {
        this.powerWindows = powerWindows;
    }

    public boolean isPowerLocks() {
        return powerLocks;
    }

    public void setPowerLocks(boolean powerLocks) {
        this.powerLocks = powerLocks;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public boolean isNavigationSystem() {
        return navigationSystem;
    }

    public void setNavigationSystem(boolean navigationSystem) {
        this.navigationSystem = navigationSystem;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isBackupCamera() {
        return backupCamera;
    }

    public void setBackupCamera(boolean backupCamera) {
        this.backupCamera = backupCamera;
    }

    public boolean isPushButtonStart() {
        return pushButtonStart;
    }

    public void setPushButtonStart(boolean pushButtonStart) {
        this.pushButtonStart = pushButtonStart;
    }

    public boolean isDualClimateControl() {
        return dualClimateControl;
    }

    public void setDualClimateControl(boolean dualClimateControl) {
        this.dualClimateControl = dualClimateControl;
    }
}
