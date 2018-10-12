/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User implements Serializable{
    
    // Properties JPA anotated
    @Id
    @NotNull
    @Column(name = "userID")    
    private int userID;
    
    @NotNull
    @Column(name = "username", unique = true)
    @Size(max = 100)
    private String username;  
    
    @NotNull
    @Column(name = "password")
    @Size(max = 50)    
    private String password;     
    
    @NotNull
    @Column(name = "fullname")
    @Size(max = 100)    
    private String fullname;    
    
    
    @ManyToOne
    @JoinColumn(name = "roleID")
    private Role userRole;
    
    // Constructors
    
    public User(int userID, String username, String password, String fullname, Role userRole){
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userRole = userRole;
    }
    
    public User(int userID, String username, String password, Role userRole) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public User() {}
    
    // Setters and Getters
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setRoleID(Role userRole) {
        this.userRole = userRole;
    }
    
    
    // Overrides
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.userID);
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.password);        
        hash = 59 * hash + Objects.hashCode(this.fullname);        
        hash = 59 * hash + Objects.hashCode(this.userRole);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        } else {
        }
        return true;
    }       
    
}