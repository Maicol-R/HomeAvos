package DAO_AD;

import java.util.List;

import Modelo.administrador;

public interface DAO_Administrador {

	public void registrar(administrador a)throws Exception;
    public void modificar(administrador a)throws Exception;
    public void eliminar(long documentoAd)throws Exception;
    public List<administrador> buscar(long dato)throws Exception;
    public List<administrador> listar()throws Exception;
    public Object iniciarSesion(String correo, String contr) throws Exception;
}
