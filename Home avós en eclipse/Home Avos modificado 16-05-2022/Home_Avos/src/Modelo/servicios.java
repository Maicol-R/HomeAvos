package Modelo;

public class servicios {
     private long codigo;
     private long NIT;
     private String nombre;
     private String descrp;
     private String tiempo;
     private int cupos;
     private long precio;
     
	public servicios(long codigo, long nIT, String nombre, String descrp, String tiempo, int cupos, long precio) {
		super();
		this.codigo = codigo;
		NIT = nIT;
		this.nombre = nombre;
		this.descrp = descrp;
		this.tiempo = tiempo;
		this.cupos = cupos;
		this.precio = precio;
	}
	
	public servicios(long codigo, String nombre, String descrp, String tiempo, int cupos, long precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descrp = descrp;
		this.tiempo = tiempo;
		this.cupos = cupos;
		this.precio = precio;
	}
	
	public servicios() {
		super();
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getNIT() {
		return NIT;
	}
	public void setNIT(long nIT) {
		NIT = nIT;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public int getCupos() {
		return cupos;
	}
	public void setCupos(int cupos) {
		this.cupos = cupos;
	}
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}
     
     
}