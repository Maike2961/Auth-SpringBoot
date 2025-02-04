package io.github.auth.user.mayki.user_authentication_basic.service.Validador;

import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import io.github.auth.user.mayki.user_authentication_basic.repository.UserRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class validateUser {

    private UserRepository repository;

    public validateUser(UserRepository repository){
        this.repository = repository;
    }

    public void validar(Usuario usuario){
        if(existsUser(usuario)){
            throw new RuntimeException("Usuario ja cadastrado");
        }
    }

    private boolean existsUser(Usuario usuario) {
        Optional<Usuario> byLogin = repository.findByLogin(usuario.getLogin());

        if(usuario.getId() == null){
            return byLogin.isPresent();
        }

        return byLogin.map(usuario1 -> !usuario1.getId().equals(usuario.getId()))
                .orElse(false);

    }

}
