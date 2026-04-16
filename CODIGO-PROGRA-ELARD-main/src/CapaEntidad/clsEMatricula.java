/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidad;

/**
 *
 * @author HP
 */
public class clsEMatricula {
    
    //DEFINIR LOS ATRIBUTOS DE LA TABLA tbdocente
    private int idmatricula;
    private int fecha;
    private int estado;
    private String dniemp;   // FK de tbempleado
    private String codalumno; // FK de tbalumno

    //CONSTRUCTOR
    public clsEMatricula() {
    }

    //GETTERS AND SETTERS
    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDniemp() {
        return dniemp;
    }

    public void setDniemp(String dniemp) {
        this.dniemp = dniemp;
    }

    public String getCodalumno() {
        return codalumno;
    }

    public void setCodalumno(String codalumno) {
        this.codalumno = codalumno;
    }
    
    
    
}
