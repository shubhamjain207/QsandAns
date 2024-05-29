package com.qsanspack.qsandans.entities;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "questions")
public class Question{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String questioncontent;
    private String questionTime;
    private String question_time_milli;
    
    public String getQuestion_time_milli() {
        return question_time_milli;
    }

    public void setQuestion_time_milli(String question_time_milli) {
        this.question_time_milli = question_time_milli;
    }

    public String getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(String questionTime) {
        this.questionTime = questionTime;
    }

    public String getQuestionUser() {
        return questionUser;
    }

    public void setQuestionUser(String questionUser) {
        this.questionUser = questionUser;
    }

    private String questionUser;
    

    public int getId() {
        return id;
    }

    

    public Question(int id, String questioncontent, String questionTime, String questionUser,String question_time_milli) {
        this.id = id;
        this.questioncontent = questioncontent;
        this.questionTime = questionTime;
        this.questionUser = questionUser;
        this.question_time_milli = question_time_milli;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent;
    }

    public Question() {
    }
  
    
    
}
