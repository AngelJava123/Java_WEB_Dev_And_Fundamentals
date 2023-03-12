package automobile.cars.service;

import automobile.cars.model.user.CarsDealershipUserDetails;
import automobile.cars.repository.UserRepository;
import automobile.cars.model.entity.Role;
import automobile.cars.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class CarsDealershipUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CarsDealershipUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findByEmail(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    private UserDetails map(User user) {

        return new CarsDealershipUserDetails(
                user.getPassword(),
                user.getEmail(),
                user.getRoles().
                        stream().
                        map(this::map).
                        toList());
    }

    private GrantedAuthority map(Role userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.getRole().name());
    }
}
