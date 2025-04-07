package Modelo;


public class Plan_membresia {

	
	 private long codPlan;
     private String nombre;
     private String duracion;
     private String descripcion;
     private long precio;
    
     
	public Plan_membresia(long codPlan,String nombre,String duracion,String descripcion, long precio) {
		super();
		this.codPlan = codPlan;
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	
	public Plan_membresia( String nombre, String duracion, String descripcion, long precio) {
		super();
		
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public Plan_membresia() {
		super();
	}
	
	public long getcodPlan() {
		return codPlan;
	}
	public void setcodPlan(long codPlan) {
		this.codPlan = codPlan;
	}
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getduracion() {
		return duracion;
	}
	public void setduracion(String duracion) {
		this.duracion = duracion;
	}
	public String getdescripcion() {
		return descripcion;
	}
	public void setdescripcion(String descripcion) {
		this.descripcion= descripcion;
	}
	public long getprecio() {
		return precio;
	}
	public void setprecio(long precio) {
		this.precio = precio;
	
	
	}
     	
	
	
}
