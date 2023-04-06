package ru.myappco.SpringBoot.Task1.entity;

import ru.myappco.SpringBoot.Task1.enums.Authorities;

import java.util.List;

public class User {

    private String login;
    private String password;

    private List<Authorities> authorities;

    public User() {
    }

    public User(String login, String password, List<Authorities> authorities) {
        this.login = login;
        this.password = password;
        this.authorities = authorities;
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

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }
}
