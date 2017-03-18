package com.softgroup.token.impl;

import com.sofrgroup.token.api.TokenGeneratorService;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 17.03.2017.
 */

@Service
public class TokenService implements TokenGeneratorService {
    //key for long term token
    private String keyLT = "kHv4PXv0OiM4V9U0mgwXD58Mq8ooVZJ9";
    //key for short term token
    private String keyST = "AMVvu8OMlipxmr8l73Eo9NXlA5AVNJr1";
    //Long term token lifetime in month
    private int lifetimeTokenLT = 12;
    //Short term token lifetime in minute
    private int lifetimeTokenST = 10;

    public String createLTToken(String deviceId, String userId) {
        if (deviceId == null || userId == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, lifetimeTokenLT);
        JwtBuilder jwtBuilder = Jwts.builder();
        Claims tokenData = Jwts.claims()
                .setExpiration(calendar.getTime())
                .setIssuedAt(new Date());
        tokenData.put("tokenType", "longTerm");
        tokenData.put("userID", userId);
        tokenData.put("deviceID", deviceId);
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, keyLT).compact();
    }

    public String createSTToken(String token) {
        //validate token
        if (token == null||!validateLTToken(token))
            return null;
        //Parse token
        Jws<Claims> jws = Jwts.parser().setSigningKey(keyLT).parseClaimsJws(token);

        //token can be generated only from long term token
        if(jws.getBody().get("tokenType").equals("shortTerm")){
            return null;
        }

        //get body and replace date with new value
        Claims body = jws.getBody();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, lifetimeTokenST);
        body.replace("tokenType", "shortTerm");
        body.setIssuedAt(new Date());
        body.setExpiration(calendar.getTime());

        //generate new token
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(body);

        return jwtBuilder.signWith(SignatureAlgorithm.HS512, keyST).compact();
    }


    public boolean validateSTToken(String token) {
        //Parse and validate token
        Jws<Claims> jws = validateTokenSignature(token,keyST);

        if(jws==null){
            return false;
        }

        //Validate expiration date
        if(jws.getBody().getExpiration().before(new Date())){
            return false;
        }

        //parse type of token
        return jws.getBody().get("tokenType").equals("shortTerm");
    }



    public boolean validateLTToken(String token) {
        //Parse and validate token
        Jws<Claims> jws = validateTokenSignature(token,keyLT);

        if(jws==null){
            return false;
        }

        //Validate expiration date
        if(jws.getBody().getExpiration().before(new Date())){
            return false;
        }

        //parse type of token
        return jws.getBody().get("tokenType").equals("longTerm");
    }


    //method check signature of the token according to key and return token body
    public Jws<Claims> validateTokenSignature(String token, String key){
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token);

        } catch (SignatureException e) {
            return null;
        }
    }
}
