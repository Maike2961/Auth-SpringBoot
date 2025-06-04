package io.github.auth.user.mayki.user_authentication_basic.service;

import io.github.auth.user.mayki.user_authentication_basic.controller.dto.ClientDTO;
import io.github.auth.user.mayki.user_authentication_basic.model.Client;
import io.github.auth.user.mayki.user_authentication_basic.repository.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final PasswordEncoder encoder;

    public ClientService(ClientRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Client salvar(ClientDTO dto){
        Client entity = dto.toEntity();
        String encode = encoder.encode(entity.getClientSecret());
        entity.setClientSecret(encode);
        return repository.save(entity);
    }

    public Client obterPorClientId(String client){
        return repository.findByClientId(client);
    }
}
