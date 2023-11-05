package automobile.cars.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@SpringBootTest
public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @Before
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testHandleNotFoundException() {
        ChangeSetPersister.NotFoundException exception = new ChangeSetPersister.NotFoundException();

        ModelAndView modelAndView = globalExceptionHandler.handleNotFoundException(exception);

        // Assert that the response status is HttpStatus.NOT_FOUND
        assertResponseStatus(modelAndView, HttpStatus.NOT_FOUND);

        // Assert that the view name is "error/404"
        assertViewName(modelAndView, "error/404");

        // Assert that the "message" attribute is set correctly
        assertModelAttribute(modelAndView, null);
    }

    @Test
    public void testHandleGeneralException() {
        Exception exception = new Exception("Internal Server Error");

        ModelAndView modelAndView = globalExceptionHandler.handleGeneralException(exception);

        // Assert that the response status is HttpStatus.INTERNAL_SERVER_ERROR
        assertResponseStatus(modelAndView, HttpStatus.INTERNAL_SERVER_ERROR);

        // Assert that the view name is "error/500"
        assertViewName(modelAndView, "error/500");

        // Assert that the "message" attribute is set correctly
        assertModelAttribute(modelAndView, "An error occurred: Internal Server Error");
    }

    // Helper methods for assertions

    private void assertResponseStatus(ModelAndView modelAndView, HttpStatus expectedStatus) {
        assertNotNull(modelAndView);
        MockHttpServletResponse response = new MockHttpServletResponse();
        try {
            Objects.requireNonNull(modelAndView.getView()).render(modelAndView.getModel(), new MockHttpServletRequest(), response);
            int responseStatus = response.getStatus();
            assertEquals(expectedStatus.value(), responseStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void assertViewName(ModelAndView modelAndView, String expectedViewName) {
        assertNotNull(modelAndView);
        String actualViewName = modelAndView.getViewName();
        assertEquals(expectedViewName, actualViewName);
    }

    private void assertModelAttribute(ModelAndView modelAndView, Object expectedValue) {
        assertNotNull(modelAndView);
        Object actualValue = modelAndView.getModel().get("message");
        assertEquals(expectedValue, actualValue);
    }
}
