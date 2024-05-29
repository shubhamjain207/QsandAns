package com.qsanspack.qsandans.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsanspack.qsandans.entities.Question;
import com.qsanspack.qsandans.entities.User;

public interface QuestionRepo extends JpaRepository<Question,Integer> {

     List<Question> findByQuestionUser(String questionUser);
    
}
