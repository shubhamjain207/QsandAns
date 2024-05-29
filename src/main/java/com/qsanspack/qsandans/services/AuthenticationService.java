package com.qsanspack.qsandans.services;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qsanspack.qsandans.entities.Question;
import com.qsanspack.qsandans.entities.RegistrationDTO;
import com.qsanspack.qsandans.entities.Role;
import com.qsanspack.qsandans.entities.User;
import com.qsanspack.qsandans.repos.UserRepo;



@Service
public class AuthenticationService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    @Autowired
    private UserDetailsService service;


    
    public ResponseEntity<User> registerUser(String username, String password,String profilepicture,String fullname) {

        String encodedPass = encoder.encode(password);
      
        Set<Role> authorities = new HashSet<>();
        Set<String> questions = new HashSet<>();

        authorities.add(new Role("USER"));
        questions.add("");
        
        User user = userRepo.save(new User(0,username, encodedPass,profilepicture,fullname, authorities));
       

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "");

        return new ResponseEntity<>(user,headers, HttpStatus.OK);
        
    }

    
  

     public ResponseEntity<JwtResponse> login(String username, String password) {

                    manager.authenticate(
                        
                    new UsernamePasswordAuthenticationToken(username, password));

                    UserDetails userDetails = service.loadUserByUsername(username);


                    String token = this.helper.generateToken(userDetails);
                                      
                    JwtResponse response = JwtResponse.builder().JwtToken(token).username(userDetails.getUsername()).build();
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Authorization", token);
                
                    return new ResponseEntity<>(response,headers, HttpStatus.OK);


}

}
