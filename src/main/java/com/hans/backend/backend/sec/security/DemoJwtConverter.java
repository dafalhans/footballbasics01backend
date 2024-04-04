package com.hans.backend.backend.sec.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoJwtConverter implements Converter<Jwt, DemoJwt> {
    @Override
    public DemoJwt convert(Jwt source) {
        List<GrantedAuthority> authorities = createAuthorities(source);
        DemoJwt demoJwt = new DemoJwt(source, authorities);
        demoJwt.setUsername(source.getClaimAsString("preferred_username"));
        demoJwt.setClientId(source.getClaimAsString("azp"));

        System.out.println("debug van DemoJwtConverter");

        return demoJwt;
    }

    private List<GrantedAuthority> createAuthorities(Jwt source) {
        List<GrantedAuthority> result = new ArrayList<>();
        Map<String, Object> realm_access = source.getClaimAsMap("realm_access");
        if(realm_access != null && realm_access.containsKey("roles")){
            List roleList = (List)realm_access.get("roles");
            roleList.forEach(role -> result.add(new SimpleGrantedAuthority("ROLE_"+role)));
        }
        System.out.println(result);
        return result;
    }
}
