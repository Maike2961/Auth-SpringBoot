package io.github.auth.user.mayki.user_authentication_basic.model;

import java.util.List;
import java.util.UUID;

import io.github.auth.user.mayki.user_authentication_basic.Enum.UserTypes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private List<UserTypes> role ;


    public Usuario(String email, String login, String password, List<UserTypes> roles) {
        this.email = email;
        this.login= login;
        this.password = password;
        this.role = roles;
    }

    public Usuario() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserTypes> getRole() {
        return role;
    }

    public void setRole(List<UserTypes> role) {
        this.role = role;
    }
}
