package io.github.auth.user.mayki.user_authentication_basic.security;

import io.github.auth.user.mayki.user_authentication_basic.model.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ServiceSecurity {

    public Usuario getUsuarioLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication instanceof CustomAuthentication customAuthentication){
            return customAuthentication.getUsuario();
        }
        return null;
    }
}
