package com.nisum.test.security.auth;

import com.nisum.test.security.domain.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class AuthenticationService {

    private final static String ACCESS_TOKEN_SECRET="aKu*kjHQ%j2NDEPgDkogmdJ7UqPFJZbMm7$SF&A985CQ";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS=2_592_000L;

    public  String createToken(User user) {
          long expirationTime =  ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
          Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> claves = new HashMap<>();
        claves.put("email", user.getEmail());
        claves.put("name", user.getName());

        return Jwts.builder()
                .subject(user.getEmail())
                .expiration(expirationDate)
                .claims(claves)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();

    }



}
