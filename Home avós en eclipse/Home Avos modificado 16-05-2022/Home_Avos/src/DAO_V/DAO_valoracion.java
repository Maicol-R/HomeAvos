package DAO_V;

import java.util.List;

import Modelo.hogar_geriatrico;
import Modelo.servicios;
import Modelo.valoracion;

public interface DAO_valoracion {

	    public void registrar(valoracion a)throws Exception;
	    public void modificar(valoracion a)throws Exception;
	    public void eliminar(valoracion a)throws Exception;
	    public List<valoracion> buscar(valoracion a)throws Exception;
	    public List<valoracion> listarValoracion(long nit)throws Exception; 
	   
}

