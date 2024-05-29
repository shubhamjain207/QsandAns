package com.qsanspack.qsandans.entities;

import org.springframework.security.oauth2.jwt.Jwt;

public class LoginResponseDTO {
    

    private User user;
    private String jwt;

    
    public LoginResponseDTO(User user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }


    public LoginResponseDTO() {

        super();

    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public String getJwt() {
        return jwt;
    }


    public void setJwt(String jwt) {
        this.jwt = jwt;
    }




 

}
