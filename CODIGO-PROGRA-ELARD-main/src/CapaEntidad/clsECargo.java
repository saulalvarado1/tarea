/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidad;

/**
 *
 * @author david
 */
public class clsECargo {
    
    //DEFINIR LOS ATRIBUTOS DE LA TABLA tbcargo
    private int codigo;
    private String descripcion;
    
    //CONSTRUCTOR
    public clsECargo() {
    }

    //GETTERS AND SETTERS
    public int getCodigo() {
        return codigo;
    }
    
    //GETTERS AND SETTERS
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
