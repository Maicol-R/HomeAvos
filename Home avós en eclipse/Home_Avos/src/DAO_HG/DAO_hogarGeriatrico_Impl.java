package DAO_HG;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.hogar_geriatrico;
import Modelo.info_postulacion;
import Modelo.servicios;
import conexion.Conexion;


public class DAO_hogarGeriatrico_Impl extends Conexion implements DAO_hogarGeriatrico{

	
	
	public void registrar(hogar_geriatrico a) throws Exception {
	
            PreparedStatement st = this.getConexion().prepareStatement("Insert into Usuario values (?,?,?,?,?)");
            PreparedStatement st2  = this.getConexion().prepareStatement("insert into hogar_geriatrico values(?,?,?,?,?,?,?,?,?)");
            
            st.setLong(1, a.getCod());
            st.setLong(2, a.getTelefono());
            st.setString(3, a.getDirección());
            st.setString(4, a.getCorreo());
            st.setString(5, a.getContraseña());
            
            st2.setLong(1, a.getNit());
            st2.setString(2, a.getRep_Legal());
            st2.setString(3, a.getTipo_Documento());
            st2.setLong(4, a.getNum_Documento());
            st2.setString(5, a.getNom_Residencia());
            st2.setLong(6, a.getTelefono2());
            st2.setString(7, a.getCiudad());
            st2.setString(8, "Descripción del hogar geriátrico");
            st2.setString(9, "Descripción corta del hogar geriátrico");
            
            st.executeUpdate();
            st2.executeUpdate();
            
            
		
	}

	public void modificar(hogar_geriatrico a) throws Exception {
		
	
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE usuario "+"SET Telefono = ?, Direccion = ?, "
            		                                                   + "Correo = ?, Contraseña = ? "+"WHERE Cod_datos = ?");
  
            PreparedStatement st2 = this.getConexion().prepareStatement("UPDATE hogar_geriatrico "+"SET rep_Legal = ?," 
                    +"tipo_Documento = ?," +"num_Documento = ?," +"nom_Residencia = ?,"
                    +"telefono2 = ?,"+"ciudad = ?,"+"descripcion = ?,"+"descrp_corta = ? "+"WHERE NIT = ?");    
            
            st.setLong(1, a.getTelefono());
            st.setString(2, a.getDirección());
            st.setString(3, a.getCorreo());
            st.setString(4, a.getContraseña());
            st.setLong(5, a.getNit());
            
            st2.setString(1, a.getRep_Legal());
            st2.setString(2, a.getTipo_Documento());
            st2.setLong(3, a.getNum_Documento());
            st2.setString(4, a.getNom_Residencia());
            st2.setLong(5, a.getTelefono2());
            st2.setString(6, a.getCiudad());
            st2.setString(7, a.getDescripcion());
            st2.setString(8, a.getDescrp_corta());
            st2.setLong(9, a.getNit());
            
