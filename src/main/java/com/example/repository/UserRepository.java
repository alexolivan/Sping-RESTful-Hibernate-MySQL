/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.domain.User;
import java.util.List;

/**
 *
 * @author alex
 */
public interface UserRepository {
    List<User> getAll();     
    User getUserById(int userID);
    User getUserByUsername(String username);
    void add(User user);
    void update(User user);
    void delete(int id);
}