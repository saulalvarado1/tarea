/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEDetalleClase;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsIDetalleClase {
    
    public ResultSet mtdListarDetalleClase(clsEDetalleClase objEDC);
    public boolean mtdAgregarDetalleClase(clsEDetalleClase objEDC);
    public boolean mtdEliminarDetalleClase(clsEDetalleClase objEDC);
    public ResultSet mtdBuscarAlumnoEnClase(clsEDetalleClase objEDC);
    
}
