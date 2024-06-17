package com.qsanspack.qsandans.repos;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qsanspack.qsandans.entities.User;

import jakarta.transaction.Transactional;


public interface UserRepo extends JpaRepository<User,Integer>{

    
    public Optional<User> findByUsername(String username);
   // Optional<User> findByAuthority(String authority);
    @Modifying
    @Transactional
    @Query("UPDATE User q SET q.likedQuestions = :likedQuestion WHERE q.id = :id")
    void updateLikedQuestions(@Param("id") Integer id, @Param("likedQuestion") ArrayList<Integer> likedQuestion);
    
}
