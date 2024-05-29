package com.qsanspack.qsandans.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String comment_content;
    private String comment_user;
    private String comment_user_post;
    private String comment_time;
    private String comment_time_milli;

    public Comment(int id, String comment_content, String comment_user, String comment_time, String comment_time_milli,String comment_user_post) {
        this.id = id;
        this.comment_content = comment_content;
        this.comment_user = comment_user;
        this.comment_time = comment_time;
        this.comment_time_milli = comment_time_milli;
        this.comment_user_post = comment_user_post;
    }

    public String getComment_user_post() {
        return comment_user_post;
    }

    public void setComment_user_post(String comment_user_post) {
        this.comment_user_post = comment_user_post;
    }

    public Comment() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getComment_content() {
        return comment_content;
    }
    public String getComment_time_milli() {
        return comment_time_milli;
    }

    public void setComment_time_milli(String comment_time_milli) {
        this.comment_time_milli = comment_time_milli;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }
    public String getComment_user() {
        return comment_user;
    }
    public void setComment_user(String comment_user) {
        this.comment_user = comment_user;
    }
    public String getComment_time() {
        return comment_time;
    }
    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

}
