package io.github.auth.user.mayki.user_authentication_basic.controller;

import io.github.auth.user.mayki.user_authentication_basic.controller.dto.ClientDTO;
import io.github.auth.user.mayki.user_authentication_basic.model.Client;
import io.github.auth.user.mayki.user_authentication_basic.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Client> salvar(@RequestBody ClientDTO dto){
        service.salvar(dto);
        return ResponseEntity.ok().build();
    }
}
