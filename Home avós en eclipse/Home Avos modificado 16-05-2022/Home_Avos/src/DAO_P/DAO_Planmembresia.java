package DAO_P;

import java.util.List;

import Modelo.Plan_membresia;
import Modelo.compra_plan;


public interface DAO_Planmembresia {

	public void registrar(Plan_membresia a)throws Exception;
    public void modificar(Plan_membresia a)throws Exception;
    public void eliminar(long codPlan)throws Exception;
    public List<Plan_membresia> buscar(long dato)throws Exception;
    public List<Plan_membresia> listar()throws Exception;
	void reportarcompraplan(compra_plan a) throws Exception;

}
