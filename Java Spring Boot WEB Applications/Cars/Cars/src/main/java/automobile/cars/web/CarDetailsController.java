package automobile.cars.web;

import automobile.cars.service.CarDetailsService;
import automobile.cars.view.CarViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarDetailsController {

    private final CarDetailsService carDetailsService;

    public CarDetailsController(CarDetailsService carDetailsService) {
        this.carDetailsService = carDetailsService;
    }

    @GetMapping("/details/{id}")
    public String carDetailsById(@PathVariable Long id, Model model) {
        // retrieve car details
        CarViewModel car = carDetailsService.findById(id);

        // increment the visits counter
        int visits = carDetailsService.incrementVisits(id);

        // add car and visits to the model
        model.addAttribute("car", car);
        model.addAttribute("visits", visits);

        return "details";
    }

}
