package com.demosecureapi.demosecureapi.config.jwt;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Log
public class JwtProvider {

    @Value("$(jwt.secret)")
    private String jwtSecret;

    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex) {
            log.severe("SignatureException "+ ex.getMessage() );
        } catch (MalformedJwtException ex) {
            log.severe("MalformedJwtException "+ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.severe("invalid token " + ex.getMessage());
        } catch (UnsupportedJwtException ex) {

            log.severe("UnsupportedJwtException " +ex.getMessage() );
        } catch (IllegalArgumentException ex) {
            log.severe("IllegalArgumentException " + ex.getMessage() );
        }

        return false;
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
