package automobile.cars.service;

import automobile.cars.model.dto.ChangeEmailDTO;
import automobile.cars.model.entity.User;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileSettingsService {

    private final UserRepository userRepository;

    public ProfileSettingsService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
