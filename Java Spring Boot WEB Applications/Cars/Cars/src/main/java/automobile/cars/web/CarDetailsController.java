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
        CarViewModel car = carDetailsService.findById(id);
        model.addAttribute("car", car);
        return "details";
    }
}
