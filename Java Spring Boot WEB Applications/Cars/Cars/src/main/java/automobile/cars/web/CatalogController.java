package automobile.cars.web;

import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.service.CatalogService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/catalog")
    public String catalog(Model model,
                          @PageableDefault(
                                  sort = "make",
                                  direction = Sort.Direction.ASC,
                                  page = 0,
                                  size = 5) Pageable pageable) {
        model.addAttribute("allCars", catalogService.getAllCars(pageable));
        return "catalog";
    }

    @GetMapping("/add-favourite/{id}")
    public String add(@PathVariable("id") Long id,
                      @AuthenticationPrincipal CarsDealershipUserDetails user) {

        this.catalogService.addCarToUserFavourites(id, user);

        return "redirect:/catalog";
    }

    @GetMapping("/remove-favourite/{id}")
    public String remove(@PathVariable("id") Long id,
                      @AuthenticationPrincipal CarsDealershipUserDetails user) {

        this.catalogService.removeCarFromUserFavourites(id, user);

        return "redirect:/catalog";
    }

    @GetMapping("/favourites")
    public String favourites(Model model,
                          @PageableDefault(
                                  sort = "make",
                                  direction = Sort.Direction.ASC,
                                  page = 0,
                                  size = 5) Pageable pageable) {
        model.addAttribute("allCars", catalogService.getFavouriteCars(pageable));
        return "favourites";
    }
}
