/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsECurso;
import CapaInterface.clsICurso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNCurso implements clsICurso{

    //INSTANCIA DE LA CONEXION
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarCurso() {
        
        //SENTENCIA SQL PARA LISTAR INFORMACION DE LA TABLA
        String sql = "SELECT * FROM tbcurso";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarCurso(clsECurso objEC) {
        
        //SENTENCIA SQL PARA INSERTAR VALORES A LA TABLA
        String sql = "INSERT INTO tbcurso (codigo, nombre, creditos, prerequisito) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR LOS VALORES A INSERTAR
            ps.setString(1, objEC.getCodigo());
            ps.setString(2, objEC.getNombre());
            ps.setInt(3, objEC.getCreditos());
            ps.setString(4, objEC.getPrerequisito());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar curso: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarCurso(clsECurso objEC) {
        
        //SENTENCIA SQL PARA ACTUALIZAR LA INFORMACION DE UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL CODIGO
        String sql = "UPDATE tbcurso SET nombre=?, creditos=?, prerequisito=? WHERE codigo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR VALORES A MODIFICAR
            ps.setString(1, objEC.getNombre());
            ps.setInt(2, objEC.getCreditos());
            ps.setString(3, objEC.getPrerequisito());
            
            //ESTE ES EL VALOR DE REFERENCIA
            ps.setString(4, objEC.getCodigo());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar curso: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarCurso(clsECurso objEC) {
        
        //SENTENCIA SQL PARA ELIMINAR UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL CODIGO
        String sql = "DELETE FROM tbcurso WHERE codigo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getCodigo());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar curso: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarCurso(clsECurso objEC) {
        
        //SENTENCIA SQL PARA LISTAR LA INFORMACION
        //SEGUN LA REFERENCIA AL VALOR CODIGO
        String sql = "SELECT * FROM tbcurso WHERE codigo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //PASAMOS LA REFERENCIA CON LA QUE BUSCAMOS LAS FILAS
            ps.setString(1, objEC.getCodigo());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar curso: " + e.getMessage());
            return null;
        }
        
    }
    
}
