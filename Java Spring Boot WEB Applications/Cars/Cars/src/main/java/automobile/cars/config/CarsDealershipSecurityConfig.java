package automobile.cars.config;

import automobile.cars.repository.UserRepository;
import automobile.cars.service.CarsDealershipUserDetailsService;
import automobile.cars.service.OAuthSuccessHandler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class CarsDealershipSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           OAuthSuccessHandler oAuthSuccessHandler) throws Exception {
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/", "/login", "/register").permitAll().
                antMatchers("/assets/**", "/contact", "/inquiries", "/terms", "/create", "catalog").permitAll().
                anyRequest().
                authenticated().
                and().formLogin().
                loginPage("/login").
                usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                defaultSuccessUrl("/").
                failureForwardUrl("/login-error").
                and().logout().
                logoutUrl("/logout").
                logoutSuccessUrl("/").
                invalidateHttpSession(true).
                deleteCookies("JSESSIONID");

        return http.build();
    }

    @Primary
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CarsDealershipUserDetailsService(userRepository);
    }
}


