package automobile.cars.web;

import automobile.cars.model.dto.ChangeEmailDTO;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.service.ProfileService;
import automobile.cars.view.ProfileViewModel;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profile")
    public String profile(Model model,
                          @AuthenticationPrincipal CarsDealershipUserDetails userDetails) {

        model.addAttribute("profileViewModel", new ProfileViewModel());
        model.addAttribute("profileDetails", profileService.getUserDetails(userDetails));

        return "profile";
    }

    @GetMapping("/change-email")
    public String changeEmail() {
        return "change-email";
    }

    @GetMapping("/change-password")
    public String changePassword() {
        return "change-password";
    }

    @ModelAttribute("changeEmailDTO")
    public ChangeEmailDTO initChangeEmailDTO() {
        return new ChangeEmailDTO();
    }

    @PostMapping("/change-email")
    public String changeEmail(@Valid ChangeEmailDTO changeEmailDTO,
                              BindingResult bindingResult,
                              @AuthenticationPrincipal CarsDealershipUserDetails userDetails,
                              HttpSession session,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.profileService.changeEmail(userDetails, changeEmailDTO)) {
            redirectAttributes.addFlashAttribute("changeEmailDTO", changeEmailDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.changeEmailDTO", bindingResult);

            return "redirect:/change-email";
        }

        session.invalidate();

        return "redirect:/login";
    }
}
