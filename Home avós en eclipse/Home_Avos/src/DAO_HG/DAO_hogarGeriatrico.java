package DAO_HG;

import java.util.List;

import Modelo.hogar_geriatrico;
import Modelo.info_postulacion;
import Modelo.servicios;

public interface DAO_hogarGeriatrico {

	    public void registrar(hogar_geriatrico a)throws Exception;
	    public void modificar(hogar_geriatrico a)throws Exception;
	    public void eliminar(long doc)throws Exception;
	    public List<hogar_geriatrico> buscar(long dato)throws Exception;
	    public Object iniciarSesion(long nit, String contr) throws Exception;
	    public Object traerInfo(long nit) throws Exception;
	    public List<hogar_geriatrico> listar()throws Exception;
	    public List<info_postulacion> listarPostulaciones(long nit)throws Exception;
}
