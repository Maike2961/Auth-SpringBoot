package io.github.auth.user.mayki.user_authentication_basic.service.Token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.github.auth.user.mayki.user_authentication_basic.Controller.dto.AutenDTO;
import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import io.github.auth.user.mayki.user_authentication_basic.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

@Component
public class Token {

    private UserRepository repository;

    public Token(UserRepository repository){
        this.repository = repository;
    }

    public String obterToken(AutenDTO dto){

        Optional<Usuario> byLogin = repository.findByLogin(dto.login());
        if(byLogin.isPresent()){
            return gerarTokenJwt(byLogin.get());
        }
        throw new UsernameNotFoundException("Usuario não encontrado");
    }

    public String gerarTokenJwt(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256("My-secret");

            String sign = JWT.create()
                    .withIssuer("auten-api")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(geraExpiracao())
                    .sign(algorithm);
            return sign;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token: " + e.getMessage());
        }
    }

    public String validateToken(String token){
        try{

            Algorithm algorithm = Algorithm.HMAC256("My-secret");

            return JWT.require(algorithm)
                    .withIssuer("auten-api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Instant geraExpiracao() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }
}
