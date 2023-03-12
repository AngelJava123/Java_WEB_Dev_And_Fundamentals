package automobile.cars.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class OAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final AuthService authService;

    public OAuthSuccessHandler(AuthService authService) {
        this.authService = authService;
        setDefaultTargetUrl("/");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        if (authentication instanceof
                OAuth2AuthenticationToken oAuth2AuthenticationToken) {
            var userEmail = Objects.requireNonNull(oAuth2AuthenticationToken.
                    getPrincipal().
                    getAttribute("email")).
                    toString();

            authService.createUserIfNotExist(userEmail);
            authService.login(userEmail);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
