// package com.qsanspack.qsandans.services;

// import java.io.IOException;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.qsanspack.qsandans.entities.User;
// import com.qsanspack.qsandans.repos.UserRepo;

// import ch.qos.logback.core.subst.Token;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;


// public class JwtFilter extends OncePerRequestFilter{

//     @Autowired
//     private TokenService service;

//     @Autowired
//     UserRepo repo;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
        
//          String authHeader = request.getHeader("Authorization");
//          String userName = null;
//          String token = null;

//          if(authHeader!=null && authHeader.startsWith("Bearer ")){
//                token = authHeader.substring(7);
//                userName =  service.getUsernameFromJwt(token);
            
//           }

//           if(userName!=null && SecurityContextHolder.getContext().getAuthentication() == null){

//             Optional<User> details = repo.findByUsername(userName);
            
//             System.out.println("Details ======  >" + details);


//           }



//     }
    




// }
