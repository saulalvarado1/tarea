/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsECurso;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsICurso {
    
    public ResultSet mtdListarCurso();
    public boolean mtdAgregarCurso(clsECurso objEC);
    public boolean mtdModificarCurso(clsECurso objEC);
    public boolean mtdEliminarCurso(clsECurso objEC);
    public ResultSet mtdBuscarCurso(clsECurso objEC);
    
}
