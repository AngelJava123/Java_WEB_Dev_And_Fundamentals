package automobile.cars.web;

import automobile.cars.service.CatalogService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
