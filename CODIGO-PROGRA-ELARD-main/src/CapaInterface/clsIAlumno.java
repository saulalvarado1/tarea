/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEAlumno;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsIAlumno {
    
    public ResultSet mtdListarAlumno();
    public boolean mtdAgregarAlumno(clsEAlumno objEA);
    public boolean mtdModificarAlumno(clsEAlumno objEA);
    public boolean mtdEliminarAlumno(clsEAlumno objEA);
    public ResultSet mtdBuscarAlumno(clsEAlumno objEA);
    public boolean mtdCargaMasiva(String rutaArchivo);
}
