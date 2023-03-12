package automobile.cars.web;

import automobile.cars.model.dto.InquiryDTO;
import automobile.cars.service.InquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/inquiries")
    public String suggestions() {
        return "inquiries";
    }

    @ModelAttribute("inquiryDTO")
    public InquiryDTO initInquiryDTO() {
        return new InquiryDTO();
    }

    @PostMapping("/inquiries")
    public String register(@Valid InquiryDTO inquiryDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.inquiryService.send(inquiryDTO)) {
            redirectAttributes.addFlashAttribute("inquiryDTO", inquiryDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.inquiryDTO", bindingResult);

            return "redirect:/inquiries";
        }

        return "redirect:/";
    }
}
