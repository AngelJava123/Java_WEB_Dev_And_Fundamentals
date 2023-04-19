package automobile.cars.web;

import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.model.entity.Car;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.service.CreateService;
import automobile.cars.service.MyOffersService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Optional;

@Controller
public class MyOffersController {

    private final MyOffersService myOffersService;
    private final CreateService createService;

    public MyOffersController(MyOffersService myOffersService, CreateService createService) {
        this.myOffersService = myOffersService;
        this.createService = createService;
    }

    @GetMapping("/myOffers")
    public String catalog(Model model,
                          @AuthenticationPrincipal CarsDealershipUserDetails userDetails,
                          @PageableDefault(
                                  sort = "make",
                                  direction = Sort.Direction.ASC,
                                  page = 0,
                                  size = 5) Pageable pageable) {

        model.addAttribute("myOffers", myOffersService.getMyOffers(pageable, userDetails));
        return "myOffers";
    }

    @GetMapping("/remove/{id}")
    public String removeCar(@PathVariable("id") Long id) {
        myOffersService.deleteById(id);
        return "redirect:/myOffers";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editCar(@PathVariable("id") Long id) {
        Optional<Car> car = myOffersService.getCarById(id);
        ModelAndView modelAndView = new ModelAndView("edit-car");
        modelAndView.addObject("car", car);
        return modelAndView;
    }

    @PostMapping("/save-edit")
    public String saveEdit(@ModelAttribute("car") CreateCarDTO carDTO) throws IOException {
        myOffersService.updateCar(carDTO);
        return "redirect:/myOffers";
    }

}
