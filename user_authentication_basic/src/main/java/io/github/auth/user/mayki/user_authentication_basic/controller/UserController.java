package io.github.auth.user.mayki.user_authentication_basic.controller;

import io.github.auth.user.mayki.user_authentication_basic.controller.dto.UserDTO;
import io.github.auth.user.mayki.user_authentication_basic.security.CustomAuthentication;
import io.github.auth.user.mayki.user_authentication_basic.security.ServiceSecurity;
import io.github.auth.user.mayki.user_authentication_basic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService service;
    private final ServiceSecurity security;

    public UserController(UserService service, ServiceSecurity serviceSecurity) {
        this.service = service;
        this.security = serviceSecurity;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String olaAdmin(){
        System.out.println("esse é o usuário: " + security.getUsuarioLogado().getLogin());
        return "Olá Admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String olaUser(){
        return "Olá user";
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody UserDTO userDTO){
        service.salvar(userDTO);
        return ResponseEntity.accepted().body(userDTO);
    }

}

