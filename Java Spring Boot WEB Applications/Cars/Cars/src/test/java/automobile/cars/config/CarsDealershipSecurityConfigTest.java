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

    @Test
    public void testPublicPathsAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/register"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser
    public void testAuthenticatedAccessToProtectedPaths() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/create"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/profile"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testLoginPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .param("username", "yourUsername")
                        .param("password", "yourPassword"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }

    @Test
    public void testLogout() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/logout"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"));
    }
}

