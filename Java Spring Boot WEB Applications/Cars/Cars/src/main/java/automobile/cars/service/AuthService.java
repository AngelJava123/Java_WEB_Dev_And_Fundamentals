package automobile.cars.service;

import automobile.cars.model.dto.UserRegisterDTO;
import automobile.cars.model.entity.User;
import automobile.cars.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private CarsDealershipUserDetailsService carsDealershipUserDetailsService;

    public AuthService(UserRepository userRepository,
                       ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public boolean register(UserRegisterDTO registerDTO) throws IOException, MessagingException {

        Optional<User> byUsername = this.userRepository.findByUsername(registerDTO.getUsername());

        if (byUsername.isPresent()) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registerDTO.getEmail());

        if (byEmail.isPresent()) {
            return false;
        }

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        User user = modelMapper.map(registerDTO, User.class);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(user);

        String email = user.getEmail();
        String subject = "Registration Confirmation";

        // Read the HTML template into a String variable
        String htmlTemplate = readFile();

        // Replace placeholders in the HTML template with dynamic values
        htmlTemplate = htmlTemplate
                .replace("{{username}}", user.getUsername())
                .replace("{{type}}", "Registration")
                .replace("{{action}}", "accepted")
                .replace("{{confirmationType}}", "Registration");

        // Send email using the HTML template
        emailService.sendHtmlEmail(email, subject, htmlTemplate);

        return true;
    }

    public void login(String userName) {
        UserDetails userDetails =
                carsDealershipUserDetailsService.loadUserByUsername(userName);

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }

    public void createUserIfNotExist(String email) {

        var userOpt = this.userRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            var newUser = new User();
            newUser.setEmail(email);
            newUser.setPassword(null);
            userRepository.save(newUser);
        }
    }

    private String readFile() throws IOException {
        // Read contents of file into a string
        return new String(Files.readAllBytes(Paths
                .get("C:\\Users\\tasheva\\Desktop\\Cars\\Cars\\src\\main\\resources\\templates\\emailConfirmation.html")));
    }
}
