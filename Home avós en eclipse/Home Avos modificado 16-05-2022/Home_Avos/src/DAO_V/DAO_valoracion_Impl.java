package DAO_V;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import Modelo.valoracion;
import conexion.Conexion;

public class DAO_valoracion_Impl extends Conexion implements DAO_valoracion{

	public void registrar(valoracion a) throws Exception {
		
            PreparedStatement st = this.getConexion().prepareStatement("Insert into valoracion_hg values (?,?,?,?,?)");
            
            st.setLong(1, a.getCod_valoracion());
            st.setLong(2, a.getNIT());
            st.setLong(3, a.getDocumento_Fam());
            st.setShort(4, a.getCalificacion());
            st.setString(5, a.getComentario());
             
            st.executeUpdate();
            
       
		
	}

	public void modificar(valoracion a) throws Exception {
		
		
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE valoracion_hg "+"SET calificacion = ?, "
            		                                                   + "comentario = ? "+"WHERE NIT = ? and documento_Fam = ?");

            st.setShort(1, a.getCalificacion());
            st.setString(2, a.getComentario());
            st.setLong(3, a.getNIT());
            st.setLong(4, a.getDocumento_Fam());
            
            st.executeUpdate();
            
	}

	
	
	
	public void eliminar(valoracion a) throws Exception {
		
		
			
            PreparedStatement st = this.getConexion().prepareStatement("delete from valoracion_hg WHERE NIT = ? and documento_Fam = ?");
            
            st.setLong(1, a.getNIT());
            st.setLong(2, a.getDocumento_Fam());
            
            st.executeUpdate();
       
	}

	
	public List<valoracion> buscar(valoracion a) throws Exception {
	
		List<valoracion> lista = null;
        try {
        	
            PreparedStatement st = null;
            PreparedStatement st2 = null;
            	
            	st = this.getConexion().prepareStatement("select * from valoracion_hg WHERE NIT = ? and documento_Fam = ?");
            	st.setLong(2, a.getNIT());
                st.setLong(3, a.getDocumento_Fam());
                
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
     
            
            while (rs.next()) {
            	valoracion b = new valoracion();
                b.setCod_valoracion(rs.getLong("cod_valoracion"));
                b.setNIT(rs.getLong("NIT"));
                b.setDocumento_Fam(rs.getLong("documento_Fam"));
                b.setCod_valoracion(rs.getShort("calificacion"));
                b.setComentario(rs.getString("comentario"));
                
                lista.add(b);
               
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en DAOimpl " +e);
        } finally {
            
        }
        
        return lista;
	}	
	
	public List<valoracion> listarValoracion(long nit) throws Exception {
		List<valoracion> lista = null;
        try {
            PreparedStatement st = this.getConexion().prepareStatement("select * from valoracion_hg "+"WHERE NIT=?");
            st.setLong(1, nit);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                valoracion a = new valoracion();
                a.setCod_valoracion(rs.getLong("cod_valoracion"));
                a.setNIT(rs.getLong("NIT"));
                a.setDocumento_Fam(rs.getLong("documento_Fam"));
                a.setCod_valoracion(rs.getShort("calificacion"));
                a.setComentario(rs.getString("comentario"));
                lista.add(a);
                // System.out.println(a.getNombre());
            }
            rs.close();
            st.close();
           
        } catch (Exception e) {
            throw e;
        } finally {
            
        }
        return lista;
	} 
	
	}
	
	
	

	
	



