package com.aquilamazzei.springhunter.utils.security;

import com.aquilamazzei.springhunter.entities.Player;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JWTService {

    //@Value("${security.jwt.assign-key}")
    private String secret = "aaaa";

    public String generateToken(Player player){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("spring-hunter")
                    .withSubject(player.getUsername())
                    .withExpiresAt(generateExpirationTime())
                    .sign(algorithm);
        }catch (JWTCreationException e){
                throw new RuntimeException("JWT Creation Error", e);
        }
    }

    public String validateToken(String token){
         try {
             Algorithm algorithm = Algorithm.HMAC256(secret);
             return JWT.require(algorithm)
                     .withIssuer("spring-hunter")
                     .build()
                     .verify(token)
                     .getSubject();
         }catch (JWTVerificationException e){
             return "";
         }
    }

    private Instant generateExpirationTime(){
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }
}
