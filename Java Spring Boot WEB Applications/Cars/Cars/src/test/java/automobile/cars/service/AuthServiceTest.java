package automobile.cars.service;

import automobile.cars.model.dto.UserRegisterDTO;
import automobile.cars.model.entity.User;
import automobile.cars.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private AuthService authService;

    @Test
    void testRegister_Success() throws IOException, MessagingException {

        // Arrange
        UserRegisterDTO registerDTO = new UserRegisterDTO();
        registerDTO.setUsername("testUser");
        registerDTO.setEmail("test@example.com");
        registerDTO.setPassword("password");
        registerDTO.setConfirmPassword("password");

        when(userRepository.findByUsername(registerDTO.getUsername())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(registerDTO.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(registerDTO.getPassword())).thenReturn("encodedPassword");
        when(modelMapper.map(registerDTO, User.class)).thenReturn(new User());
        doNothing().when(emailService).sendHtmlEmail(any(), any(), any());

        // Act
        boolean result = authService.register(registerDTO);

        // Assert
        assertThat(result).isTrue();
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void testRegister_Failure_UsernameExists() throws IOException, MessagingException {
        // Arrange
        UserRegisterDTO registerDTO = new UserRegisterDTO();
        registerDTO.setUsername("testUser");
        registerDTO.setEmail("test@example.com");
        registerDTO.setPassword("password");
        registerDTO.setConfirmPassword("password");

        when(userRepository.findByUsername(registerDTO.getUsername())).thenReturn(Optional.of(new User()));

        // Act
        boolean result = authService.register(registerDTO);

        // Assert
        assertThat(result).isFalse();
        verify(userRepository, never()).save(any());
    }

    @Test
    void testRegister_Failure_EmailExists() throws IOException, MessagingException {
        // Arrange
        UserRegisterDTO registerDTO = new UserRegisterDTO();
        registerDTO.setUsername("testUser");
        registerDTO.setEmail("test@example.com");
        registerDTO.setPassword("password");
        registerDTO.setConfirmPassword("password");

        when(userRepository.findByUsername(registerDTO.getUsername())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(registerDTO.getEmail())).thenReturn(Optional.of(new User()));

        // Act
        boolean result = authService.register(registerDTO);

        // Assert
        assertThat(result).isFalse();
        verify(userRepository, never()).save(any());
    }

    // Additional test cases for register method...

    @Test
    void testLogin() {
        // Implement test for login method...
    }

    @Test
    void testCreateUserIfNotExist_UserDoesNotExist() {
        // Arrange
        String email = "test@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act
        authService.createUserIfNotExist(email);

        // Assert
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void testCreateUserIfNotExist_UserExists() {
        // Arrange
        String email = "test@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(new User()));

        // Act
        authService.createUserIfNotExist(email);

        // Assert
        verify(userRepository, never()).save(any());
    }
}
