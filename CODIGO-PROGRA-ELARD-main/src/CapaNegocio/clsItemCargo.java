/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author david
 */
public class clsItemCargo {
    
    //ELEMENTOS NECESARIOS PARA EL COMBOBOX CARGO
    private int id;
    private String descripcion;

    //CONSTRUCTOR
    public clsItemCargo(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    //METODO PARA OBTENER EL ID
    public int getId() { return id; }

    //METODO PARA DEVOLVER EN TEXTO
    @Override
    public String toString() {
        return descripcion; // Esto es lo que se verá en el ComboBox
    }
    
}
