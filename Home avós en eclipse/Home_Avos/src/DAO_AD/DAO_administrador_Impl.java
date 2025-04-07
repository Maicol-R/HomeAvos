package DAO_AD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Modelo.administrador;
import conexion.Conexion;

public class DAO_administrador_Impl extends Conexion implements DAO_Administrador{

	
	@Override
	public void registrar(administrador a) throws Exception {
		// TODO Auto-generated method stub
		
            PreparedStatement st = this.getConexion().prepareStatement("Insert into usuario values (?,?,?,?,?)");
            PreparedStatement st2  = this.getConexion().prepareStatement("insert into administrador values(?,?,?,?,?,?)");
            
            st.setLong(1, a.getCod());
            st.setLong(2, a.getTelefono());
            st.setString(3, a.getDirección());
            st.setString(4, a.getCorreo());
            st.setString(5, a.getContraseña());
            
            st2.setLong(1, a.getDocumentoAd());
            st2.setString(2, a.getTipoDocumento());
            st2.setString(3, a.getFechaExpe());
            st2.setString(4, a.getNombres());
            st2.setString(5, a.getApellidos());
            st2.setString(6, a.getCiudad());
            
            
            st.executeUpdate();
            st2.executeUpdate();
            

	}

	@Override
	public void modificar(administrador a) throws Exception {
		// TODO Auto-generated method stub
		
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE usuario "+"SET Telefono = ?, Direccion = ?, "
            		                                                   + "Correo = ?, Contraseña = ? "+"WHERE Cod_datos = ?");
            st.setLong(1, a.getTelefono());
            st.setString(2, a.getDirección());
            st.setString(3, a.getCorreo());
            st.setString(4, a.getContraseña());
            st.setLong(5, a.getDocumentoAd());
            
            st.executeUpdate();
            
            PreparedStatement st2 = this.getConexion().prepareStatement("UPDATE administrador "+"SET Nombre = ?," 
                                                                       +"Apellido = ?, Ciudad = ? "+"WHERE documento_Admin = ?");    
            st2.setString(1, a.getNombres());
            st2.setString(2, a.getApellidos());
            st2.setNString(3, a.getCiudad());
            st2.setLong(4, a.getDocumentoAd());
            
            st2.executeUpdate();       
       
	}

	
	@Override
	public void eliminar(long doc) throws Exception {
		// TODO Auto-generated method stub
			
            PreparedStatement st2 = this.getConexion().prepareStatement("delete from administrador where documento_Admin=?");
            st2.setLong(1, doc);
            st2.executeUpdate();
            
            PreparedStatement st = this.getConexion().prepareStatement("delete from usuario where Cod_datos=?");
            st.setLong(1, doc);
            st.executeUpdate();
            
            
       
	}

	@Override
	public List<administrador> buscar(long dato) throws Exception {
		// TODO Auto-generated method stub
		
		
		List<administrador> lista = null;
        try {
        	
            PreparedStatement st = null;
            PreparedStatement st2 = null;
            	
            	st = this.getConexion().prepareStatement("select * from usuario where Cod_datos = ?");
                st.setLong(1, dato);
                
                st2 = this.getConexion().prepareStatement("select * from administrador where documento_Admin = ?");
                st2.setLong(1, dato);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            ResultSet rs2 = st2.executeQuery();
            
            while (rs.next() && rs2.next() ) {
                administrador a = new administrador();
                a.setCod(rs.getLong("Cod_datos"));
                a.setTelefono(rs.getLong("Telefono"));
                a.setDirección(rs.getString("Direccion"));
                a.setCorreo(rs.getString("Correo"));
                a.setContraseña(rs.getString("Contraseña"));
                a.setDocumentoAd(rs2.getLong("documento_Admin"));
                a.setTipoDocumento(rs2.getString("Tipo_documento"));
                a.setFechaExpe(rs2.getString("Fecha_expedicion"));
                a.setNombres(rs2.getString("Nombre"));
                a.setApellidos(rs2.getString("Apellido"));
                a.setCiudad(rs2.getString("Ciudad"));
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
	public List<administrador> listar() throws Exception {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object iniciarSesion(String correo, String contr) throws Exception {
		long v=0;
		administrador AD = new administrador();
		
		try{
	                       
	            PreparedStatement estatuto2 = this.getConexion().prepareStatement("select * FROM usuario WHERE Correo = ? and Contraseña = ?");
	            estatuto2.setString(1, correo);
	            estatuto2.setString(2, contr);
	            ResultSet rs2 = estatuto2.executeQuery();
	            
	            if(rs2.next()){
	            AD.setCod(rs2.getLong("Cod_datos"));    
	            AD.setTelefono(rs2.getLong("Telefono"));
	            AD.setDirección(rs2.getString("Direccion"));
	            AD.setCorreo(rs2.getString("Correo"));
	            AD.setContraseña(rs2.getString("Contraseña"));

	            } else { System.out.println();}
	        
	            v=AD.getCod();
	       
	            if(v!=0) {
	            
	               PreparedStatement estatuto = this.getConexion().prepareStatement("select * FROM administrador WHERE documento_Admin = "+v);
	           
	               ResultSet rs = estatuto.executeQuery();
	          
	               if(rs.next()){
	            	 AD.setDocumentoAd(rs.getLong("documento_Admin"));
	                 AD.setTipoDocumento(rs.getString("tipo_Documento"));
	                 AD.setFechaExpe(rs.getString("Fecha_expedicion"));
	                 AD.setNombres(rs.getString("Nombre"));
	                 AD.setApellidos(rs.getString("Apellido"));
	                 AD.setCiudad(rs.getString("Ciudad"));
	            
	                } else { System.out.println();}
	               
	            } else {
	            	
	            }
	            
	        }catch(Exception e){
	            System.out.println("Error "+e);
	            
	 }
		return AD;
	  
	}

	
}
