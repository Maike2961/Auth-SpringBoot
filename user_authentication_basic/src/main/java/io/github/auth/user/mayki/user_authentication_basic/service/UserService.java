package io.github.auth.user.mayki.user_authentication_basic.service;
import io.github.auth.user.mayki.user_authentication_basic.controller.dto.UserDTO;
import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import io.github.auth.user.mayki.user_authentication_basic.repository.UserRepository;
import io.github.auth.user.mayki.user_authentication_basic.service.Validador.validateUser;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final validateUser validateUser;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,
                       validateUser validateUser,
                       PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.validateUser = validateUser;
        this.passwordEncoder = passwordEncoder;
    }


    public void salvar(UserDTO userDTO){
        Usuario entity = userDTO.toEntity();
        String password = entity.getPassword();
        entity.setPassword(passwordEncoder.encode(password));
        validateUser.validar(entity);
        repository.save(entity);
    }

    public Usuario obterPorLogin(String login){
        return repository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

}
