/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author david
 */
public class clsItem {
    
    private String id;
    private String nombre;

    public clsItem(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }

    @Override
    public String toString() {
        return nombre; // Esto es lo que verá el usuario
    }
    
}
