package com.qsanspack.qsandans.services;

public class JwtRequest {
    

    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String email) {
        this.username = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public JwtRequest() {
    }
    public JwtRequest(String email, String password) {
        this.username = email;
        this.password = password;
    }
    @Override
    public String toString() {
        return "JwtRequest [email=" + username + ", password=" + password + "]";
    }

    

}
