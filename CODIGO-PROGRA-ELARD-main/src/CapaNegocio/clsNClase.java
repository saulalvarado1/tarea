/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsEClase;
import CapaInterface.clsIClase;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNClase implements clsIClase{

    //INSTANCIA DE LA CONEXION
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarClase() {
        
        //SENTENCIA SQL PARA LISTAR INFORMACION DE LA TABLA
        //SQL CON JOIN PARA TRAER DNI, COD_CURSO, COD_DOCENTE
        String sql = "SELECT cl.idclase, "
                + "e.nombre AS empleado, "
                + "cu.nombre AS curso, "
                + "d.nombre AS docente "
                + "FROM tbclase cl "
                + "INNER JOIN tbempleado e ON cl.dniemp = e.dni "
                + "INNER JOIN tbcurso cu ON cl.codcurso = cu.codigo "
                + "INNER JOIN tbdocente d ON cl.coddoc = d.codigo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar clases: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarClase(clsEClase objEC) {
        
        //SENTENCIA SQL PARA INSERTAR VALORES A LA TABLA
        String sql = "INSERT INTO tbclase (idclase, dniemp, codcurso, coddoc) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR LOS VALORES A INSERTAR
            ps.setString(1, objEC.getIdclase());
            ps.setString(2, objEC.getDniemp());
            ps.setString(3, objEC.getCodcurso());
            ps.setString(4, objEC.getCoddoc());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar clase: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarClase(clsEClase objEC) {
        
        //SENTENCIA SQL PARA ACTUALIZAR LA INFORMACION DE UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL IDCLASE
        String sql = "UPDATE tbclase SET dniemp=?, codcurso=?, coddoc=? WHERE idclase=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getDniemp());
            ps.setString(2, objEC.getCodcurso());
            ps.setString(3, objEC.getCoddoc());
            ps.setString(4, objEC.getIdclase());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar clase: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarClase(clsEClase objEC) {
        
        //SENTENCIA SQL PARA ELIMINAR UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL IDCLASE
        String sql = "DELETE FROM tbclase WHERE idclase=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getIdclase());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar clase: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarClase(clsEClase objEC) {
        
        //SENTENCIA SQL PARA LISTAR LA INFORMACION
        //SEGUN LA REFERENCIA AL VALOR IDCLASE
        String sql = "SELECT * FROM tbclase WHERE idclase=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getIdclase());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar clase: " + e.getMessage());
            return null;
        }
        
    }
    
}
