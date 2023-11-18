package automobile.cars.model.user;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
public class CarsDealershipUserDetailsTest {
    @Test
    void testGetAuthorities() {
        // Arrange
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        Collection<GrantedAuthority> authorities = Collections.singleton(authority);
        CarsDealershipUserDetails userDetails = new CarsDealershipUserDetails("password", "username", authorities);

        // Act
        Collection<? extends GrantedAuthority> resultAuthorities = userDetails.getAuthorities();

        // Assert
        assertNotNull(resultAuthorities);
        assertEquals(authorities.size(), resultAuthorities.size());
        assertTrue(resultAuthorities.contains(authority));
    }

    @Test
    void testGetPassword() {
        // Arrange
        String password = "password";
        CarsDealershipUserDetails userDetails = new CarsDealershipUserDetails(password, "username", Collections.emptyList());

        // Act
        String resultPassword = userDetails.getPassword();

        // Assert
        assertNotNull(resultPassword);
        assertEquals(password, resultPassword);
    }

    @Test
    void testGetUsername() {
        // Arrange
        String username = "username";
        CarsDealershipUserDetails userDetails = new CarsDealershipUserDetails("password", username, Collections.emptyList());

        // Act
        String resultUsername = userDetails.getUsername();

        // Assert
        assertNotNull(resultUsername);
        assertEquals(username, resultUsername);
    }

    @Test
    void testIsAccountNonExpired() {
        // Arrange
        CarsDealershipUserDetails userDetails = new CarsDealershipUserDetails("password", "username", Collections.emptyList());

        // Act
        boolean result = userDetails.isAccountNonExpired();

        // Assert
        assertTrue(result);
    }

    @Test
    void testIsAccountNonLocked() {
        // Arrange
        CarsDealershipUserDetails userDetails = new CarsDealershipUserDetails("password", "username", Collections.emptyList());

        // Act
        boolean result = userDetails.isAccountNonLocked();

        // Assert
        assertTrue(result);
    }

    @Test
    void testIsCredentialsNonExpired() {
        // Arrange
        CarsDealershipUserDetails userDetails = new CarsDealershipUserDetails("password", "username", Collections.emptyList());

        // Act
        boolean result = userDetails.isCredentialsNonExpired();

        // Assert
        assertTrue(result);
    }

    @Test
    void testIsEnabled() {
        // Arrange
        CarsDealershipUserDetails userDetails = new CarsDealershipUserDetails("password", "username", Collections.emptyList());

        // Act
        boolean result = userDetails.isEnabled();

        // Assert
        assertTrue(result);
    }
}
