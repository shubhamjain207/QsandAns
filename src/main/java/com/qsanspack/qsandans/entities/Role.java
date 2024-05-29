package com.qsanspack.qsandans.entities;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// @Entity
// @Table(name="roles")
public class Role implements GrantedAuthority {


    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO) 
    // @Column(name="role_id")



    private String authority;
    
    public Role(){
        super();
    }

    public Role(String authority){
        this.authority = authority;
    }

   

    @Override
    public String getAuthority() {
         
        return this.authority;
    }

    public void setAuthority() {
        this.authority = authority;
    }  
    

 





    
}
