package com.qsanspack.qsandans.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.query.spi.QueryEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.qsanspack.qsandans.entities.Comment;
import com.qsanspack.qsandans.entities.Like;
import com.qsanspack.qsandans.entities.Question;
import com.qsanspack.qsandans.entities.User;
import com.qsanspack.qsandans.repos.CommentRepo;
import com.qsanspack.qsandans.repos.QuestionRepo;
import com.qsanspack.qsandans.repos.UserRepo;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private QuestionRepo repo1;

    @Autowired
    private CommentRepo repo2;

  

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
       
        User user = repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User name not found"));;

        
        return user;
        

    }

   
    public User setQs(String username,String qs,String qsTime,String qsUser,String qsTimeMilli, int likeCount){
       
        User user= repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User name not found"));

        if(user!=null){
            
            repo.save(user);
            repo1.save(new Question(0, qs,qsTime,qsUser,qsTimeMilli, likeCount));
            
        }


        return user;
        

    }

    public void updateLikeCount(int questionId, int likeCount){


        repo1.updateLikeCount(questionId, likeCount);

    }


    public void updateLikedQuestions(int questionId, ArrayList<Integer> likedQuestions){


        repo.updateLikedQuestions(questionId, likedQuestions);

    }



    public User setComment(String comment,String commentTime,String commentUser,String commentPostUser,String commentTimeMilli){
       
        User user= repo.findByUsername(commentUser).orElseThrow(()->new UsernameNotFoundException("User name not found"));

        if(user!=null){
            
            // repo.save(user);

            repo2.save(new Comment(0, comment, commentPostUser ,commentTime,commentTimeMilli,commentUser));
        }


        return user;
        

    }

    
    public List<Question> getAllQs(String username){
       
        //User user= repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User name not found"));

        return repo1.findAll();
        

    }

    public List<Question> getUserQs(String username){
       
        //User user= repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User name not found"));

        return repo1.findByQuestionUser(username);
        

    }


    public List<Comment> getAllComments(String username){
       
        //User user= repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User name not found"));

        return repo2.findAll();
        

    }


   
    
}
