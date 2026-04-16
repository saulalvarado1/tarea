/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsECargo;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsICargo {
    
    public ResultSet mtdListarCargo();
    public boolean mtdAgregarCargo(clsECargo objEC);
    public boolean mtdModificarCargo(clsECargo objEC);
    public boolean mtdEliminarCargo(clsECargo objEC);
    public ResultSet mtdBuscarCargo(clsECargo objEC);
    
}
