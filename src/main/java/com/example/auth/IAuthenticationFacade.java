/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.auth;

import org.springframework.security.core.Authentication;

/**
 *
 * @author alex
 */
public interface IAuthenticationFacade {
    Authentication getAuthentication();    
}
