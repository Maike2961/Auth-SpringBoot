package io.github.auth.user.mayki.user_authentication_basic.controller;

import io.github.auth.user.mayki.user_authentication_basic.security.CustomAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

    @GetMapping
    @ResponseBody
    public String home(Authentication authentication) {
        if (authentication instanceof CustomAuthentication customAuthentication) {
            System.out.println(customAuthentication.getUsuario());
        }
        return "Olá " + authentication.getName();
    }

}
