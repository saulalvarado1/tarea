/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEDocente;
import java.sql.ResultSet;
/**
 *
 * @author david
 */
public interface clsIDocente {
    
    public ResultSet mtdListarDocente();
    public boolean mtdAgregarDocente(clsEDocente objED);
    public boolean mtdModificarDocente(clsEDocente objED);
    public boolean mtdEliminarDocente(clsEDocente objED);
    public ResultSet mtdBuscarDocente(clsEDocente objED);
    
}
