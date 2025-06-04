package io.github.auth.user.mayki.user_authentication_basic.controller.dto;

import io.github.auth.user.mayki.user_authentication_basic.model.Client;

public record ClientDTO(String clientId,
                        String clientSecret,
                        String scope) {

    public Client toEntity(){
        return new Client(clientId, clientSecret, scope);
    }
}
