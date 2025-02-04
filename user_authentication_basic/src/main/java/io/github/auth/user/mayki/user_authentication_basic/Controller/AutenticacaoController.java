package io.github.auth.user.mayki.user_authentication_basic.Controller;

import io.github.auth.user.mayki.user_authentication_basic.Controller.dto.AutenDTO;
import io.github.auth.user.mayki.user_authentication_basic.service.AutenticacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private AutenticacaoService service;


    public AutenticacaoController(AuthenticationManager authenticationManager,
                                  AutenticacaoService service){
        this.authenticationManager = authenticationManager;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity auten(@RequestBody AutenDTO dto){

        var auth = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        authenticationManager.authenticate(auth);
        String tokenSend = service.tokenSend(dto);
        return ResponseEntity.ok().body(tokenSend);
    }
}
