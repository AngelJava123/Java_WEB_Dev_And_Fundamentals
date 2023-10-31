package automobile.cars.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarsDealershipSecurityConfigTest {

    @Autowired
    private Pbkdf2PasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoderBean() {
        assertNotNull(passwordEncoder);
    }

    @Test
    public void testPasswordEncodingAndMatching() {
        String rawPassword = "mySecretPassword";

        // Encoding the password
        String encodedPassword = passwordEncoder.encode(rawPassword);
        assertNotNull(encodedPassword);
        assertNotEquals(rawPassword, encodedPassword);

        // Matching the encoded password
        assertTrue(passwordEncoder.matches(rawPassword, encodedPassword));
    }

    @Test
    public void testPasswordMatchingFailure() {
        String rawPassword = "mySecretPassword";
        String incorrectPassword = "wrongPassword";

        // Encoding the password
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Attempting to match with an incorrect password
        assertFalse(passwordEncoder.matches(incorrectPassword, encodedPassword));
    }
}

