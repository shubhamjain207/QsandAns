package com.qsanspack.qsandans.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String like_count;
    private String like_user;
    private String like_user_post;
    private String like_time;
    private String like_time_milli;

    public int getId() {
        return id;
    }
    public Like(int id, String like_count, String like_user, String like_user_post, String like_time,
            String like_time_milli) {
        this.id = id;
        this.like_count = like_count;
        this.like_user = like_user;
        this.like_user_post = like_user_post;
        this.like_time = like_time;
        this.like_time_milli = like_time_milli;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getLike_count() {
        return like_count;
    }
    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }
    public String getLike_user() {
        return like_user;
    }
    public void setLike_user(String like_user) {
        this.like_user = like_user;
    }
    public String getLike_user_post() {
        return like_user_post;
    }
    public void setLike_user_post(String like_user_post) {
        this.like_user_post = like_user_post;
    }
    public String getLike_time() {
        return like_time;
    }
    public void setLike_time(String like_time) {
        this.like_time = like_time;
    }
    public String getLike_time_milli() {
        return like_time_milli;
    }
    public void setLike_time_milli(String like_time_milli) {
        this.like_time_milli = like_time_milli;
    }

    
}
