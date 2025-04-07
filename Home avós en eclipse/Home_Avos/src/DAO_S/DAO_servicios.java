package DAO_S;

import java.util.List;

import Modelo.hogar_geriatrico;
import Modelo.servicios;

public interface DAO_servicios {

	    public void registrar(servicios a)throws Exception;
	    public void modificar(servicios a)throws Exception;
	    public void eliminar(long doc)throws Exception;
	    public List<servicios> buscar(long dato)throws Exception;
	    public List<servicios> listarServicios(long nit)throws Exception; 
	   
}

