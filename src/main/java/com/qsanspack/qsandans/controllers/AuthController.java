package com.qsanspack.qsandans.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsanspack.qsandans.entities.Comment;
import com.qsanspack.qsandans.entities.Question;
import com.qsanspack.qsandans.entities.User;
import com.qsanspack.qsandans.services.AuthenticationService;
import com.qsanspack.qsandans.services.JwtHelper;
import com.qsanspack.qsandans.services.JwtResponse;
import com.qsanspack.qsandans.services.UserService;

    @RestController
    @RequestMapping("/auth")
    @CrossOrigin(origins = "*")
    public class AuthController {

    @Autowired
    private AuthenticationService service;

     @Autowired
    private UserService userService;


    @Autowired
    JwtHelper helper;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody Map<String, String> requestData) {
        
       ResponseEntity<User> user1 = service.registerUser(requestData.get("username"), requestData.get("password"),requestData.get("profileimage"), requestData.get("fullname"));
       return user1 ;

    }

    @GetMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@RequestParam String username,@RequestParam String password) {

        ResponseEntity<JwtResponse> user = service.login(username, password);
        return user;

    }

    
    @GetMapping("/profile")
    public User profile(@AuthenticationPrincipal User details) {
       
            return details;
        
       
    }

    @GetMapping("/home")
    public User home(@AuthenticationPrincipal User details) {
       
            return details;
        
    }

    @PostMapping("/setQs")
    public User setQs(@AuthenticationPrincipal User details,@RequestBody Map<String, String> requestData) {

            
             User user = userService.setQs(details.getUsername(), requestData.get("content"),requestData.get("time"),details.getUsername(),requestData.get("timemilli"));
             return user;
        
       
    }

    @PostMapping("/setComment")
    public User setComment(@AuthenticationPrincipal User details,@RequestBody Map<String, String> requestData) {

            
        User user = userService.setComment(requestData.get("content"),requestData.get("time"),details.getUsername(),requestData.get("content_user"),requestData.get("timemilli"));
        return user;
        
       
    }

    @GetMapping("/getAllQs")
    public List<Question> getAllQs(@AuthenticationPrincipal User details) {
           
        List<Question> list = userService.getAllQs(details.getUsername());

        Collections.reverse(list);

        return list;
       
    }

     @GetMapping("/getUserQs")
    public List<Question> getUserQs(@AuthenticationPrincipal User details) {
           
        List<Question> list = userService.getUserQs(details.getUsername());

        Collections.reverse(list);

        return list;
       
    }

    @GetMapping("/getAllComments")
    public List<Comment> getAllComments(@AuthenticationPrincipal User details,@RequestParam String qsListItemTimeMilli,@RequestParam String userPost) {
        
        if(userPost == ""){
            userPost = details.getUsername();
        }

        List<Comment> list = new ArrayList<>();
        List<Comment> list2 = new ArrayList<>();

    
        
       list = userService.getAllComments(details.getUsername());

        
        
        for(int i = 0 ; i < list.size() ; i++){
           
            if(list.get(i).getComment_time_milli().equals(qsListItemTimeMilli) && list.get(i).getComment_user_post().equals(userPost)){
                list2.add(list.get(i));
            }
        }

        Collections.reverse(list2);

        return list2;
       
    }


}
