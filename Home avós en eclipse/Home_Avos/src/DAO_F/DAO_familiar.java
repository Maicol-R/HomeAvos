package DAO_F;

import java.util.List;

import Modelo.familiar;

public interface DAO_familiar {

	public void registrar(familiar a)throws Exception;
    public void modificar(familiar a)throws Exception;
    public void eliminar(long nit)throws Exception;
    public List<familiar> buscar(long dato)throws Exception;
    public List<familiar> listar()throws Exception;
    public Object iniciarSesion(String correo, String contr) throws Exception;
}
