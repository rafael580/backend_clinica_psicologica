package com.example.psicologia.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class TokenUtil {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";
    private static final Long  EXPIRATION  = 60*60*1000L;
    private static final String SECRET_KEY = "11111111111111111111111111111111";
    private static final String EMISSOR = "DevNice";

    private static final String createToken(Usuario usuario){
        Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        String token = Jwts.builder()
                .setSubject(usuario.getNome())
                .setIssuer(EMISSOR)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        return PREFIX + token;
    }

    private static boolean isExpierationValid(Date expiration){
        return  expiration.after(new Date(System.currentTimeMillis()));
    }

    private static boolean isEmissorValid(String emissor){
        return emissor.equals(EMISSOR);
    }

    private static boolean isSubjectValid(String username){
       return username !=null && username.length()>0;
    }

    public static Authentication validate(HttpServletRequest request){

    String token = request.getHeader(HEADER);
    token = token.replace(PREFIX,"");

    Jws<Claims> jwsClains = Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY.getBytes())
            .build()
            .parseClaimsJws(token);

        String username = jwsClains.getBody().getSubject();
        String issuer   = jwsClains.getBody().getIssuer();
        Date   expire   = jwsClains.getBody().getExpiration();

        if (    isSubjectValid(username)
                && isEmissorValid(issuer)
                && isExpierationValid(expire)){
            return new UsernamePasswordAuthenticationFilter(username,null,Collections.emptyList());
        }
            return null;
    }
}
