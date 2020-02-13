/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chhatrihall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rituparna Datta
 */
public class databaseconnector {
    public static Connection db() {
        Connection conn = null;
    
        try{
            
            //Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("jdbc:sqlite:G:\\Chhatrihall\\info.sqlite");
            System.out.println("Connected");
            
            return conn;
            
            
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 

        
    

        return null;
    
    }
}
