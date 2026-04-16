/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsEMatricula;
import CapaInterface.clsIMatricula;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class clsNMatricula implements clsIMatricula{

    //INSTANCIA DE LA CONEXION
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarMatricula() {
        
        // SQL con JOIN para obtener nombres descriptivos
        String sql = "SELECT m.idmatricula, m.fecha, m.estado, "
                + "e.nombre AS nombre_empleado, "
                + "a.nombre AS nombre_alumno "
                + "FROM tbmatricula m "
                + "INNER JOIN tbempleado e ON m.dniemp = e.dni "
                + "INNER JOIN tbalumno a ON m.codalumno = a.codigo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar matriculas: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarMatricula(clsEMatricula objEM) {
        
        String sql = "INSERT INTO tbmatricula (idmatricula, fecha, estado, dniemp, codalumno) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEM.getIdmatricula());
            ps.setInt(2, objEM.getFecha());
            ps.setInt(3, objEM.getEstado());
            ps.setString(4, objEM.getDniemp());
            ps.setString(5, objEM.getCodalumno());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar matricula: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarMatricula(clsEMatricula objEM) {
        
        String sql = "UPDATE tbmatricula SET fecha=?, estado=?, dniemp=?, codalumno=? WHERE idmatricula=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEM.getFecha());
            ps.setInt(2, objEM.getEstado());
            ps.setString(3, objEM.getDniemp());
            ps.setString(4, objEM.getCodalumno());
            ps.setInt(5, objEM.getIdmatricula());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar matricula: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarMatricula(clsEMatricula objEM) {
        
        String sql = "DELETE FROM tbmatricula WHERE idmatricula=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEM.getIdmatricula());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar matricula: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarMatricula(clsEMatricula objEM) {
        
        String sql = "SELECT * FROM tbmatricula WHERE idmatricula=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEM.getIdmatricula());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar matricula: " + e.getMessage());
            return null;
        }
        
    }
    
}
