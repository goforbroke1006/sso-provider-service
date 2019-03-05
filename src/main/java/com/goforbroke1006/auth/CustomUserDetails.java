package com.goforbroke1006.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    public CustomUserDetails(
            String username,
            Collection<? extends GrantedAuthority> authorities
    ) {
        super(
                username, "", true,
                true, true, true,
                authorities
        );
    }

}
