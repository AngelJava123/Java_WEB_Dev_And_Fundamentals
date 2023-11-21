package automobile.cars.model.validation;
import automobile.cars.model.entity.User;
import automobile.cars.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class UniqueUsernameValidatorTest {

    @Test
    void testValidUsername() {
        // Arrange
        String username = "newUsername";
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        UniqueUsernameValidator validator = new UniqueUsernameValidator(userRepository);

        // Act
        boolean isValid = validator.isValid(username, null);

        // Assert
        assertTrue(isValid, "Validation should pass for a unique username");
    }

    @Test
    void testInvalidUsername() {
        // Arrange
        String username = "existingUsername";
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(new User()));

        UniqueUsernameValidator validator = new UniqueUsernameValidator(userRepository);

        // Act
        boolean isValid = validator.isValid(username, null);

        // Assert
        assertFalse(isValid, "Validation should fail for a non-unique username");
    }
}
