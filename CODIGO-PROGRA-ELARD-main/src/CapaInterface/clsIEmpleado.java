/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEEmpleado;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsIEmpleado {

    public ResultSet mtdListarEmpleado();
    public boolean mtdAgregarEmpleado(clsEEmpleado objEE);
    public boolean mtdModificarEmpleado(clsEEmpleado objEE);
    public boolean mtdEliminarEmpleado(clsEEmpleado objEE);
    public ResultSet mtdBuscarEmpleado(clsEEmpleado objEE);
    
}
