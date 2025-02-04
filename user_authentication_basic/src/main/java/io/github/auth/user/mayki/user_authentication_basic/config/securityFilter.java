package io.github.auth.user.mayki.user_authentication_basic.config;


import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import io.github.auth.user.mayki.user_authentication_basic.repository.UserRepository;
import io.github.auth.user.mayki.user_authentication_basic.service.AutenticacaoService;
import io.github.auth.user.mayki.user_authentication_basic.service.Token.Token;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class securityFilter extends OncePerRequestFilter {

    private Token tokenValida;
    
    private UserRepository repository;

    public securityFilter(Token token, UserRepository repository){
        this.tokenValida = token;
        this.repository = repository;
        
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = headerToken(request);

        if(token != null){
            String login = tokenValida.validateToken(token);
            Optional<Usuario> byLogin = repository.findByLogin(login);

            var usuario = byLogin.get();

            var autentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autentication);


        }
        filterChain.doFilter(request, response);

    }

    public String headerToken(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");

        if(authorization == null){
            return null;
        }
        if(!authorization.split(" ")[0].equals("Bearer")){
            return null;
        }
        return authorization.split(" ")[1];

    }
}
