/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alex
 */
@RestController
public class UsersController {
    
    @Autowired
    private UserService userService;
    
    public UsersController () {}
    
    public UsersController(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public @ResponseBody
    List<User> getAll() {
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public @ResponseBody
    User getById(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<User> create(@RequestBody User user) {
        this.userService.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        this.userService.update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<User> delete(@PathVariable int id) {
        this.userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
