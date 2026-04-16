/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEMatricula;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public interface clsIMatricula {
   
    public ResultSet mtdListarMatricula();
    public boolean mtdAgregarMatricula(clsEMatricula objEM);
    public boolean mtdModificarMatricula(clsEMatricula objEM);
    public boolean mtdEliminarMatricula(clsEMatricula objEM);
    public ResultSet mtdBuscarMatricula(clsEMatricula objEM);
    
}
