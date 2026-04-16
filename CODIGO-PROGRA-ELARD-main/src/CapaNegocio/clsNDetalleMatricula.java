/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsEDetalleMatricula;
import CapaInterface.clsIDetalleMatricula;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNDetalleMatricula implements clsIDetalleMatricula{

    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarDetalle(clsEDetalleMatricula objEDM) {
        
        String sql = "SELECT d.codcurso, c.nombre, c.creditos "
                + "FROM tbdetallematricula d "
                + "INNER JOIN tbcurso c ON d.codcurso = c.codigo "
                + "WHERE d.idmatricula = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEDM.getIdmatricula());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarDetalle(clsEDetalleMatricula objEDM) {
        
        String sql = "INSERT INTO tbdetallematricula (idmatricula, codcurso) VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEDM.getIdmatricula());
            ps.setString(2, objEDM.getCodcurso());
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarDetalle(clsEDetalleMatricula objEDM) {
        
        String sql = "DELETE FROM tbdetallematricula WHERE idmatricula = ? AND codcurso = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEDM.getIdmatricula());
            ps.setString(2, objEDM.getCodcurso());
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            return false;
        }
        
    }
    
}
