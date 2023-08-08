package com.aquilamazzei.springhunter.utils.security;

import com.aquilamazzei.springhunter.entities.Player;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Service
public class JWTService {

    @Value("${security.jwt.expiration}")
    private String expiration;

    @Value("${security.jwt.assign-key}")
    private String assignKey;

    public String generateToken(Player player){
        long expirationString = Long.valueOf(expiration);
        LocalDateTime dateTimeExpiration = LocalDateTime.now().plusMinutes(expirationString);
        Date date = Date.from(dateTimeExpiration.atZone(ZoneId.systemDefault()).toInstant());
        return Jwts
                .builder()
                .setSubject(player.getUsername())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, assignKey)
                .compact();
    }

    private Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(assignKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validToken(String token){
        try {
            Claims claims = getClaims(token);
            Date dateExpiration = claims.getExpiration();
            LocalDateTime localDateTime = dateExpiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return LocalDateTime.now().isAfter(localDateTime);
        }catch (Exception e){
            return false;
        }
    }

    public String getPlayerUsername(String token) throws ExpiredJwtException{
        return getClaims(token).getSubject();
    }
}
