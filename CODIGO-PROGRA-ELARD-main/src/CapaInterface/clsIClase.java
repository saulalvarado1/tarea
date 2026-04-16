/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEClase;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsIClase {
    
    public ResultSet mtdListarClase();
    public boolean mtdAgregarClase(clsEClase objEC);
    public boolean mtdModificarClase(clsEClase objEC);
    public boolean mtdEliminarClase(clsEClase objEC);
    public ResultSet mtdBuscarClase(clsEClase objEC);
    
}
