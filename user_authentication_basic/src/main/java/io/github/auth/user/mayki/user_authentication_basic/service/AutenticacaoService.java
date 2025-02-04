package io.github.auth.user.mayki.user_authentication_basic.service;


import io.github.auth.user.mayki.user_authentication_basic.Controller.dto.AutenDTO;
import io.github.auth.user.mayki.user_authentication_basic.service.Token.Token;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    private Token token;

    public AutenticacaoService(Token token){
        this.token = token;
    }

    public String tokenSend(AutenDTO autenDTO){
        return token.obterToken(autenDTO);
    }

}
