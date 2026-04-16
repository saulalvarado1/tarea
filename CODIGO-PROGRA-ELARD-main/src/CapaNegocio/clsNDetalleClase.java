/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsEDetalleClase;
import CapaInterface.clsIDetalleClase;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNDetalleClase implements clsIDetalleClase{

    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarDetalleClase(clsEDetalleClase objEDC) {
        
        // SQL con JOIN para obtener el nombre del alumno vinculado a la clase
        String sql = "SELECT d.codalumno, a.nombre "
                + "FROM tbdetalleclase d "
                + "INNER JOIN tbalumno a ON d.codalumno = a.codigo "
                + "WHERE d.idclase = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEDC.getIdclase());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar detalle clase: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarDetalleClase(clsEDetalleClase objEDC) {
        
        String sql = "INSERT INTO tbdetalleclase (idclase, codalumno) VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEDC.getIdclase());
            ps.setString(2, objEDC.getCodalumno());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar alumno a la clase: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarDetalleClase(clsEDetalleClase objEDC) {
        
        String sql = "DELETE FROM tbdetalleclase WHERE idclase = ? AND codalumno = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEDC.getIdclase());
            ps.setString(2, objEDC.getCodalumno());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar alumno de la clase: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarAlumnoEnClase(clsEDetalleClase objEDC) {
        
        String sql = "SELECT * FROM tbdetalleclase WHERE idclase = ? AND codalumno = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEDC.getIdclase());
            ps.setString(2, objEDC.getCodalumno());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
}
