package com.example.ontuan6.model;

import java.io.Serializable;

public class SystemMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return "Username: " + username + "\n" + "Password: " + password + "\n";
    }
}
