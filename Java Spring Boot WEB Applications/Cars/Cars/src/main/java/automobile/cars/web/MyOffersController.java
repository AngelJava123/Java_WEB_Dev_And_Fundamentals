package automobile.cars.web;

import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.model.entity.Car;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.service.CatalogService;
import automobile.cars.service.MyOffersService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Optional;

@Controller
public class MyOffersController {

    public static Long editCarId;
    private final MyOffersService myOffersService;
    private final CatalogService catalogService;

    public MyOffersController(MyOffersService myOffersService, CatalogService catalogService) {
        this.myOffersService = myOffersService;
        this.catalogService = catalogService;
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
    public String removeCar(@PathVariable("id") Long id,
                            @AuthenticationPrincipal CarsDealershipUserDetails userDetails) throws IOException {
        catalogService.removeCarFromUserFavourites(id, userDetails);
        myOffersService.deleteById(id);
        return "redirect:/myOffers";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editCar(@PathVariable("id") Long id) {
        Optional<Car> car = myOffersService.getCarById(id);
        ModelAndView modelAndView = new ModelAndView("edit-car");
        modelAndView.addObject("car", car);
        editCarId = id;
        return modelAndView;
    }

    @PostMapping("/save-edit")
    public String saveEdit(@ModelAttribute("car") CreateCarDTO carDTO) throws IOException {
        myOffersService.updateCar(carDTO, editCarId);
        return "redirect:/myOffers";
    }

    @GetMapping("/edit-img/{id}")
    public ModelAndView editImage(@PathVariable("id") Long id) {
        Optional<Car> car = myOffersService.getCarById(id);
        ModelAndView modelAndView = new ModelAndView("edit-image");
        modelAndView.addObject("car", car.get());
        return modelAndView;
    }

    @PostMapping("/car/{id}/img-upload")
    public String handleFileUpload(@PathVariable Long id, @RequestParam("image") MultipartFile file) throws IOException {
        Optional<Car> car = myOffersService.getCarById(id);
        if (car.isPresent()) {
            myOffersService.addImageToCar(car.get(), file);
        }
        return "redirect:/edit-img/" + car.get().getId();
    }

    @PostMapping("/car/{id}/img-delete")
    public String handleDeleteImage(@PathVariable("id") Long id, @RequestParam("imagePath") String imagePath) throws IOException {
        Optional<Car> car = myOffersService.getCarById(id);

        myOffersService.deleteImageFromCar(car.get(), imagePath);

        return "redirect:/edit-img/" + car.get().getId();
    }
}
