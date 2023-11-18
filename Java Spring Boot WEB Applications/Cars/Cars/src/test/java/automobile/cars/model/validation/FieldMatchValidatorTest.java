package automobile.cars.model.validation;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FieldMatchValidatorTest {
    @Test
    void testValidFieldMatch() {
        // Arrange
        FieldMatchValidator validator = new FieldMatchValidator();
        validator.initialize(createFieldMatchAnnotation("password", "confirmPassword", "Passwords must match"));

        TestObject testObject = new TestObject();
        testObject.setPassword("securePassword");
        testObject.setConfirmPassword("securePassword");

        // Act
        boolean isValid = validator.isValid(testObject, mock(ConstraintValidatorContext.class));

        // Assert
        assertTrue(isValid, "Validation should pass for matching fields");
    }

    @Test
    void testInvalidFieldMatch() {
        // Arrange
        FieldMatchValidator validator = new FieldMatchValidator();
        validator.initialize(createFieldMatchAnnotation("password", "confirmPassword", "Passwords must match"));

        TestObject testObject = new TestObject();
        testObject.setPassword("securePassword");
        testObject.setConfirmPassword("mismatchedPassword");

        // Mock ConstraintValidatorContext
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
        ConstraintValidatorContext.ConstraintViolationBuilder builder = mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
        ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilder = mock(ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext.class);

        when(context.buildConstraintViolationWithTemplate(any())).thenReturn(builder);
        when(builder.addPropertyNode(any())).thenReturn(nodeBuilder);
        when(nodeBuilder.addConstraintViolation()).thenReturn(context); // Fix for NPE

        // Act
        boolean isValid = validator.isValid(testObject, context);

        // Assert
        assertFalse(isValid, "Validation should fail for mismatched fields");
    }

    private FieldMatch createFieldMatchAnnotation(String first, String second, String message) {
        return new FieldMatch() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String first() {
                return first;
            }

            @Override
            public String second() {
                return second;
            }

            @Override
            public String message() {
                return message;
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends javax.validation.Payload>[] payload() {
                return new Class[0];
            }
        };
    }

    // Sample test object
    private static class TestObject {
        private String password;
        private String confirmPassword;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }
    }
}
