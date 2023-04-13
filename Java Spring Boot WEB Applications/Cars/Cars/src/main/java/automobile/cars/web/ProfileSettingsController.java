package automobile.cars.web;

import automobile.cars.model.dto.ChangeEmailDTO;
import automobile.cars.model.dto.InquiryDTO;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.service.ProfileSettingsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ProfileSettingsController {

    private final ProfileSettingsService profileSettingsService;

    public ProfileSettingsController(ProfileSettingsService profileSettingsService) {
        this.profileSettingsService = profileSettingsService;
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

        if (bindingResult.hasErrors() || !this.profileSettingsService.changeEmail(userDetails, changeEmailDTO)) {
            redirectAttributes.addFlashAttribute("changeEmailDTO", changeEmailDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.changeEmailDTO", bindingResult);

            return "redirect:/change-email";
        }

        session.invalidate();

        return "redirect:/login";
    }
}
