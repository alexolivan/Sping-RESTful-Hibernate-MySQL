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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "users")
public class User implements Serializable{
    
    // Properties JPA anotated
    
    @Id
    @NotNull
    @Column(name = "id")    
    private int id;
    
    @NotNull
    @Column(name = "username")
    @Size(max = 100)    
    private String username;    
    
    @NotNull
    @Column(name = "fullname")
    @Size(max = 100)    
    private String fullname;    
    
    @NotNull
    @Column(name = "isSuper") 
    private boolean isSuper;    
    
    @NotNull
    @Column(name = "isAdmin") 
    private boolean isAdmin;     
    
    
    // Constructors
    
    public User(int id, String username, String fullname, Boolean isSuper, Boolean isAdmin){
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.isSuper = isSuper;
        this.isAdmin = isAdmin;
    }
    
    public User(int id, String username) {
        this.id = id;
        this.username = username;        
    }

    public User() {}
    
    // Setters and Getters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isIsSuper() {
        return isSuper;
    }

    public void setIsSuper(boolean isSuper) {
        this.isSuper = isSuper;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
    // Overrides
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.fullname);        
        hash = 59 * hash + Objects.hashCode(this.isSuper);
        hash = 59 * hash + Objects.hashCode(this.isAdmin);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        } else {
        }
        return true;
    }    
    
    
    
}
