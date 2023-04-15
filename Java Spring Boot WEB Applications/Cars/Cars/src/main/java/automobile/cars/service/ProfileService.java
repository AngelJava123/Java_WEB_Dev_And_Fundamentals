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

import java.util.Optional;

@Service
public class ProfileService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public ProfileService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean changeEmail(CarsDealershipUserDetails userDetails, ChangeEmailDTO changeEmailDTO) {
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

        return true;
    }

    public boolean changePassword(CarsDealershipUserDetails userDetails, ChangePasswordDTO changePasswordDTO) {
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

        return true;
    }

    public ProfileViewModel getUserDetails(CarsDealershipUserDetails userDetails) {

        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());

        return modelMapper.map(user, ProfileViewModel.class);
    }
}
