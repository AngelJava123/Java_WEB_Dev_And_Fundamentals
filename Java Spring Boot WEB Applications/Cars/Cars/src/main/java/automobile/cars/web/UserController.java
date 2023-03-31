package automobile.cars.web;

import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.service.AuthService;
import automobile.cars.view.ProfileViewModel;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, userName);
        redirectAttributes.addFlashAttribute("bad_credentials", true);

        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Model model,
                          @AuthenticationPrincipal CarsDealershipUserDetails userDetails) {

        model.addAttribute("profileViewModel", new ProfileViewModel());
        model.addAttribute("profileDetails", authService.getUserDetails(userDetails));

        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("profileViewModel") ProfileViewModel profileViewModel,
                                @AuthenticationPrincipal CarsDealershipUserDetails userDetails) {
        authService.updateUserDetails(userDetails, profileViewModel);
        return "redirect:/profile";
    }

}
