package Modelo;

public class administrador extends Usuario{
	private long documentoAd;
    private String tipoDocumento;
    private String fechaExpe;
    private String nombres;
    private String apellidos;
    private String ciudad;
    
    
	public administrador(long cod, long telefono, String dirección, String correo, String contraseña, long documentoAd,
			String tipoDocumento, String fechaExpe, String nombres, String apellidos, String ciudad) {
		super(cod, telefono, dirección, correo, contraseña);
		this.documentoAd = documentoAd;
		this.tipoDocumento = tipoDocumento;
		this.fechaExpe = fechaExpe;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
	}
 

	public administrador(long cod, long telefono, String dirección, String correo, String contraseña, String nombres,
			String apellidos, String ciudad) {
		super(cod, telefono, dirección, correo, contraseña);
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
	}


	public administrador() {
		
	}


	public long getDocumentoAd() {
		return documentoAd;
	}


	public void setDocumentoAd(long documentoAd) {
		this.documentoAd = documentoAd;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getFechaExpe() {
		return fechaExpe;
	}


	public void setFechaExpe(String fechaExpe) {
		this.fechaExpe = fechaExpe;
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


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
    
}