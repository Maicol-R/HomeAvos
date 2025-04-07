package Modelo;

public class info_postulacion {
   private long cod_Post;
   private long NIT;
   private long doc_familiar;
   private long doc_adultoM;
   private String servicios;
   private String fecha_hora;
   private String estado;
   
public info_postulacion(long cod_Post, long nIT, long doc_familiar, long doc_adultoM, String servicios,
		String fecha_hora, String estado) {
	super();
	this.cod_Post = cod_Post;
	NIT = nIT;
	this.doc_familiar = doc_familiar;
	this.doc_adultoM = doc_adultoM;
	this.servicios = servicios;
	this.fecha_hora = fecha_hora;
	this.estado = estado;
}

public info_postulacion() {
	super();
}

public long getCod_Post() {
	return cod_Post;
}

public void setCod_Post(long cod_Post) {
	this.cod_Post = cod_Post;
}

public long getNIT() {
	return NIT;
}

public void setNIT(long nIT) {
	NIT = nIT;
}

public long getDoc_familiar() {
	return doc_familiar;
}

public void setDoc_familiar(long doc_familiar) {
	this.doc_familiar = doc_familiar;
}

public long getDoc_adultoM() {
	return doc_adultoM;
}

public void setDoc_adultoM(long doc_adultoM) {
	this.doc_adultoM = doc_adultoM;
}

public String getServicios() {
	return servicios;
}

public void setServicios(String servicios) {
	this.servicios = servicios;
}

public String getFecha_hora() {
	return fecha_hora;
}

public void setFecha_hora(String fecha_hora) {
	this.fecha_hora = fecha_hora;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}
   
   
   
   
   
}
