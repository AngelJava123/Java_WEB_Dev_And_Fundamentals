package automobile.cars.repository;
import automobile.cars.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        // Arrange
        User userToSave = mock(User.class);
        User savedUser = mock(User.class);

        when(userRepository.save(userToSave)).thenReturn(savedUser);

        // Act
        User resultUser = userRepository.save(userToSave);

        // Assert
        assertThat(resultUser).isEqualTo(savedUser);
    }

    @Test
    void testFindByUsername() {
        // Arrange
        String username = "testUser";
        User expectedUser = mock(User.class);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedUser));

        // Act
        Optional<User> resultUser = userRepository.findByUsername(username);

        // Assert
        assertThat(resultUser).isPresent().contains(expectedUser);
    }

    @Test
    void testFindByEmail() {
        // Arrange
        String email = "test@example.com";
        User expectedUser = mock(User.class);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(expectedUser));

        // Act
        Optional<User> resultUser = userRepository.findByEmail(email);

        // Assert
        assertThat(resultUser).isPresent().contains(expectedUser);
    }
}
