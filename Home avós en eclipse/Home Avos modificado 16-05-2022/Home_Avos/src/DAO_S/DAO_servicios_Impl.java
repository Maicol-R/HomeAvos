package DAO_S;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JOptionPane;

import Modelo.servicios;
import conexion.Conexion;

public class DAO_servicios_Impl extends Conexion implements DAO_servicios{

	public void registrar(servicios a) throws Exception {
		
            PreparedStatement st = this.getConexion().prepareStatement("Insert into servicios_hg values (?,?,?,?,?,?,?)");
            
            st.setLong(1, a.getCodigo());
            st.setLong(2, a.getNIT());
            st.setString(3, a.getNombre());
            st.setString(4, a.getDescrp());
            st.setString(5, a.getTiempo());
            st.setInt(6, a.getCupos());
            st.setLong(7, a.getPrecio());
             
            st.executeUpdate();
            
       
		
	}

	public void modificar(servicios a) throws Exception {
		
		
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE servicios_hg "+"SET nombre = ?, descripcion = ?, "
            		                                                   + "tiempo = ?, cupos = ?, precio = ? "+"WHERE cod_Servicio = ?");
  
    
            st.setString(1, a.getNombre());
            st.setString(2, a.getDescrp());
            st.setString(3, a.getTiempo());
            st.setInt(4, a.getCupos());
            st.setLong(5, a.getPrecio());
            st.setLong(6, a.getCodigo());
            
            st.executeUpdate();
            
	}

	
	
	
	public void eliminar(long cod) throws Exception {
		
		
			
            PreparedStatement st2 = this.getConexion().prepareStatement("delete from servicios_hg where cod_servicio=?");
            st2.setLong(1, cod);
            st2.executeUpdate();
            
            
            
       
	}

	
	public List<servicios> buscar(long dato) throws Exception {
	
		List<servicios> lista = null;
        try {
        	
            PreparedStatement st = null;
            PreparedStatement st2 = null;
            	
            	st = this.getConexion().prepareStatement("select * from servicios_hg where cod_Servicio=?");
                st.setLong(1, dato);
                
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
     
            
            while (rs.next()) {
                servicios a = new servicios();
                a.setCodigo(rs.getLong("cod_Servicio"));
                a.setNombre(rs.getString("nombre"));
                a.setDescrp(rs.getString("descripcion"));
                a.setCupos(rs.getInt("cupos"));
                a.setTiempo(rs.getString("tiempo"));
                a.setPrecio(rs.getLong("precio"));
                
                lista.add(a);
               
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en DAOimpl " +e);
        } finally {
            
        }
        
        return lista;
	}	
	
	public List<servicios> listarServicios(long nit) throws Exception {
		List<servicios> lista = null;
        try {
            PreparedStatement st = this.getConexion().prepareStatement("select * from servicios_HG "+"WHERE NIT=?");
            st.setLong(1, nit);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                servicios a = new servicios();
                a.setCodigo(rs.getLong("cod_servicio"));
                a.setNIT(rs.getLong("NIT"));
                a.setNombre(rs.getString("nombre"));
                a.setDescrp(rs.getString("descripcion"));
                a.setTiempo(rs.getString("tiempo"));
                a.setCupos(rs.getInt("cupos"));
                a.setPrecio(rs.getLong("precio"));
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
	
	
	

	
	



