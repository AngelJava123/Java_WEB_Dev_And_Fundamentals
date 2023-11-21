package automobile.cars.model.validation;
import automobile.cars.model.entity.User;
import automobile.cars.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.ConstraintValidatorContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
public class UniqueUserEmailValidatorTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ConstraintValidatorContext context;

    @InjectMocks
    private UniqueUserEmailValidator validator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testValidEmail() {
        // Arrange
        String email = "unique@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act
        boolean isValid = validator.isValid(email, context);

        // Assert
        assertTrue(isValid, "Validation should pass for a unique email");
    }

    @Test
    void testInvalidEmail() {
        // Arrange
        String email = "existing@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(new User()));

        // Act
        boolean isValid = validator.isValid(email, context);

        // Assert
        assertFalse(isValid, "Validation should fail for a non-unique email");
    }

}
