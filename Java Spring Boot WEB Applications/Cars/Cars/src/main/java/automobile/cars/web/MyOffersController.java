package automobile.cars.web;

import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.service.MyOffersService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyOffersController {

    private final MyOffersService myOffersService;

    public MyOffersController(MyOffersService myOffersService) {
        this.myOffersService = myOffersService;
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
}
