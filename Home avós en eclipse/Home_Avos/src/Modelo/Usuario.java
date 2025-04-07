package Modelo;

public class Usuario {
    private long cod;
    private long telefono;
    private String direcci�n;
    private String correo;
    private String contrase�a;

    public Usuario(long cod, long telefono, String direcci�n, String correo, String contrase�a) {
        this.cod = cod;
        this.telefono = telefono;
        this.direcci�n = direcci�n;
        this.correo = correo;
        this.contrase�a = contrase�a;
    }

    

    public Usuario() {
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDirecci�n() {
        return direcci�n;
    }

    public void setDirecci�n(String direcci�n) {
        this.direcci�n = direcci�n;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrase�a() {
        return contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }
    
    
}
