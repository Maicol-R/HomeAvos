/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author DeividAlexander
 */
public class Familiar extends Usuario {
    private String nmDocumento;  
  private String tipoDocumento;
  private String nombre;
  private String apellido;
  private String genero;

    public Familiar(String nmDocumento, String tipoDocumento, String nombre, String apellido, String genero, String cod, String telefono, String dirección, String correo, String contraseña) {
        super(cod, telefono, dirección, correo, contraseña);
        this.nmDocumento = nmDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }
    
    
    public Familiar() {
    }


    public String getNmDocumento() {
        return nmDocumento;
    }

    public void setNmDocumento(String nmDocumento) {
        this.nmDocumento = nmDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
  
  
}


