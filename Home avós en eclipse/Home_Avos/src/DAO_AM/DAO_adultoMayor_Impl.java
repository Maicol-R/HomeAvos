package DAO_AM;

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

public class DAO_adultoMayor_Impl extends Conexion implements DAO_adultoMayor{

	@Override
	public void registrar(adulto_mayor a) throws Exception {
        
        ////estatuto
   
            PreparedStatement st = this.getConexion().prepareStatement("Insert into adulto_mayor values (?,?,?,?,?,?,?,?,?)");
          
            st.setLong(1, a.getNumDocumento());
            st.setLong(2, a.getDocumento_Fam());
            st.setString(3, a.getTipoDocumento());
            st.setString(4, a.getNombres());
            st.setString(5, a.getApellidos());
            st.setString(6, a.getRh());
            st.setString(7, a.getGenero());
            st.setString(8, a.getFechaNac());
            st.setString(9, a.getCuidadosEspeciales());
            
            st.executeUpdate();
            
		
}
	

	@Override
	public void modificar(adulto_mayor a) throws Exception {
		// TODO Auto-generated method stub
		
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE adulto_mayor "+"SET Nombre = ?, Apellido = ?, "
            		                                                   + "RH = ?, Genero = ?, Fecha_nacimiento = ?, Cuidados_especiales = ? "
            		                                                   +"WHERE documento_AM = ?");
            
            st.setString(1, a.getNombres());
            st.setString(2, a.getApellidos());
            st.setString(3, a.getRh());
            st.setString(4, a.getGenero());
            st.setString(5, a.getFechaNac());
            st.setString(6, a.getCuidadosEspeciales());
            st.setLong(7, a.getNumDocumento());
            
            st.executeUpdate();
            
	}

	@Override
	public void eliminar(long Ndoc) throws Exception {
		// TODO Auto-generated method stub

		PreparedStatement st2 = this.getConexion().prepareStatement("delete from info_postulacion where documento_AM=?");
           st2.setLong(1, Ndoc);
           st2.executeUpdate();
        	
		PreparedStatement st = this.getConexion().prepareStatement("delete from adulto_mayor where documento_AM=?");
            st.setLong(1, Ndoc);
            st.executeUpdate();
            
    
       
	}

	@Override
	public List<adulto_mayor> buscar(long dato) throws Exception {

		List<adulto_mayor> lista = null;
        try {
        	
            PreparedStatement st = null;
            	
            	st = this.getConexion().prepareStatement("select * from adulto_mayor where documento_AM = ?");
                st.setLong(1, dato);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                adulto_mayor a = new adulto_mayor();
                a.setNumDocumento(rs.getLong("documento_AM"));
                a.setTipoDocumento(rs.getString("Tipo_documento"));
                a.setNombres(rs.getString("Nombre"));
                a.setApellidos(rs.getString("Apellido"));
                a.setRh(rs.getString("RH"));
                a.setGenero(rs.getString("Genero"));
                a.setFechaNac(rs.getString("Fecha_nacimiento"));
                a.setCuidadosEspeciales(rs.getString("Cuidados_especiales"));
                
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
	public List<adulto_mayor> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
}
