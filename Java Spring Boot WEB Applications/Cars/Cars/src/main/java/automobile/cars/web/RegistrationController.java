package automobile.cars.web;

import automobile.cars.model.dto.UserRegisterDTO;
import automobile.cars.service.AuthService;
import automobile.cars.service.TermService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final AuthService authService;
    private final TermService termService;

    public RegistrationController(AuthService authService, TermService termService) {
        this.authService = authService;
        this.termService = termService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO initRegisterDTO() {
        return new UserRegisterDTO();
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO registerDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.authService.register(registerDTO)) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);

            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/terms")
    public String terms(Model model) {
        model.addAttribute("termsInfo", termService.getTermsInfo());
        return "terms";
    }
}
