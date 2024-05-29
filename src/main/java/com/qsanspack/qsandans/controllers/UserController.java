package com.qsanspack.qsandans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsanspack.qsandans.entities.RegistrationDTO;
import com.qsanspack.qsandans.services.JwtHelper;
import com.qsanspack.qsandans.services.JwtRequest;



@Controller
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    JwtHelper helper;



    @RequestMapping(value = "/register",method=RequestMethod.GET)
    public String register(@ModelAttribute(value="user") RegistrationDTO user){
        
        return "register";
    }

    @RequestMapping(value = "/login",method=RequestMethod.GET)
    public String login(@ModelAttribute(value="user") JwtRequest user){
       
        return "login";
    }

    @RequestMapping(value = "/home",method=RequestMethod.GET)
    public String home(@RequestParam String token,Model model){
        
            model.addAttribute("token", token);
       
            return "home";
    }

    @RequestMapping(value = "/profile",method=RequestMethod.GET)
    public String createProfilePage(@RequestParam String token,Model model){

            model.addAttribute("token", token);

            return "profile";
    }

  


}
 