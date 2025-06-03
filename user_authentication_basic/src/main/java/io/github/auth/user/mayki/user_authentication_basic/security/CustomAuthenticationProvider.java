package io.github.auth.user.mayki.user_authentication_basic.security;

import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import io.github.auth.user.mayki.user_authentication_basic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserService service;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(UserService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario usuario = service.obterPorLogin(login);

        boolean matchesPassword = MatchesPassword(usuario, password);

        if(matchesPassword){
            return new CustomAuthentication(usuario);
        }
        throw new UsernameNotFoundException("login ou senha incorretos");
    }

    private boolean MatchesPassword(Usuario usuario, String password){
        return passwordEncoder.matches(password, usuario.getPassword());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
