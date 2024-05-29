package com.qsanspack.qsandans.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsanspack.qsandans.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{
    
}
