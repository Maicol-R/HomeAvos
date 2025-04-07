package DAO_infoP;

import java.util.List;

import Modelo.adulto_mayor;
import Modelo.info_postulacion;

public interface DAO_infoPostulacion {
	
    public List buscarPostulacionesHG(long dato)throws Exception;
    public List buscarPostEspecificas(long dato)throws Exception;
    public void reportarPostulacion(info_postulacion a)throws Exception;

}
