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
}
