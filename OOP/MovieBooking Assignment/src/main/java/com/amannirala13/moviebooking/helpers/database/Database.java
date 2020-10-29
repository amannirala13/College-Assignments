/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amannirala13.moviebooking.helpers.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author amann
 */
public class Database {
    
    public static Connection connection = null;
    public static Statement statement = null;
    
    /**
     *
     * @param url
     * @param user
     * @param password
     */
    public static void createConnection(String url, String user, String password){
        try{
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            System.out.println("Connection was successful!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public static ResultSet getResult(String query)throws SQLException{
        return statement.executeQuery(query);
    }
    
    /**
     *
     * @param query
     * @throws SQLException
     */
    public static void updateDB(String query) throws SQLException{
        statement.executeUpdate(query);
    }
    
}
