package automobile.cars.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorTestingController {

    @GetMapping("/500")
    public void test500() {
        throw new RuntimeException("Simulated internal server error");
    }
}
