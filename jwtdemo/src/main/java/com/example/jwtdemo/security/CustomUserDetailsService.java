package com.example.jwtdemo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username("admin")
                .password("admin123")
                .roles("USER")
                .build();

    }
}
