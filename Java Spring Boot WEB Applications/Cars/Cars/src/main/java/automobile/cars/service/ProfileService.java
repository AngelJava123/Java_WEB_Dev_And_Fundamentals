package automobile.cars.service;

import automobile.cars.model.dto.ChangeEmailDTO;
import automobile.cars.model.entity.User;
import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.repository.UserRepository;
import automobile.cars.view.ProfileViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ProfileService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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

    public ProfileViewModel getUserDetails(CarsDealershipUserDetails userDetails) {

        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());

        return modelMapper.map(user, ProfileViewModel.class);
    }
}
