/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DeividAlexander
 */
public class Conexion{

    private Connection conexion;
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           //Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/home_avos", "root", "");
        } catch (Exception e) {
            System.out.println("Error de conexion == " + e.getMessage());
        }
    }
    public void desconectar() {
        conexion = null;
    }
    public Connection getConexion() {
        return conexion;
    }
    public void setCnn(Connection conexion){
    this.conexion=conexion;
    }

}
