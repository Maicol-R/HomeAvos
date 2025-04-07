package DAO_P;

import java.sql.PreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JOptionPane;


import Modelo.Plan_membresia;
import Modelo.compra_plan;
import Modelo.info_postulacion;
import conexion.Conexion;


public class DAO_Planmembresia_Impl extends Conexion implements DAO_Planmembresia{
	
		public void registrar(Plan_membresia a) throws Exception {
			
	            PreparedStatement st = this.getConexion().prepareStatement("Insert into Plan_membresia values (?,?,?,?,?)");
	            
	            st.setLong(1, a.getcodPlan());
	            st.setString(2, a.getnombre());
	            st.setString(3, a.getduracion());
	            st.setString(4, a.getdescripcion());
	            st.setLong(5, a.getprecio());
	           
	            st.executeUpdate();
	           	
		}

		public void modificar(Plan_membresia a) throws Exception {
			
	            PreparedStatement st = this.getConexion().prepareStatement("UPDATE Plan_membresia "+"SET nombre = ?, duracion = ?, "
	            		                                                   + "descripcion = ?, precio = ? "+"WHERE codPlan = ?");
	            
	            st.setString(1, a.getnombre());
	            st.setString(2, a.getduracion());
	            st.setString(3, a.getdescripcion());
	            st.setLong(4, a.getprecio());
	            st.setLong(5, a.getcodPlan());
	           
	            
	            st.executeUpdate();
		}

		public void eliminar(long codPlan) throws Exception {
		
	            PreparedStatement st2 = this.getConexion().prepareStatement("delete from Plan_membresia WHERE codPlan=?");
	            st2.setLong(1, codPlan);
	            st2.executeUpdate();
		}

		
		
		
		public List<Plan_membresia> buscar(long dato) throws Exception {
		
			List<Plan_membresia> lista = null;
	        try {
	        	
	            PreparedStatement st = null;
	        
	            	
	            	st = this.getConexion().prepareStatement("select * from Plan_membresia WHERE codPlan=?");
	                st.setLong(1, dato);
	                
	            lista = new ArrayList();
	            ResultSet rs = st.executeQuery();
	     
	            
	            while (rs.next()) {
	                Plan_membresia a = new Plan_membresia();
	                a.setcodPlan(rs.getLong("codPlan"));
	                a.setnombre(rs.getString("nombre"));
	                a.setduracion(rs.getString("duracion"));
	                a.setdescripcion(rs.getString("descripcion"));
	                a.setprecio(rs.getLong("precio"));
	                
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
		
		
		
		public List<Plan_membresia> listar(long codPlan) throws Exception {
			List<Plan_membresia> lista = null;
	        try {
	            PreparedStatement st = this.getConexion().prepareStatement("select * from Plan_membresia "+"WHERE codPlan=?");
	            st.setLong(1, codPlan);
	            lista = new ArrayList();
	            ResultSet rs = st.executeQuery();
	            
	            while (rs.next()) {
	                Plan_membresia a = new Plan_membresia();
	                a.setcodPlan(rs.getLong("codPlan"));
	                a.setnombre(rs.getString("nombre"));
	                a.setduracion(rs.getString("duracion"));
	                a.setdescripcion(rs.getString("descripcion"));
	                a.setprecio(rs.getLong("precio"));
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

		@Override
		public List<Plan_membresia> listar() throws Exception {
			// TODO Auto-generated method stub
			return null;
		} 
		
		@Override
		public void reportarcompraplan(compra_plan a) throws Exception {
			try {
	            PreparedStatement st = this.getConexion().prepareStatement("Insert into compra_plan values (?,?,?,?,?,?,?)");
	          
	            st.setLong(1, a.getcod_Compra());
	            st.setLong(2, a.getNIT());
	            st.setLong(3, a.getcodPlan());
	            st.setString(4, a.getFecha_hora());
	            st.setString(5, a.getmetodo_pago());
	            st.setLong(6, a.getvalor_Total());
	            st.setString(7, a.getEstado());
	         
	            
	            st.executeUpdate();
	      
	            
	        } catch (Exception e) {
	      
	        	System.out.println("ERROR en GUARDAR REPORTE de COMPRA DE PLAN "+e);
	        } finally {
	        
		}
		}
}
		
		
		
		
