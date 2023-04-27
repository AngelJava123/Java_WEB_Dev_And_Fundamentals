package automobile.cars.web;

import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.service.SearchService;
import automobile.cars.view.CarViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public String showSearchPage(Model model) {
        model.addAttribute("createCarDTO", new CreateCarDTO());
        return "search";
    }

    @PostMapping("/search")
    public String searchCars(@ModelAttribute CreateCarDTO carDTO,
                             Model model,
                             @PageableDefault(
                                     sort = "make",
                                     direction = Sort.Direction.ASC,
                                     page = 0,
                                     size = 5) Pageable pageable) {
        Page<CarViewModel> cars = searchService.searchCars(carDTO, pageable);
        model.addAttribute("allCars", cars);
        return "results";
    }
}
