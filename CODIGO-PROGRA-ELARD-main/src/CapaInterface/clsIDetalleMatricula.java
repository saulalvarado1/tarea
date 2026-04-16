/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEDetalleMatricula;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public interface clsIDetalleMatricula {
    
    public ResultSet mtdListarDetalle(clsEDetalleMatricula objEDM);
    public boolean mtdAgregarDetalle(clsEDetalleMatricula objEDM);
    public boolean mtdEliminarDetalle(clsEDetalleMatricula objEDM);
    
}
