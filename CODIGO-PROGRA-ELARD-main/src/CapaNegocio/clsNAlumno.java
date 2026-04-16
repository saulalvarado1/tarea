/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsEAlumno;
import CapaInterface.clsIAlumno;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author david
 */
public class clsNAlumno implements clsIAlumno{

    //INSTANCIA DE LA CONEXION
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarAlumno() {
        
        //SENTENCIA SQL PARA LISTAR INFORMACION DE LA TABLA
        String sql = "SELECT * FROM tbalumno";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
        
    }
    
    private boolean validarCamposAlumno(clsEAlumno objEA){
        // Arreglo con los campos a validar
        String[] campos = {
            objEA.getCodigo(),
            objEA.getNombre(),
            objEA.getDireccion(),
            objEA.getTelefono(),
            objEA.getEmail()
        };
    
        // Validar que ningún campo esté vacío
        for (int i = 0; i < campos.length; i++) {
            if (campos[i] == null || campos[i].trim().isEmpty()) {
                String[] nombreCampos = {"Código", "Nombre", "Dirección", "Teléfono", "Email"};
                System.out.println(" El campo " + nombreCampos[i] + " es obligatorio");
                return false;
            }
        }

        // Validaciones específicas
        if (!objEA.getCodigo().matches("^[0-9]+$")) {
            System.out.println(" El código debe contener solo números");
            return false;
        }

        if (objEA.getCodigo().length() > 15) {
            System.out.println(" El código no puede superar los 15 caracteres");
            return false;
        }

        if (!objEA.getEmail().contains("@")) {
            System.out.println(" El email debe contener @");
            return false;
        }

        return true;
    }
            
    @Override
    public boolean mtdAgregarAlumno(clsEAlumno objEA) {
        
        if (!validarCamposAlumno(objEA)) {
            return false;
        }
        
        //SENTENCIA SQL PARA INSERTAR VALORES A LA TABLA
        String sql = "INSERT INTO tbalumno (codigo, nombre, direccion, telefono, email) VALUES (?,?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR LOS VALORES A INSERTAR
            ps.setString(1, objEA.getCodigo());
            ps.setString(2, objEA.getNombre());
            ps.setString(3, objEA.getDireccion());
            ps.setString(4, objEA.getTelefono());
            ps.setString(5, objEA.getEmail());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarAlumno(clsEAlumno objEA) {
        
        if (!validarCamposAlumno(objEA)) {
            return false;
        }
        
        //SENTENCIA SQL PARA ACTUALIZAR LA INFORMACION DE UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL CODIGO
        String sql = "UPDATE tbalumno SET nombre=?, direccion=?, telefono=?, email=? WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR VALORES A MODIFICAR
            ps.setString(1, objEA.getNombre());
            ps.setString(2, objEA.getDireccion());
            ps.setString(3, objEA.getTelefono());
            ps.setString(4, objEA.getEmail());
            
            //ESTE ES EL VALOR DE REFERENCIA
            ps.setString(5, objEA.getCodigo());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarAlumno(clsEAlumno objEA) {
        
        //SENTENCIA SQL PARA ELIMINAR UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL CODIGO
        String sql = "DELETE FROM tbalumno WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEA.getCodigo());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarAlumno(clsEAlumno objEA) {
        
        //SENTENCIA SQL PARA LISTAR LA INFORMACION
        //SEGUN LA REFERENCIA AL VALOR CODIGO
        String sql = "SELECT * FROM tbalumno WHERE codigo = ?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            //PASAMOS LA REFERENCIA CON LA QUE BUSCAMOS LAS FILAS
            ps.setString(1, objEA.getCodigo());

            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar por código: " + e.getMessage());
            return null;
        }
        
    }
    @Override
    public boolean mtdCargaMasiva(String rutaArchivo) {
        String sql = "INSERT INTO tbalumno (codigo, nombre, direccion, telefono, email) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conLote = cn.getConnection();
             PreparedStatement psLote = conLote.prepareStatement(sql);
             BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            
            conLote.setAutoCommit(false); 
            String linea;
            boolean esPrimeraLinea = true;

            while ((linea = br.readLine()) != null) {
                // Saltamos el encabezado del Excel
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue; 
                }

                // Separamos por coma (si tu CSV usa punto y coma, cambia "," por ";")
                String[] datos = linea.split(";"); 

                if (datos.length >= 5) {
                    psLote.setString(1, datos[0].trim());
                    psLote.setString(2, datos[1].trim());
                    psLote.setString(3, datos[2].trim());
                    psLote.setString(4, datos[3].trim());
                    psLote.setString(5, datos[4].trim());
                    psLote.addBatch(); 
                }
            }
            
            psLote.executeBatch(); 
            conLote.commit(); 
            return true;

        } catch (Exception e) {
            System.out.println("Error en carga masiva: " + e.getMessage());
            return false;
        }
    }
    
}
