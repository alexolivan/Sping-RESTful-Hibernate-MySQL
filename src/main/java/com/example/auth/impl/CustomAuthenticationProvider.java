/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.auth.impl;

import com.example.domain.User;
import com.example.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author alex
 */
@Component("authenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Authentication authenticate(Authentication authentication) 
            throws AuthenticationException {
        
        String name = authentication.getName();
        System.out.println("received name was: " + name);
        
        Object credentials = authentication.getCredentials();
        
        System.out.println("credentials class: " + credentials.getClass());
        
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();
        System.out.println("received password was: " + password);       
        
        List<User> users = userRepository.getAll();
        
        Optional<User> userOptional = Optional.empty();
        for (User u : users){
            if (u.getUsername().equals(name) && u.getPassword().equals(password)){
                userOptional = Optional.of(u);
                break;
            }
        }        
        
        if (!userOptional.isPresent()) {
            throw new BadCredentialsException("Authentication failed for " + name);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        System.out.println("Fetched role is: " + userOptional.get().getUserRole().getRoleStr());
        grantedAuthorities.add(new SimpleGrantedAuthority(userOptional.get().getUserRole().getRoleStr()));
        Authentication auth = new
                UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
    
}
