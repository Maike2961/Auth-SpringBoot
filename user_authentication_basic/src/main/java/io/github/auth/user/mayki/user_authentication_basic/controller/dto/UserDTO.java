package io.github.auth.user.mayki.user_authentication_basic.Controller.dto;

import io.github.auth.user.mayki.user_authentication_basic.Enum.UserTypes;
import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;

import java.util.Set;

public record UserDTO(
        String nome,
        String login,
        String password,
        UserTypes roles) {

    public Usuario toEntity(){
        return new Usuario(nome, login, password, roles);
    }
}
