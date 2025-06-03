package io.github.auth.user.mayki.user_authentication_basic.controller.dto;

import io.github.auth.user.mayki.user_authentication_basic.Enum.UserTypes;
import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;

import java.util.List;

public record UserDTO(
        String email,
        String login,
        String password,
        List<UserTypes> roles) {

    public Usuario toEntity(){
        return new Usuario(
                email,
                login,
                password,
                roles
        );
    }
}
