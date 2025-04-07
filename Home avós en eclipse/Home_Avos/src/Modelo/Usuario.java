package Modelo;

public class Usuario {
    private long cod;
    private long telefono;
    private String dirección;
    private String correo;
    private String contraseña;

    public Usuario(long cod, long telefono, String dirección, String correo, String contraseña) {
        this.cod = cod;
        this.telefono = telefono;
        this.dirección = dirección;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    

    public Usuario() {
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
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

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }
    
    
}
