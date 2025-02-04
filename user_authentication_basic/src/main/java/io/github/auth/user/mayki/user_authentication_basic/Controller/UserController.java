package io.github.auth.user.mayki.user_authentication_basic.Controller;

import io.github.auth.user.mayki.user_authentication_basic.Controller.dto.UserDTO;
import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import io.github.auth.user.mayki.user_authentication_basic.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/admin")
    public String ola(){
        return "Olá Admin";
    }

    @GetMapping("/user")
    public String olaUser(){
        return "Olá user";
    }

    @PostMapping
    private ResponseEntity salvar(@RequestBody UserDTO userDTO){
        service.salvar(userDTO);

        return ResponseEntity.accepted().body(userDTO);
    }

}

