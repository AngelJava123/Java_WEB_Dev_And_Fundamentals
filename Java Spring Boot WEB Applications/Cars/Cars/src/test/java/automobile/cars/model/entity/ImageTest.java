package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;


public class ImageTest {

    @Test
    void testGettersAndSetters() {
        Image image = new Image();
        Car car = new Car();
        car.setId(1L);
        image.setId(2L);
        image.setCar(car);
        image.setUrl("https://example.com/image.jpg");

        assertEquals(2L, image.getId());
        assertEquals(car, image.getCar());
        assertEquals("https://example.com/image.jpg", image.getUrl());
    }

    @Test
    void testNullCar() {
        Image image = new Image();
        image.setId(1L);
        image.setUrl("https://example.com/image.jpg");

        assertNull(image.getCar(), "Car should be null");
    }

    @Test
    void testNotNullUrl() {
        Image image = new Image();
        image.setId(1L);
        image.setUrl(null); // intentionally set to null for the test

        assertNull(image.getUrl(), "Url should be null");
    }
}
