package Modelo;

public class hogar_geriatrico extends Usuario{

	private long nit;
	private String rep_Legal;
	private String tipo_Documento;
	private long num_Documento;
	private String nom_Residencia;
	private long telefono2;
	private String ciudad;
	private String descripcion;
	private String descrp_corta;
	
	public hogar_geriatrico () {
	}

	public hogar_geriatrico(long cod, long telefono, String dirección, String correo, String contraseña, long nit,
			String rep_Legal, String tipo_Documento, long num_Documento, String nom_Residencia, long telefono2,
			String ciudad, String descripcion, String descrp_corta) {
		super(cod, telefono, dirección, correo, contraseña);
		this.nit = nit;
		this.rep_Legal = rep_Legal;
		this.tipo_Documento = tipo_Documento;
		this.num_Documento = num_Documento;
		this.nom_Residencia = nom_Residencia;
		this.telefono2 = telefono2;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.descrp_corta = descrp_corta;
	}

	
	public hogar_geriatrico(long cod, long telefono, String dirección, String correo, String contraseña, long nit,
			String rep_Legal, String tipo_Documento, long num_Documento, String nom_Residencia, long telefono2,
			String ciudad) {
		super(cod, telefono, dirección, correo, contraseña);
		this.nit = nit;
		this.rep_Legal = rep_Legal;
		this.tipo_Documento = tipo_Documento;
		this.num_Documento = num_Documento;
		this.nom_Residencia = nom_Residencia;
		this.telefono2 = telefono2;
		this.ciudad = ciudad;
	}


	public long getNit() {
		return nit;
	}

	public void setNit(long nit) {
		this.nit = nit;
	}

	public String getRep_Legal() {
		return rep_Legal;
	}

	public void setRep_Legal(String rep_Legal) {
		this.rep_Legal = rep_Legal;
	}

	public String getTipo_Documento() {
		return tipo_Documento;
	}

	public void setTipo_Documento(String tipo_Documento) {
		this.tipo_Documento = tipo_Documento;
	}

	public long getNum_Documento() {
		return num_Documento;
	}

	public void setNum_Documento(long num_Documento) {
		this.num_Documento = num_Documento;
	}

	public String getNom_Residencia() {
		return nom_Residencia;
	}

	public void setNom_Residencia(String nom_Residencia) {
		this.nom_Residencia = nom_Residencia;
	}

	public long getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(long telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescrp_corta() {
		return descrp_corta;
	}

	public void setDescrp_corta(String descrp_corta) {
		this.descrp_corta = descrp_corta;
	}
	
	
	
}


	