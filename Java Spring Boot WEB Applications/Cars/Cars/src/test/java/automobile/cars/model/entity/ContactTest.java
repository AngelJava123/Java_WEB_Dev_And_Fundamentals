package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testGettersAndSetters() {
        Contact contact = new Contact();

        contact.setId(1);
        assertEquals(1, contact.getId());

        contact.setWebSiteName("CarDealer");
        assertEquals("CarDealer", contact.getWebSiteName());

        contact.setAddress("123 Main St");
        assertEquals("123 Main St", contact.getAddress());

        contact.setMobilePhone("123-456-7890");
        assertEquals("123-456-7890", contact.getMobilePhone());

        contact.setWorkingHours("Mon-Fri 9 AM - 5 PM");
        assertEquals("Mon-Fri 9 AM - 5 PM", contact.getWorkingHours());

        contact.setInfoEmail("info@cardealer.com");
        assertEquals("info@cardealer.com", contact.getInfoEmail());

        contact.setLTD("123456789");
        assertEquals("123456789", contact.getLTD());

        contact.setFD("987654321");
        assertEquals("987654321", contact.getFD());

        contact.setVAT("VAT123");
        assertEquals("VAT123", contact.getVAT());

        contact.setFax("123-456-7891");
        assertEquals("123-456-7891", contact.getFax());
    }

    @Test
    void testDefaultConstructor() {
        Contact contact = new Contact();
        assertNotNull(contact);
    }

    @Test
    void testToString() {
        Contact contact = new Contact();
        contact.setId(1);
        contact.setWebSiteName("CarDealer");
        contact.setAddress("123 Main St");
        contact.setMobilePhone("123-456-7890");

        assertEquals(1, contact.getId(), "Id should match");
        assertEquals("CarDealer", contact.getWebSiteName(), "WebSiteName should match");
        assertEquals("123 Main St", contact.getAddress(), "Address should match");
        assertEquals("123-456-7890", contact.getMobilePhone(), "MobilePhone should match");
    }
}
