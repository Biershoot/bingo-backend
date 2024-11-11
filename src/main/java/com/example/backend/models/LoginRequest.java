package com.example.backend.models;

public class LoginRequest {
    private String username;
    private String password;

    // Constructor vacío
    public LoginRequest() {
    }

    // Constructor con parámetros
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters y setters
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
}
