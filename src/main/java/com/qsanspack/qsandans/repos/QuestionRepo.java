package com.qsanspack.qsandans.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qsanspack.qsandans.entities.Question;
import com.qsanspack.qsandans.entities.User;

import jakarta.transaction.Transactional;

public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findByQuestionUser(String questionUser);

    @Modifying
    @Transactional
    @Query("UPDATE Question q SET q.likeCount = :likeCount WHERE q.id = :id")
    void updateLikeCount(@Param("id") Integer id, @Param("likeCount") int likeCount);
    
}
