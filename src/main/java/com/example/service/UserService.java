/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.domain.User;
import java.util.List;

/**
 *
 * @author alex
 */
public interface UserService {
    
    List<User> getAllUsers();    
    User getUserById(int id);
    boolean add(User user);
    boolean update(User user);
    boolean delete(int id);
}
