package com.qsanspack.qsandans.services;

import lombok.Builder;

@Builder
public class JwtResponse {
    private String JwtToken;
    private String username;
    public String getJwtToken() {
        return JwtToken;
    }
    public void setJwtToken(String jwtToken) {
        JwtToken = jwtToken;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public JwtResponse() {
    }
    public JwtResponse(String jwtToken, String username) {
        JwtToken = jwtToken;
        this.username = username;
    }
    @Override
    public String toString() {
        return "JwtResponse [JwtToken=" + JwtToken + ", username=" + username + "]";
    }

    
}
