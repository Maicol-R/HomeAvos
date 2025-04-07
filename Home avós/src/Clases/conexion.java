/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DeividAlexander
 */
public class conexion {
    
private Connection cnx;    
    
 public conexion(){ 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/home_avos", "root", "");   
        } catch (Exception e) {
            System.out.println("Error --> "+e.getMessage());
        }
   
}

    public Connection getCnx() {
        return cnx;
    }
 
 
}
