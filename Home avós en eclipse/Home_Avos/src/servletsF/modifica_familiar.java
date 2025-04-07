/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsF;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_F.DAO_familiar_Impl;
import DAO_HG.DAO_hogarGeriatrico_Impl;
import Modelo.familiar;
import Modelo.hogar_geriatrico;


/**
 *
 * @author DeividAlexander
 */
@WebServlet("/modifica_familiar")
public class modifica_familiar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<familiar> Dfamiliar = (ArrayList<familiar>)session.getAttribute("datosF");
    	PrintWriter out = response.getWriter();
     DAO_familiar_Impl a=new DAO_familiar_Impl();        
        try {
            /* TODO output your page here. You may use following sample code. */
        	long Ndoc=Dfamiliar.get(0).getDocumentoFam();
    		String nom=request.getParameter("nomF");
    		String apll=request.getParameter("apllF");
    		long tel=Long.parseLong(request.getParameter("NcontactoF"));
    		String dir=request.getParameter("direccionF");
    		String correo=request.getParameter("correoF");
    		String contra=request.getParameter("contraF");
            
    		if(nom.equals("") || apll.equals("") || dir.equals("") || correo.equals("") || contra.equals("")) {
    			String alert="ERROR no se pudo ACTUALIZAR correctamente los datos";
            	session.setAttribute("alertE", alert);
            	RequestDispatcher r = request.getRequestDispatcher("F_modificar.jsp");
                r.forward(request, response);    
    		}else {
    		
    		familiar ob=new familiar(Ndoc,tel,dir,correo,contra,Ndoc,nom,apll);
    		
    		List <familiar> busqueda = new ArrayList(a.buscar(Ndoc));
    		long cond=0;
    		cond=busqueda.get(0).getDocumentoFam();
    		
    			a.modificar(ob);
                String alert="Datos actualizados EXITOSAMENTE";
            	session.setAttribute("alertB", alert);
            	
            	Dfamiliar = (List<familiar>)a.buscar(Ndoc);
            	session.setAttribute("datosF", Dfamiliar);
            	
            	RequestDispatcher r = request.getRequestDispatcher("F_index_CRUD.jsp");
                r.forward(request, response);
    		}
            
        }catch(Exception e){
        	String alert="ERROR no se pudo ACTUALIZAR correctamente los datos";
        	session.setAttribute("alertE", alert);
        	System.out.println("Error servlet"+e);
        	RequestDispatcher r = request.getRequestDispatcher("F_modificar.jsp");
            r.forward(request, response);    
        }finally {}
        
        
        }  
        
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
