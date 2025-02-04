package io.github.auth.user.mayki.user_authentication_basic.repository;

import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByLogin(String login);
}
