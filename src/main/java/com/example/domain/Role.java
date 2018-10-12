/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alex
 */

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    
    // Properties JPA anotated
    @Id
    @NotNull
    @Column(name = "roleID")    
    private int roleID;    
    
    @NotNull
    @Column(name = "roleDesc")
    @Size(max = 25)    
    private String roleDesc;  
    
    @NotNull
    @Column(name = "roleStr", unique = true)
    @Size(max = 50)    
    private String roleStr;
    
    // Constructors
    public Role(int roleID, String roleDesc, String roleStr){
        this.roleID = roleID;
        this.roleDesc = roleDesc;
        this.roleStr = roleStr;
    }
    
    public Role(){}
    
    // Setters and Getters

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleStr() {
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }
}