            st.executeUpdate();
            st2.executeUpdate();
       
           
	}
	
	
	
	
	public void eliminar(long nit) throws Exception {
		
		PreparedStatement st5 = this.getConexion().prepareStatement("delete valoracion_hg where NIT=?");
        st5.setLong(1, nit);
        st5.executeUpdate();  
        
        PreparedStatement st4 = this.getConexion().prepareStatement("delete servicios_hg where NIT=?");
        st4.setLong(1, nit);
        st4.executeUpdate();  
        
		PreparedStatement st3 = this.getConexion().prepareStatement("delete from info_postulacion where NIT=?");
        st3.setLong(1, nit);
        st3.executeUpdate();
		
            PreparedStatement st2 = this.getConexion().prepareStatement("delete from hogar_geriatrico where NIT=?");
            st2.setLong(1, nit);
            st2.executeUpdate();
            
            PreparedStatement st = this.getConexion().prepareStatement("delete from usuario where Cod_datos=?");
            st.setLong(1, nit);
            st.executeUpdate();
            
       
           
        
	}

	public List<hogar_geriatrico> buscar(long dato) throws Exception {
	
		List<hogar_geriatrico> lista = null;
        try {
        	
            PreparedStatement st = null;
            PreparedStatement st2 = null;
            	
            	st = this.getConexion().prepareStatement("select * from usuario where Cod_datos = ?");
                st.setLong(1, dato);
                
                st2 = this.getConexion().prepareStatement("select * from hogar_geriatrico where NIT = ?");
                st2.setLong(1, dato);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            ResultSet rs2 = st2.executeQuery();
            
            while (rs.next() && rs2.next() ) {
                hogar_geriatrico a = new hogar_geriatrico();
                a.setNit(rs2.getLong("NIT"));
                a.setRep_Legal(rs2.getString("rep_Legal"));
                a.setTipo_Documento(rs2.getString("tipo_Documento"));
                a.setNum_Documento(rs2.getLong("num_Documento"));
                a.setNom_Residencia(rs2.getString("nom_Residencia"));
                a.setTelefono(rs.getLong("telefono"));
                a.setTelefono2(rs2.getLong("telefono2"));
                a.setDirección(rs.getString("direccion"));
                a.setCiudad(rs2.getString("ciudad"));
                a.setCorreo(rs.getString("correo"));
                a.setContraseña(rs.getString("contraseña"));
                lista.add(a);
               
            }
            rs.close();
            rs2.close();
            st.close();
            st2.close();

        } catch (Exception e) {
            System.out.println("Error en DAOimpl " +e);
        } finally {
            
        }
        
        return lista;
    }
        

	@Override
	public Object iniciarSesion(long nit, String contr) throws Exception {
		long v=0;
		hogar_geriatrico HG = new hogar_geriatrico();
		
		try{
	                       
	            PreparedStatement estatuto2 = this.getConexion().prepareStatement("select * FROM usuario WHERE Cod_datos = ? and Contraseña = ?");
	            estatuto2.setLong(1, nit);
	            estatuto2.setString(2, contr);
	            ResultSet rs2 = estatuto2.executeQuery();
	            
	            if(rs2.next()){
	            HG.setCod(rs2.getLong("Cod_datos"));    
	            HG.setTelefono(rs2.getLong("Telefono"));
	            HG.setDirección(rs2.getString("Direccion"));
	            HG.setCorreo(rs2.getString("Correo"));
	            HG.setContraseña(rs2.getString("Contraseña"));

	            } else { System.out.println();}
	        
	            v=HG.getCod();
	            
	            if(v!=0) {
	            
	               PreparedStatement estatuto = this.getConexion().prepareStatement("select * FROM hogar_geriatrico WHERE NIT = "+nit);
	           
	               ResultSet rs = estatuto.executeQuery();
	          
	               if(rs.next()){
	            	 HG.setNit(rs.getLong("NIT"));
	                 HG.setRep_Legal(rs.getString("rep_Legal"));
	                 HG.setTipo_Documento(rs.getString("tipo_Documento"));
	                 HG.setNum_Documento(rs.getLong("num_Documento"));
	                 HG.setNom_Residencia(rs.getString("nom_Residencia"));
	                 HG.setTelefono2(rs.getLong("Telefono2"));
	                 HG.setCiudad(rs.getString("Ciudad"));
	                 HG.setDescripcion(rs.getString("descripcion"));
	            
	                } else { System.out.println();}
	               
	            	
	            } else {
	            	
	            }
	            
	        }catch(Exception e){
	            System.out.println("Error "+e);
	            
	 }
		return HG;
	  
	}


	public List<hogar_geriatrico> listar() throws Exception {
		List<hogar_geriatrico> lista = null;
        try {
        	
            PreparedStatement st = null;
            	
                st = this.getConexion().prepareStatement("SELECT * FROM hogar_geriatrico INNER JOIN usuario WHERE hogar_geriatrico.NIT = usuario.Cod_datos ");
                
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                hogar_geriatrico a = new hogar_geriatrico();
                a.setNit(rs.getLong("NIT"));
                a.setRep_Legal(rs.getString("rep_Legal"));
                a.setTipo_Documento(rs.getString("tipo_Documento"));
                a.setNum_Documento(rs.getLong("num_Documento"));
                a.setNom_Residencia(rs.getString("nom_Residencia"));
                a.setTelefono(rs.getLong("telefono"));
                a.setTelefono2(rs.getLong("telefono2"));
                a.setDirección(rs.getString("direccion"));
                a.setCiudad(rs.getString("ciudad"));
                a.setCorreo(rs.getString("correo"));
                a.setContraseña(rs.getString("contraseña"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setDescrp_corta(rs.getString("descrp_corta"));
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

	@Override
	public Object traerInfo(long nit) throws Exception {
		long v=0;
		hogar_geriatrico HG = new hogar_geriatrico();
		
		try{
	                       
	            PreparedStatement estatuto2 = this.getConexion().prepareStatement("select * FROM usuario WHERE Cod_datos = ?");
	            estatuto2.setLong(1, nit);
	            ResultSet rs2 = estatuto2.executeQuery();
	            
	            if(rs2.next()){
	            HG.setCod(rs2.getLong("Cod_datos"));    
	            HG.setTelefono(rs2.getLong("Telefono"));
	            HG.setDirección(rs2.getString("Direccion"));
	            HG.setCorreo(rs2.getString("Correo"));
	            HG.setContraseña(rs2.getString("Contraseña"));

	            } else { System.out.println();}
	        
	            v=HG.getCod();
	            
	            if(v!=0) {
	            
	               PreparedStatement estatuto = this.getConexion().prepareStatement("select * FROM hogar_geriatrico WHERE NIT = "+nit);
	           
	               ResultSet rs = estatuto.executeQuery();
	          
	               if(rs.next()){
	            	 HG.setNit(rs.getLong("NIT"));
	                 HG.setRep_Legal(rs.getString("rep_Legal"));
	                 HG.setTipo_Documento(rs.getString("tipo_Documento"));
	                 HG.setNum_Documento(rs.getLong("num_Documento"));
	                 HG.setNom_Residencia(rs.getString("nom_Residencia"));
	                 HG.setTelefono2(rs.getLong("Telefono2"));
	                 HG.setCiudad(rs.getString("Ciudad"));
	                 HG.setDescripcion(rs.getString("descripcion"));
	            
	                } else { System.out.println();}
	               
	            	
	            } else {
	            	
	            }
	            
	        }catch(Exception e){
	            System.out.println("Error "+e);
	            
	 }
		return HG;
	}

	@Override
	public List<info_postulacion> listarPostulaciones(long nit) throws Exception {
		// TODO Auto-generated method stub
		List<info_postulacion> lista = null;
        try {
        	
            PreparedStatement st = null;
            	
                st = this.getConexion().prepareStatement("SELECT * FROM info_postulacion WHERE NIT = ?");
                st.setLong(1, nit);
                
            lista = new ArrayList();
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
            System.out.println("Error en listar postulacion " +e);
        } finally {
            
        }
        
        return lista;
	}
	
	
	}
	
	
	

	
	

