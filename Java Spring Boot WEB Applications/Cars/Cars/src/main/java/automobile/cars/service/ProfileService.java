package automobile.cars.service;

import automobile.cars.model.dto.ChangeEmailDTO;
import automobile.cars.model.dto.ChangePasswordDTO;
import automobile.cars.model.entity.User;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.repository.UserRepository;
import automobile.cars.view.ProfileViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ProfileService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public ProfileService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public boolean changeEmail(CarsDealershipUserDetails userDetails, ChangeEmailDTO changeEmailDTO) throws IOException, MessagingException {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (changeEmailDTO.getNewEmail().isEmpty()) {
            return false;
        }

        if (changeEmailDTO.getConfirmNewEmail().isEmpty()) {
            return false;
        }

        if (!changeEmailDTO.getNewEmail().equals(changeEmailDTO.getConfirmNewEmail())) {
            return false;
        }

        if (user.getEmail().equals(changeEmailDTO.getNewEmail())) {
            return false;
        }

        user.setEmail(changeEmailDTO.getNewEmail());

        userRepository.save(user);

        String email = user.getEmail();
        String subject = "Email Change Confirmation";

        // Read the HTML template into a String variable
        String htmlTemplate = readFile();

        // Replace placeholders in the HTML template with dynamic values

        htmlTemplate = htmlTemplate
                .replace("{{username}}", user.getUsername())
                .replace("{{type}}", "Email")
                .replace("{{action}}", "changed")
                .replace("{{confirmationType}}", "Email Change");

        // Send email using the HTML template
        emailService.sendHtmlEmail(email, subject, htmlTemplate);

        return true;
    }

    public boolean changePassword(CarsDealershipUserDetails userDetails, ChangePasswordDTO changePasswordDTO) throws IOException, MessagingException {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (changePasswordDTO.getCurrentPassword().isEmpty()) {
            return false;
        }

        if (changePasswordDTO.getNewPassword().isEmpty()) {
            return false;
        }

        if (changePasswordDTO.getConfirmNewPassword().isEmpty()) {
            return false;
        }

        //  if (!user.getPassword().equals(passwordEncoder.encode(changePasswordDTO.getCurrentPassword()))) {
        //      return false;
        //  }

        if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmNewPassword())) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));

        userRepository.save(user);

        String email = user.getEmail();
        String subject = "Password Change Confirmation";

        // Read the HTML template into a String variable
        String htmlTemplate = readFile();

        // Replace placeholders in the HTML template with dynamic values
        htmlTemplate = htmlTemplate
                .replace("{{username}}", user.getUsername())
                .replace("{{type}}", "Password")
                .replace("{{action}}", "changed")
                .replace("{{confirmationType}}", "Password Change");

        // Send email using the HTML template
        emailService.sendHtmlEmail(email, subject, htmlTemplate);

        return true;
    }

    public ProfileViewModel getUserDetails(CarsDealershipUserDetails userDetails) {

        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());

        return modelMapper.map(user, ProfileViewModel.class);
    }

    public void deleteUserAccount(CarsDealershipUserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }

    private String readFile() throws IOException {
        // Read contents of file into a string
        return new String(Files.readAllBytes(Paths
                .get("C:\\Users\\tasheva\\Desktop\\Cars\\Cars\\src\\main\\resources\\templates\\emailConfirmation.html")));
    }
}
