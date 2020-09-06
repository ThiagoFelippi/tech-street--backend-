package com.praticar.webflux.services.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ValidateToken {
    private final ExtractInfos extractInfos;

    private Boolean isTokenExpired(String token) {
        return extractInfos
                .extractExpiration(token)
                .before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractInfos.extractUsername(token);
        return (username.equals(
                userDetails.getUsername()) && !isTokenExpired(token)
        );
    }

}
