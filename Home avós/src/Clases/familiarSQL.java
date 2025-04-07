/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DeividAlexander
 */
public class familiarSQL extends conexion{
    
private Familiar a=null;

public void registrar (Familiar a){
try {
        
        ////estatuto
        PreparedStatement estatuto = this.getCnx().prepareStatement("Insert into usuario values (?,?,?,?,?)");
        PreparedStatement estatuto2 = this.getCnx().prepareStatement("Insert into familiar values (?,?,?,?,?,?)");
       
        estatuto.setString(1, a.getCod());
        estatuto.setString(2, a.getTelefono());
        estatuto.setString(3, a.getDirección());
        estatuto.setString(4, a.getCorreo());
        estatuto.setString(5, a.getContraseña());
        
        estatuto2.setString(1, a.getNmDocumento());
        estatuto2.setString(2, a.getTipoDocumento());
        estatuto2.setString(3, a.getNombre());
        estatuto2.setString(4, a.getApellido());
        estatuto2.setString(5, a.getGenero());
        estatuto2.setString(6, a.getCod());
        
        estatuto.executeUpdate();
        estatuto2.executeUpdate();
        
        
        JOptionPane.showMessageDialog(null, "El usuario fue REGISTRADO exitosamente");
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> "+e.getMessage());
        }


}    
 
//////////////////////////////////////////////////////////////////////////////////////////

public void modificar(String cel, String dir, String correo, String contra, String doc){

    try {
        
        
        PreparedStatement estatuto1 = this.getCnx().prepareStatement("UPDATE usuario "+"SET Telefono = ?, Direccion = ?, Correo = ?, Contraseña = ? "+"WHERE Cod_datos = ?");
         
        estatuto1.setString(1, cel);
        estatuto1.setString(2, dir);
        estatuto1.setString(3, correo);
        estatuto1.setString(4, contra);
        estatuto1.setString(5, doc);
        
        estatuto1.executeUpdate();
      

        JOptionPane.showMessageDialog(null, "Los datos fuerón ACTUALIZADOS exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar datos... "+e.getMessage());
        }


}

///////////////////////////////////////////////////////////////////////////////////

public void Consulta(String condi, String condi2){
    
    String tp ="",nd ="",nb ="",ap ="",gn ="",code ="",tel ="",dir ="",corr ="",con ="";
      
        try{
            
           PreparedStatement estatuto = this.getCnx().prepareStatement("select * FROM familiar WHERE Numero_documento = ? ");
           estatuto.setString(1, condi);
           ResultSet rs = estatuto.executeQuery();
          
            if(rs.next()){
            nd =(rs.getString("Numero_documento"));
            tp =(rs.getString("Tipo_documento"));
            nb =(rs.getString("Nombre"));
            ap =(rs.getString("Apellido"));
            gn =(rs.getString("Genero"));
            code =(rs.getString("Cod_datos"));
            } else { System.out.println(nb+" este nombre");}
            
            PreparedStatement estatuto2 = this.getCnx().prepareStatement("select * FROM usuario WHERE cod_datos = ? and Contraseña = ?");
            estatuto2.setString(1, condi);
            estatuto2.setString(2, condi2);
            ResultSet rs2 = estatuto2.executeQuery();
            
            if(rs2.next()){
            tel =(rs2.getString("Telefono"));
            dir =(rs2.getString("Direccion"));
            corr =(rs2.getString("Correo"));
            con =(rs2.getString("Contraseña"));
            } else { System.out.println();}
        
            
            a = new Familiar (nd,tp,nb,ap,gn,code,tel,dir,corr,con);
        }catch(Exception e){
            System.out.println("error de lista "+e);
 }
  
}

public Familiar getFamiliar(){
    return a;
}



////////////////////////////////////////////
public void eliminar (String Numero_documento) {
try {
       String f=Numero_documento; 
        ////estatuto
       
        PreparedStatement estatuto = this.getCnx().prepareStatement("delete from familiar where Numero_documento =?");
        estatuto.setString(1,Numero_documento);
        estatuto.executeUpdate();
        
        PreparedStatement estatuto2 = this.getCnx().prepareStatement("delete from usuario where Cod_datos =?");
        estatuto2.setString(1,Numero_documento);
        estatuto2.executeUpdate();
       
        JOptionPane.showMessageDialog(null, "El usuario "+f+" fue ELIMINADO exitosamente");
        
        
}catch (SQLException e){
    
   
    System.out.println("Error eliminando"+e.getMessage());
    
}
      
}
/////////////////////////////////////////////
public List <Familiar> listar (){
List<Familiar> lista=new ArrayList();

    try {
      
    PreparedStatement estatuto=this.getCnx().prepareStatement("select * FROM familiar"); 
    PreparedStatement estatuto2=this.getCnx().prepareStatement("select * FROM usuario");
  
   
      
        ResultSet rs = estatuto.executeQuery();
        ResultSet rs2 = estatuto2.executeQuery();
        
            while(rs.next() && rs2.next()){
            Familiar a=new Familiar();
                
            a.setNmDocumento((rs.getString("Numero_documento")));
            a.setTipoDocumento(rs.getString("Tipo_documento"));
            a.setNombre(rs.getString("Nombre"));
            a.setApellido(rs.getString("Apellido"));
            a.setGenero(rs.getString("Genero"));
            a.setCod(rs.getString("Cod_datos"));
            
            a.setTelefono(rs2.getString("Telefono"));
            a.setDirección(rs2.getString("Direccion"));
            a.setCorreo(rs2.getString("Correo"));
            a.setContraseña(rs2.getString("Contraseña"));
            
            lista.add(a);
            } 
            rs.close();
            estatuto.close();
            rs2.close();
            estatuto2.close();
            
    } catch (Exception e) {
        System.out.println("Error en lista --> "+e);
    }



return lista;
}
    
    
}


