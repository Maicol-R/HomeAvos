package DAO_F;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.familiar;
import Modelo.hogar_geriatrico;
import conexion.Conexion;

public class DAO_familiar_Impl extends Conexion implements DAO_familiar{

	@Override
	public void registrar(familiar a) throws Exception {
		// TODO Auto-generated method stub
		
            PreparedStatement st = this.getConexion().prepareStatement("Insert into Usuario values (?,?,?,?,?)");
            PreparedStatement st2  = this.getConexion().prepareStatement("insert into familiar values(?,?,?,?,?)");
            
            st.setLong(1, a.getCod());
            st.setLong(2, a.getTelefono());
            st.setString(3, a.getDirección());
            st.setString(4, a.getCorreo());
            st.setString(5, a.getContraseña());
            
            st2.setLong(1, a.getDocumentoFam());
            st2.setString(2, a.getTipoDocumento());
            st2.setString(3, a.getNombres());
            st2.setString(4, a.getApellidos());
            st2.setString(5, a.getGenero());
            
            st.executeUpdate();
            st2.executeUpdate();
            
            
		
		
		
		
	}

	@Override
	public void modificar(familiar a) throws Exception {
		// TODO Auto-generated method stub
		
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE usuario "+"SET Telefono = ?, Direccion = ?, "
            		                                                   + "Correo = ?, Contraseña = ? "+"WHERE Cod_datos = ?");
            st.setLong(1, a.getTelefono());
            st.setString(2, a.getDirección());
            st.setString(3, a.getCorreo());
            st.setString(4, a.getContraseña());
            st.setLong(5, a.getDocumentoFam());
            
            st.executeUpdate();
            
            PreparedStatement st2 = this.getConexion().prepareStatement("UPDATE familiar "+"SET Nombre = ?," 
                                                                       +"Apellido = ? "+"WHERE documento_Fam = ?");    
            st2.setString(1, a.getNombres());
            st2.setString(2, a.getApellidos());
            st2.setLong(3, a.getDocumentoFam());
            
            st2.executeUpdate();       
       
	}

	
	@Override
	public void eliminar(long doc) throws Exception {
		// TODO Auto-generated method stub
			
		PreparedStatement st5 = this.getConexion().prepareStatement("delete valoracion_hg where documento_Fam=?");
        st5.setLong(1, doc);
        st5.executeUpdate();  
		
		PreparedStatement st4 = this.getConexion().prepareStatement("delete from info_postulacion where documento_Fam=?");
           st4.setLong(1, doc);
           st4.executeUpdate();
		
           PreparedStatement st3 = this.getConexion().prepareStatement("delete from adulto_mayor where documento_Fam=?");
           st3.setLong(1, doc);
           st3.executeUpdate();
           
            PreparedStatement st2 = this.getConexion().prepareStatement("delete from familiar where documento_Fam=?");
            st2.setLong(1, doc);
            st2.executeUpdate();
            
            PreparedStatement st = this.getConexion().prepareStatement("delete from usuario where Cod_datos=?");
            st.setLong(1, doc);
            st.executeUpdate();
            
            
       
	}

	@Override
	public List<familiar> buscar(long dato) throws Exception {
		// TODO Auto-generated method stub
		
		
		List<familiar> lista = null;
        try {
        	
            PreparedStatement st = null;
            PreparedStatement st2 = null;
            	
            	st = this.getConexion().prepareStatement("select * from usuario where Cod_datos = ?");
                st.setLong(1, dato);
                
                st2 = this.getConexion().prepareStatement("select * from familiar where documento_Fam = ?");
                st2.setLong(1, dato);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            ResultSet rs2 = st2.executeQuery();
            
            while (rs.next() && rs2.next() ) {
                familiar a = new familiar();
                a.setCod(rs.getLong("Cod_datos"));
                a.setTelefono(rs.getLong("Telefono"));
                a.setDirección(rs.getString("Direccion"));
                a.setCorreo(rs.getString("Correo"));
                a.setContraseña(rs.getString("Contraseña"));
                a.setDocumentoFam(rs2.getLong("documento_Fam"));
                a.setTipoDocumento(rs2.getString("Tipo_documento"));
                a.setNombres(rs2.getString("Nombre"));
                a.setApellidos(rs2.getString("Apellido"));
                a.setGenero(rs2.getString("Genero"));
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
	public List<familiar> listar() throws Exception {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object iniciarSesion(String correo, String contr) throws Exception {
		long v=0;
		familiar F = new familiar();
		
		try{
	                       
	            PreparedStatement estatuto2 = this.getConexion().prepareStatement("select * FROM usuario WHERE Correo = ? and Contraseña = ?");
	            estatuto2.setString(1, correo);
	            estatuto2.setString(2, contr);
	            ResultSet rs2 = estatuto2.executeQuery();
	            
	            if(rs2.next()){
	            F.setCod(rs2.getLong("Cod_datos"));    
	            F.setTelefono(rs2.getLong("Telefono"));
	            F.setDirección(rs2.getString("Direccion"));
	            F.setCorreo(rs2.getString("Correo"));
	            F.setContraseña(rs2.getString("Contraseña"));

	            } else { System.out.println();}
	        
	            v=F.getCod();
	       
	            if(v!=0) {
	            
	               PreparedStatement estatuto = this.getConexion().prepareStatement("select * FROM familiar WHERE documento_Fam = "+v);
	           
	               ResultSet rs = estatuto.executeQuery();
	          
	               if(rs.next()){
	            	 F.setDocumentoFam(rs.getLong("documento_fam"));
	                 F.setTipoDocumento(rs.getString("Tipo_documento"));
	                 F.setNombres(rs.getString("Nombre"));
	                 F.setApellidos(rs.getString("Apellido"));
	                 F.setGenero(rs.getString("Genero"));
	            
	                } else { System.out.println();}
	               
	            } else {
	            	
	            }
	            
	        }catch(Exception e){
	            System.out.println("Error "+e);
	            
	 }
		return F;
	  
	}

	
}
