package Modelo;

public class valoracion {
      private long cod_valoracion;
      private long NIT;
      private long documento_Fam;
      private short calificacion;
      private String comentario;
      
      
	public valoracion(long cod_valoracion, long nIT, long documento_Fam, short calificacion, String comentario) {
		super();
		this.cod_valoracion = cod_valoracion;
		this.NIT = nIT;
		this.documento_Fam = documento_Fam;
		this.calificacion = calificacion;
		this.comentario = comentario;
	}
	
	public valoracion(long nIT, long documento_Fam, short calificacion, String comentario) {
		super();
		this.NIT = nIT;
		this.documento_Fam = documento_Fam;
		this.calificacion = calificacion;
		this.comentario = comentario;
	}
	
	public valoracion(long nIT, long documento_Fam) {
		super();
		this.NIT = nIT;
		this.documento_Fam = documento_Fam;
	}
	
      
      
	public valoracion() {
		
	}


	public long getCod_valoracion() {
		return cod_valoracion;
	}


	public void setCod_valoracion(long cod_valoracion) {
		this.cod_valoracion = cod_valoracion;
	}


	public long getNIT() {
		return NIT;
	}


	public void setNIT(long nIT) {
		NIT = nIT;
	}


	public long getDocumento_Fam() {
		return documento_Fam;
	}


	public void setDocumento_Fam(long documento_Fam) {
		this.documento_Fam = documento_Fam;
	}


	public short getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(short calificacion) {
		this.calificacion = calificacion;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
      
    
	
}
