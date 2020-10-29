/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amannirala13.moviebooking.models;

/**
 *
 * @author amann
 */
public final class User {
    
    public final static String ID = "user_id";
    public final static String USERNAME = "username";
    public final static String PASSWORD = "password";
    public final static String ADMIN = "admin";
    
    public int id;
    public String username;
    public String password;
    public Boolean isAdmin;
   
    /**
     *
     * @param id
     * @param username
     * @param password
     * @param isAdmin
     */
    public User(int id, String username, String password, Boolean isAdmin){
        this.id = id;
        this.password = password;
        this.isAdmin = isAdmin;
        this.username = username;
    }
}
