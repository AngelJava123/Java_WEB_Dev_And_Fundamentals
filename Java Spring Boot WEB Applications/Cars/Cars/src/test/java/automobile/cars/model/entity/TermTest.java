package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TermTest {

    @Test
    void testGettersAndSetters() {
        Term term = new Term();
        term.setId(1);
        term.setWelcome("Welcome to our website!");
        term.setUseOfService("Terms of Service");
        term.setIntellectualProperty("Intellectual Property Information");
        term.setThirdParty("Third Party Content");
        term.setWarranties("Warranties and Disclaimers");
        term.setLiability("Limitation of Liability");
        term.setIndemnification("Indemnification");
        term.setModification("Modification of Terms");
        term.setLaw("Governing Law");
        term.setResolution("Dispute Resolution");
        term.setAgreement("Agreement to Terms");

        assertEquals(1, term.getId());
        assertEquals("Welcome to our website!", term.getWelcome());
        assertEquals("Terms of Service", term.getUseOfService());
        assertEquals("Intellectual Property Information", term.getIntellectualProperty());
        assertEquals("Third Party Content", term.getThirdParty());
        assertEquals("Warranties and Disclaimers", term.getWarranties());
        assertEquals("Limitation of Liability", term.getLiability());
        assertEquals("Indemnification", term.getIndemnification());
        assertEquals("Modification of Terms", term.getModification());
        assertEquals("Governing Law", term.getLaw());
        assertEquals("Dispute Resolution", term.getResolution());
        assertEquals("Agreement to Terms", term.getAgreement());
    }
}
