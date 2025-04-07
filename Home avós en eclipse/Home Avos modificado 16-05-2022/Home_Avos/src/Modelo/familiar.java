package Modelo;

public class familiar extends Usuario{
    private long documentoFam;
    private String tipoDocumento;
    private String nombres;
    private String apellidos;
    private String genero;
    
    
    
	public familiar(long cod, long telefono, String dirección, String correo, String contraseña, long documentoFam,
			String nombres, String apellidos) {
		super(cod, telefono, dirección, correo, contraseña);
		this.documentoFam = documentoFam;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}


	public familiar(long cod, long telefono, String dirección, String correo, String contraseña, long documentoFam,
			String tipoDocumento, String nombres, String apellidos, String genero) {
		super(cod, telefono, dirección, correo, contraseña);
		this.documentoFam = documentoFam;
		this.tipoDocumento = tipoDocumento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.genero = genero;
	}


	public familiar() {

	}


	public long getDocumentoFam() {
		return documentoFam;
	}


	public void setDocumentoFam(long documentoFam) {
		this.documentoFam = documentoFam;
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


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
}
