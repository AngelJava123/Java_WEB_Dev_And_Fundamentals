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

    public boolean register(UserRegisterDTO registerDTO) {

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

        //Send email after successful registration.
        String email = user.getEmail();
        String subject = "Registration Confirmation";
        String body = "Dear " + user.getUsername() + ",\n\nThank you for registering with AutoGenius!\n\n" +
                "We're excited to have you on board and can't wait to help you find the car of your dreams.\n\n" +
                "To get started, log in to your account and browse our wide selection of cars, or search for specific makes and models.\n\n" +
                "If you have any questions or need assistance, don't hesitate to contact us at support@autogenius.com.\n\n" +
                "Thank you again for choosing AutoGenius. We look forward to serving you!\n\n" +
                "Best regards,\nAutoGenius Team";
        emailService.sendSimpleEmail(email, subject, body);

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
}
