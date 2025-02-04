package io.github.auth.user.mayki.user_authentication_basic.Enum;

public enum UserTypes {
    ADMIN("admin"),
    USER("user");

    private String descricao;

    UserTypes(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
