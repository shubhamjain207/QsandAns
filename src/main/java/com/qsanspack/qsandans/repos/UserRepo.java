package com.qsanspack.qsandans.repos;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsanspack.qsandans.entities.User;


public interface UserRepo extends JpaRepository<User,Integer>{

    
    public Optional<User> findByUsername(String username);
   // Optional<User> findByAuthority(String authority);

    
}
