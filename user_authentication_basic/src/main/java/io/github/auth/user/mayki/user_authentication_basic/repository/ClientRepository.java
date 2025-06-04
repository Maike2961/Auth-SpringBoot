package io.github.auth.user.mayki.user_authentication_basic.repository;

import io.github.auth.user.mayki.user_authentication_basic.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Client findByClientId(String client);
}
