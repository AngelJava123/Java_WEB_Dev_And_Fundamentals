package automobile.cars.web;

import automobile.cars.service.CatalogService;
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
    public String catalog(Model model) {
        model.addAttribute("allCars", catalogService.getAllCars());
        return "catalog";
    }
}
