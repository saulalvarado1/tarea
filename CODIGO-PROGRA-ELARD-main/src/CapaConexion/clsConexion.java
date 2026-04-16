/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsConexion {
    
//Declaramos una variable de la clase Connection
    Connection con = null;
    
    //Declaramos la cadena de conexion
    String sURL = "jdbc:mysql://localhost:3306/dbupt";

    public clsConexion(){
        
        try {
            
            //Pasamos el Driver de MySql que debe cargar
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Obtenemos la conexion usando DriverManager
            //Ingresamos las credenciales para poder conectarnos a la base de datos
            con = DriverManager.getConnection(sURL,"root","");
            
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println(e);
            
        }
        
    }
    
    //Clase que obtiene la conexion
    public Connection getConnection(){
        return con;
    }
}
