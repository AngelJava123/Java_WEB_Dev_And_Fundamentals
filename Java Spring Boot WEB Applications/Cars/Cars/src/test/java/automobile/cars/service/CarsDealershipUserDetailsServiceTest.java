package automobile.cars.service;
import automobile.cars.model.entity.Role;
import automobile.cars.model.entity.User;
import automobile.cars.model.enums.RoleEnum;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarsDealershipUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    private CarsDealershipUserDetailsService userDetailsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userDetailsService = new CarsDealershipUserDetailsService(userRepository);
    }

    @Test
    void loadUserByUsername_UserFound_ShouldReturnUserDetails() {
        // Arrange
        String email = "test@example.com";
        User user = new User();
        user.setEmail(email);
        user.setPassword("password");

        Role role = new Role();
        role.setRole(RoleEnum.PRIVATE_USERS); // Use RoleEnum here
        user.setRoles(new HashSet<>(Collections.singletonList(role))); // Convert list to set

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        // Act
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        // Assert
        assertNotNull(userDetails);
        assertEquals(email, userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream().anyMatch(authority ->
                authority.getAuthority().equals("ROLE_PRIVATE_USERS"))); // Adjust the role here

        verify(userRepository, times(1)).findByEmail(email);
    }



    @Test
    void loadUserByUsername_UserNotFound_ShouldThrowUsernameNotFoundException() {
        // Arrange
        String email = "nonexistent@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UsernameNotFoundException.class,
                () -> userDetailsService.loadUserByUsername(email));

        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    void mapUserRole_ShouldReturnGrantedAuthority() {
        // Arrange
        Role role = new Role();
        role.setRole(RoleEnum.PRIVATE_USERS);

        // Act
        GrantedAuthority authority = userDetailsService.map(role);

        // Assert
        assertNotNull(authority);
        assertEquals("ROLE_PRIVATE_USERS", authority.getAuthority());
    }
}
