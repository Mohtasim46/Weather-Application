package com.mohtasimtest.thinkificweather.security;

import com.mohtasimtest.thinkificweather.models.Customer;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.mohtasimtest.thinkificweather.contracts.SecurityContracts.EXPIRATION_TIME;
import static com.mohtasimtest.thinkificweather.contracts.SecurityContracts.SECRET_KEY;

@Component
public class JwtTokenProvider {

    // generate the token
    public String generateJwtToken(Authentication authentication) {
        Customer customer = (Customer) authentication.getPrincipal();
        Date currentDate = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(currentDate.getTime() + EXPIRATION_TIME);

        String customerId = Long.toString(customer.getId());

        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("id", Long.toString(customer.getId()));
        claimsMap.put("username", customer.getUsername());
        claimsMap.put("fullName", customer.getFullName());

        return Jwts.builder()
                .setSubject(customerId)
                .setClaims(claimsMap)
                .setIssuedAt(currentDate)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    // validate the token
    public boolean isValidToken(String token) {
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        }catch(SignatureException ex) {
            System.out.println("Invalid JWT Signature");
        }catch(MalformedJwtException ex) {
            System.out.println("Invalid Jwt Token.");
        }catch (ExpiredJwtException ex) {
            System.out.println("Expired Jwt Token.");
        }catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported jwt token.");
        }catch (IllegalArgumentException ex) {
            System.out.println("Jwt claims string is empty.");
        }
        return false;
    }

    // get user id from the token
    public Long getCustomerIdFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getBody();

        String id = (String) claims.get("id");

        return Long.parseLong(id);
    }
}
