package automobile.cars.service;

import automobile.cars.model.dto.UserRegisterDTO;
import automobile.cars.model.entity.User;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.repository.UserRepository;
import automobile.cars.view.ProfileViewModel;
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
    private CarsDealershipUserDetailsService carsDealershipUserDetailsService;

    public AuthService(UserRepository userRepository,
                       ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
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

    public ProfileViewModel getUserDetails(CarsDealershipUserDetails userDetails) {

        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());

        return modelMapper.map(user, ProfileViewModel.class);
    }

    public void updateUserDetails(CarsDealershipUserDetails userDetails, ProfileViewModel profileViewModel) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(profileViewModel.getEmail());
        // user.setUsername(profileViewModel.getUsername());
        userRepository.save(user);
    }
}
