package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarConstructor() {
        Car car = new Car();
        assertNotNull(car);
        assertEquals(0, car.getVisits());
        assertFalse(car.isFavourite());
    }

    @Test
    public void testSetAndGetMake() {
        Car car = new Car();
        car.setMake("Toyota");
        assertEquals("Toyota", car.getMake());
    }

    @Test
    public void testSetAndGetModel() {
        Car car = new Car();
        car.setModel("Camry");
        assertEquals("Camry", car.getModel());
    }

    @Test
    public void testSetAndGetPrice() {
        Car car = new Car();
        car.setPrice(25000);
        assertEquals(25000, car.getPrice());
    }

    // Add similar tests for other properties

    @Test
    public void testSetAndGetAdditionalInformation() {
        Car car = new Car();
        car.setAdditionalInformation("This is a sample additional information.");
        assertEquals("This is a sample additional information.", car.getAdditionalInformation());
    }

    @Test
    public void testSetAndGetPhoneNumber() {
        Car car = new Car();
        car.setPhoneNumber("0888888888");
        assertEquals("0888888888", car.getPhoneNumber());
    }

    @Test
    public void testSetAndGetLocation() {
        Car car = new Car();
        car.setLocation("City Center");
        assertEquals("City Center", car.getLocation());
    }

    @Test
    public void testSetAndGetFavourite() {
        Car car = new Car();
        car.setFavourite(true);
        assertTrue(car.isFavourite());
    }

    @Test
    public void testSetAndGetVisits() {
        Car car = new Car();
        car.setVisits(10);
        assertEquals(10, car.getVisits());
    }
}
