package com.example.sample.login;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class login {

    @Id
    private String email;
    private String password;
    private String role;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
