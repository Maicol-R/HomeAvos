package Modelo;

import java.util.Date;

public class adulto_mayor {
	 private long numDocumento;
	 private long documento_Fam;
	 private String tipoDocumento;
	 private String nombres;
	 private String apellidos;
	 private String rh;
	 private String genero;
	 private String fechaNac;
	 private String cuidadosEspeciales;
	 
	 
	public adulto_mayor(long numDocumento, long documento_Fam, String tipoDocumento, String nombres, String apellidos, String rh,
			String genero, String fechaNac, String cuidadosEspeciales) {
		super();
		this.numDocumento = numDocumento;
		this.documento_Fam = documento_Fam;
		this.tipoDocumento = tipoDocumento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rh = rh;
		this.genero = genero;
		this.fechaNac = fechaNac;
		this.cuidadosEspeciales = cuidadosEspeciales;
	}
	
	public adulto_mayor(long numDocumento, String nombres, String apellidos, String rh,
			String genero, String fechaNac, String cuidadosEspeciales) {
		super();
		this.numDocumento = numDocumento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rh = rh;
		this.genero = genero;
		this.fechaNac = fechaNac;
		this.cuidadosEspeciales = cuidadosEspeciales;
	}


	public adulto_mayor() {
		super();
	}


	public long getNumDocumento() {
		return numDocumento;
	}


	public void setNumDocumento(long numDocumento) {
		this.numDocumento = numDocumento;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getRh() {
		return rh;
	}


	public void setRh(String rh) {
		this.rh = rh;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getCuidadosEspeciales() {
		return cuidadosEspeciales;
	}


	public void setCuidadosEspeciales(String cuidadosEspeciales) {
		this.cuidadosEspeciales = cuidadosEspeciales;
	}

	public long getDocumento_Fam() {
		return documento_Fam;
	}

	public void setDocumento_Fam(long documento_Fam) {
		this.documento_Fam = documento_Fam;
	}
	 
	
	



}