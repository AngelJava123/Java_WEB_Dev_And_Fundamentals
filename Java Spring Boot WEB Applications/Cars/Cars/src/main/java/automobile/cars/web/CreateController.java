package automobile.cars.web;

import automobile.cars.model.dto.CreateCarDTO;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.service.CreateService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class CreateController {

    private final CreateService createService;

    public CreateController(CreateService createService) {
        this.createService = createService;
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @ModelAttribute("createCarDTO")
    public CreateCarDTO createCarDTO() {
        return new CreateCarDTO();
    }

    @PostMapping("/create")
    public String createCar(@Valid CreateCarDTO createCarDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            @AuthenticationPrincipal CarsDealershipUserDetails userDetails) throws IOException {

        if (bindingResult.hasErrors() || !this.createService.create(createCarDTO, userDetails)) {
            redirectAttributes.addFlashAttribute("createCarDTO", createCarDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createCarDTO",
                    bindingResult);
            // redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/create";
        }

        /*this.createService.create(createCarDTO, userDetails);*/

        return "redirect:/";
    }
}
