package com.hans.backend.backend.sec.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

/*
Class to implement in order to extract data from JWT token
 */
@Getter
@Setter
public class DemoJwt extends JwtAuthenticationToken {

    private String username;
    private String clientId;

    public DemoJwt(Jwt jwt, Collection<? extends GrantedAuthority> authorities) {
        super(jwt, authorities);
    }
}
