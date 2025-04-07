package Modelo;

public class compra_plan {
	
   private long cod_Compra;
   private long NIT;
   private long codPlan;
   private String metodo_pago;
   private long valor_Total;
   private String fecha_hora;
   private String estado;
   
public compra_plan(long cod_Compra, long NIT, long codPlan, String metodo_pago, long valor_Total,
		String fecha_hora, String estado) {
	
	super();
	this.cod_Compra = cod_Compra;
	NIT = NIT;
	this.codPlan = codPlan;
	this.metodo_pago = metodo_pago;
	this.valor_Total = valor_Total;
	this.fecha_hora = fecha_hora;
	this.estado = estado;
}

public compra_plan() {
	super();
}

public long getcod_Compra() {
	return cod_Compra;
}

public void setcod_Compra(long cod_Compra) {
	this.cod_Compra = cod_Compra;
}

public long getNIT() {
	return NIT;
}

public void setNIT(long NIT) {
	NIT = NIT;
}

public long getcodPlan() {
	return codPlan;
}

public void setcodPlan(long codPlan) {
	this.codPlan = codPlan;
}

public String getmetodo_pago() {
	return metodo_pago;
}

public void setmetodo_pago(String metodo_pago) {
	this.metodo_pago = metodo_pago;
}

public long getvalor_Total() {
	return valor_Total;
}

public void setvalor_Total(long valor_Total) {
	this.valor_Total = valor_Total;
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
