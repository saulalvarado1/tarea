/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsEEmpleado;
import CapaInterface.clsIEmpleado;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNEmpleado implements clsIEmpleado{

    //INSTANCIA DE LA CONEXION
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarEmpleado() {
        
        //SENTENCIA SQL PARA LISTAR INFORMACION DE LA TABLA
        String sql = "SELECT e.*, c.descripcion AS nombre_cargo FROM tbempleado e " +
                     "INNER JOIN tbcargo c ON e.idcargo = c.codigo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarEmpleado(clsEEmpleado objEE) {
        
        //SENTENCIA SQL PARA INSERTAR VALORES A LA TABLA
        String sql = "INSERT INTO tbempleado (dni, idcargo, nombre, direccion, telefono, email, usuario, clave, estado) " +
                     "VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR LOS VALORES A INSERTAR
            ps.setString(1, objEE.getDni());
            ps.setInt(2, objEE.getIdcargo()); // FK de la tabla cargo
            ps.setString(3, objEE.getNombre());
            ps.setString(4, objEE.getDireccion());
            ps.setString(5, objEE.getTelefono());
            ps.setString(6, objEE.getEmail());
            ps.setString(7, objEE.getUsuario());
            ps.setString(8, objEE.getClave());
            ps.setString(9, objEE.getEstado());
            
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarEmpleado(clsEEmpleado objEE) {
        
        //SENTENCIA SQL PARA ACTUALIZAR LA INFORMACION DE UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL DNI
        String sql = "UPDATE tbempleado SET idcargo=?, nombre=?, direccion=?, telefono=?, email=?, usuario=?, clave=?, estado=? " +
                     "WHERE dni=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEE.getIdcargo());
            ps.setString(2, objEE.getNombre());
            ps.setString(3, objEE.getDireccion());
            ps.setString(4, objEE.getTelefono());
            ps.setString(5, objEE.getEmail());
            ps.setString(6, objEE.getUsuario());
            ps.setString(7, objEE.getClave());
            ps.setString(8, objEE.getEstado());
            ps.setString(9, objEE.getDni());
            
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar empleado: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarEmpleado(clsEEmpleado objEE) {
        
        //SENTENCIA SQL PARA ELIMINAR UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL DNI
        String sql = "DELETE FROM tbempleado WHERE dni=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEE.getDni());
            
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarEmpleado(clsEEmpleado objEE) {
        
        //SENTENCIA SQL PARA LISTAR LA INFORMACION
        //SEGUN LA REFERENCIA AL VALOR CODIGO
        String sql = "SELECT * FROM tbempleado WHERE dni=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //PASAMOS LA REFERENCIA CON LA QUE BUSCAMOS LAS FILAS
            ps.setString(1, objEE.getDni());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar empleado: " + e.getMessage());
            return null;
        }
        
    }
    
}
