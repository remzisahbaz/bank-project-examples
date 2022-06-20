package com.example.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//token generate etmek için kullanacağımız class
public class JwtTokenProvider {

    @Value("${security.jwt.token.secret}")
    private String  APP_SECRET;
    @Value("${security.jwt.token.expiresIn}")
    private Long  EXPIRES_IN;

    public String generatedJwtToken(Authentication authentication){
        JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        Date expressDate= new Date(new Date().getTime()+ EXPIRES_IN);

        return Jwts.builder()
                .setSubject(Long.toString(jwtUserDetails.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expressDate)
                .signWith(SignatureAlgorithm.HS512,APP_SECRET)
                .compact();

    }

    Long getUserIdFromJwt(String token){

        Claims claims =Jwts
                        .parser()
                .setSigningKey(APP_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    boolean validationToken(String token){
        try{
            Jwts.parser().setSigningKey(APP_SECRET)
                    .parseClaimsJws(token);
            return ! isTokenExprired(token);
        }
        catch (SignatureException e){
            return false;
        }
        catch (MalformedJwtException e){
            return false;
        }
        catch (ExpiredJwtException e){
            return false;
        }
        catch (UnsupportedJwtException e){
            return false;
        }
        catch (IllegalArgumentException e){
            return false;
        }

    }

    private boolean isTokenExprired(String token) {
        Date expriration=Jwts.parser().setSigningKey(APP_SECRET)
                .parseClaimsJws(token).getBody().getExpiration();
        return expriration.before(new Date());
    }
}
