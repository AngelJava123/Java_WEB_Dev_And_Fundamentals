package automobile.cars.view;

public class VehicleInteriorViewModel {

    private boolean leatherSeats;
    private boolean heatedSeats;
    private boolean powerWindows;
    private boolean powerLocks;
    private boolean sunroof;
    private boolean navigationSystem;
    private boolean bluetooth;
    private boolean backupCamera;
    private boolean pushButtonStart;
    private boolean dualClimateControl;

    public VehicleInteriorViewModel() {
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
