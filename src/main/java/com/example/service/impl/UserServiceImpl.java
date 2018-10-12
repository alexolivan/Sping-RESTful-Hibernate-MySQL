/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service.impl;

import com.example.auth.IAuthenticationFacade;
import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 *
 * @author alex
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private IAuthenticationFacade authenticationFacade;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        // An example of geting the authenticated user to use it at service level.
        // This way we could further apply fine-grained constraints
        Authentication authentication = authenticationFacade.getAuthentication();
        System.out.println("INFO AT SERVICE LAYER, auth user was: " + authentication.getName());
        
        return userRepository.getAll();
    }

    @Override
    public User getUserById(int userID) {
        return userRepository.getUserById(userID);
    }
    
    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }    

    @Override
    public boolean add(User user) {
        userRepository.add(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        userRepository.update(user);
        return true;
    }

    @Override
    public boolean delete(int userID) {
        userRepository.delete(userID);
        return true;
    }
    
}
