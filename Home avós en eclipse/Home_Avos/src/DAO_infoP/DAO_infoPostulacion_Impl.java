package DAO_infoP;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.adulto_mayor;
import Modelo.familiar;
import Modelo.info_postulacion;
import conexion.Conexion;

public class DAO_infoPostulacion_Impl extends Conexion implements DAO_infoPostulacion{


	@Override
	public List buscarPostEspecificas(long dato) throws Exception {
		
		
		List<info_postulacion> lista = new ArrayList();
		
        try {
            PreparedStatement st = null;
            	
            	st = this.getConexion().prepareStatement("SELECT * FROM info_postulacion "+"WHERE cod_Post = ?");
                st.setLong(1, dato);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
            	info_postulacion a = new info_postulacion();
            	
                a.setCod_Post(rs.getLong("cod_Post"));
                a.setNIT(rs.getLong("NIT"));
                a.setDoc_familiar(rs.getLong("documento_Fam"));
                a.setDoc_adultoM(rs.getLong("documento_AM"));
                a.setServicios(rs.getString("servicios_elegidos"));
                a.setFecha_hora(rs.getString("fecha_hora"));
                a.setEstado(rs.getString("estado"));
                
                lista.add(a);
            }
            
            rs.close();
            st.close();


        } catch (Exception e) {
            System.out.println("Error en DAOimpl postulacionesHG" +e);
        } finally {
            
        }
        
        return lista;
		
	}
	
	@Override
	public List buscarPostulacionesHG(long dato) throws Exception {
		
		
		List<info_postulacion> lista = new ArrayList();
		
        try {
            PreparedStatement st = null;
            	
            	st = this.getConexion().prepareStatement("SELECT * FROM info_postulacion "+"WHERE NIT = ?");
                st.setLong(1, dato);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
            	info_postulacion a = new info_postulacion();
            	
                a.setCod_Post(rs.getLong("cod_Post"));
                a.setNIT(rs.getLong("NIT"));
                a.setDoc_familiar(rs.getLong("documento_Fam"));
                a.setDoc_adultoM(rs.getLong("documento_AM"));
                a.setServicios(rs.getString("servicios_elegidos"));
                a.setFecha_hora(rs.getString("fecha_hora"));
                a.setEstado(rs.getString("estado"));
                
                lista.add(a);
            }
            
            rs.close();
            st.close();


        } catch (Exception e) {
            System.out.println("Error en DAOimpl postulacionesHG" +e);
        } finally {
            
        }
        
        return lista;
		
	}


	@Override
	public void reportarPostulacion(info_postulacion a) throws Exception {
		try {
            PreparedStatement st = this.getConexion().prepareStatement("Insert into info_postulacion values (?,?,?,?,?,?,?)");
          
            st.setLong(1, a.getCod_Post());
            st.setLong(2, a.getNIT());
            st.setLong(3, a.getDoc_familiar());
            st.setLong(4, a.getDoc_adultoM());
            st.setString(5, a.getServicios());
            st.setString(6, a.getFecha_hora());
            st.setString(7, a.getEstado());
            
            st.executeUpdate();
      
            
        } catch (Exception e) {
      
        	System.out.println("ERROR en GUARDAR REPORTE adulto mayor "+e);
        } finally {
        
        }
		
	}

	
	
	
}
