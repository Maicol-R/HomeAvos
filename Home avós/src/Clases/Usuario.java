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
public class Usuario {
    private String cod;
    private String telefono;
    private String dirección;
    private String correo;
    private String contraseña;

    public Usuario(String cod, String telefono, String dirección, String correo, String contraseña) {
        this.cod = cod;
        this.telefono = telefono;
        this.dirección = dirección;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    

    public Usuario() {
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
    
}