package com.qsanspack.qsandans.entities;

public class RegistrationDTO {

    private String username;
    private String password;
    private String profileimage;
    private String fullname;

    public RegistrationDTO(){
        super();
    }

    public RegistrationDTO(String username, String password,String profileimage,String fullname) {
        this.username = username;
        this.password = password;
        this.profileimage = profileimage;
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileimage() {
        return profileimage;
    }

    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "RegistrationDTO [username=" + username + ", password=" + password + ", profilepicture=" + profileimage
                + ", fullname=" + fullname + "]";
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
