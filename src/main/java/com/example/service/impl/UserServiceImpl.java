/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service.impl;

import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alex
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.get(id);
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
    public boolean delete(int id) {
        userRepository.delete(id);
        return true;
    }
    
}
