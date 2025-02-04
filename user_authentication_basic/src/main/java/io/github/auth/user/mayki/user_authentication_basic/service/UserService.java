package io.github.auth.user.mayki.user_authentication_basic.service;
import io.github.auth.user.mayki.user_authentication_basic.Controller.dto.UserDTO;
import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import io.github.auth.user.mayki.user_authentication_basic.repository.UserRepository;
import io.github.auth.user.mayki.user_authentication_basic.service.Validador.validateUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;
    private validateUser validateUser;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, validateUser validador,PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.validateUser = validador;
        this.passwordEncoder = passwordEncoder;
    }

    public void salvar(UserDTO userDTO){
        Usuario entity = userDTO.toEntity();
        String password = entity.getPassword();
        entity.setPassword(passwordEncoder.encode(password));
        validateUser.validar(entity);
        repository.save(entity);
    }


}
