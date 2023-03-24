package automobile.cars.view;

public class VehicleSafetyViewModel {

    private boolean antiLockBrakingSystem;
    private boolean electronicStabilityControl;
    private boolean adaptiveCruiseControl;
    private boolean laneDepartureWarning;
    private boolean blindSpotDetection;
    private boolean forwardCollisionWarning;
    private boolean automaticEmergencyBraking;
    private boolean rearviewCamera;

    public VehicleSafetyViewModel() {
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
