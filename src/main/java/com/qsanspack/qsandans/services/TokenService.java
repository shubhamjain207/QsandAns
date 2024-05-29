// package com.qsanspack.qsandans.services;

// import java.time.Instant;
// import java.util.Date;
// import java.util.Map;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.ssl.SslBundleProperties.Key;
// import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
// import org.springframework.security.oauth2.jwt.JwtClaimsSet;
// import org.springframework.security.oauth2.jwt.JwtDecoder;
// import org.springframework.security.oauth2.jwt.JwtEncoder;
// import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

// // import java.time.Instant;
// // import java.util.stream.Collectors;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.core.Authentication;
// // import org.springframework.security.core.GrantedAuthority;
// // import org.springframework.security.oauth2.jwt.JwtClaimsSet;
// // import org.springframework.security.oauth2.jwt.JwtDecoder;
// // import org.springframework.security.oauth2.jwt.JwtEncoder;
// // import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
// import org.springframework.stereotype.Service;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;

// @Service
// public class TokenService {

//     @Autowired
//     private JwtEncoder jwtEncoder;

//     @Autowired
//     private JwtDecoder jwtDecoder;

//     public String generateJwt(Authentication auth){



//         Instant now  = Instant.now();
       
//         String scope = auth.getAuthorities().stream()
//                          .map(GrantedAuthority::getAuthority)
//                         .collect(Collectors.joining(" "));



                        
//         JwtClaimsSet claims = JwtClaimsSet.builder()
//          .issuer("self")
//          .issuedAt(now)
//          .subject(auth.getName())
//          .claim("roles", scope)
//          .build();



//          return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        
//     }

//     public String getUsernameFromJwt(String token){
//         Claims claims = Jwts.parser()
//                         .parseClaimsJws(token)
//                         .getBody();

//                 return claims.getSubject();
//     }

//     public boolean validataToken(String token){
//             try{
//                 Jwts.parser().parseClaimsJws(token);
//                 return true;
//             }catch(Exception e){
//                 throw new AuthenticationCredentialsNotFoundException("Not Found");
//             }
//     }

 


// }
