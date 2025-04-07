package DAO_AM;

import java.util.List;

import Modelo.adulto_mayor;
import Modelo.info_postulacion;

public interface DAO_adultoMayor {
	
	public void registrar(adulto_mayor a)throws Exception;
    public void modificar(adulto_mayor a)throws Exception;
    public void eliminar(long Ndoc)throws Exception;
    public List<adulto_mayor> buscar(long dato)throws Exception;
    public List<adulto_mayor> listar()throws Exception;

}
