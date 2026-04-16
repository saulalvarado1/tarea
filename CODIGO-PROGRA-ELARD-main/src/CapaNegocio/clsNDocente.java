/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsEDocente;
import CapaInterface.clsIDocente;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNDocente implements clsIDocente{

    //INSTANCIA DE LA CONEXION
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarDocente() {
        
        //SENTENCIA SQL PARA LISTAR INFORMACION DE LA TABLA
        String sql = "SELECT * FROM tbdocente";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar docentes: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarDocente(clsEDocente objED) {
            
        if (!validarCamposDocente(objED)) {
            return false;
        }
        
        //SENTENCIA SQL PARA INSERTAR VALORES A LA TABLA
        String sql = "INSERT INTO tbdocente (codigo, nombre) VALUES (?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR LOS VALORES A INSERTAR
            ps.setString(1, objED.getCodigo());
            ps.setString(2, objED.getNombre());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar docente: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarDocente(clsEDocente objED) {
        
        //SENTENCIA SQL PARA ACTUALIZAR LA INFORMACION DE UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL CODIGO
        String sql = "UPDATE tbdocente SET nombre=? WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objED.getNombre());
            ps.setString(2, objED.getCodigo());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar docente: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarDocente(clsEDocente objED) {
        
        //SENTENCIA SQL PARA ELIMINAR UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL CODIGO
        String sql = "DELETE FROM tbdocente WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objED.getCodigo());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar docente: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarDocente(clsEDocente objED) {
        
        //SENTENCIA SQL PARA LISTAR LA INFORMACION
        //SEGUN LA REFERENCIA AL VALOR CODIGO
        String sql = "SELECT * FROM tbdocente WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //PASAMOS LA REFERENCIA CON LA QUE BUSCAMOS LAS FILAS
            ps.setString(1, objED.getCodigo());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar docente: " + e.getMessage());
            return null;
        }
        
    }
    
    private boolean validarCamposDocente(clsEDocente objED){
        String[] campos = {
            objED.getCodigo(),
            objED.getNombre()
        };
                // Validar que ningún campo esté vacío
            for (int i = 0; i < campos.length; i++) {
                if (campos[i] == null || campos[i].trim().isEmpty()) {
                    String[] nombreCampos = {"Código", "Nombre"};
                    System.out.println("❌ El campo " + nombreCampos[i] + " es obligatorio");
                    return false;
            }
        }
            if (!objED.getCodigo().matches("^[0-9]+$")) {
                System.out.println("El código debe contener solo números");
                return false;
            }

            if (objED.getCodigo().length() > 6) {
                System.out.println("El código no puede superar los 6");
                return false;
            }
            
            if (objED.getNombre().length() > 50) {
                System.out.println("El código no puede superar los 50");
                return false;
            }
            
        return true;    
    }
    
}
