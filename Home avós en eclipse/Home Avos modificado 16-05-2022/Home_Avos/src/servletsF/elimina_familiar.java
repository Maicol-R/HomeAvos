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

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO_F.DAO_familiar_Impl;
import DAO_HG.DAO_hogarGeriatrico_Impl;
import Modelo.familiar;

/**
 *
 * @author DeividAlexander
 */
@WebServlet("/elimina_familiar")
public class elimina_familiar extends HttpServlet {

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
    	PrintWriter out = response.getWriter();
     DAO_familiar_Impl a=new DAO_familiar_Impl();        
        try {
        	long doc=Long.parseLong(request.getParameter("nDocF"));
    		
        		List <familiar> busqueda = new ArrayList(a.buscar(doc));
        		long cond=0;
        		cond=busqueda.get(0).getDocumentoFam();
        		
        			a.eliminar(doc);
                    String alert="Usuario "+busqueda.get(0).getNombres()+" "+busqueda.get(0).getApellidos()+" eliminado EXITOSAMENTE";
                	session.setAttribute("alert", alert);
                	RequestDispatcher r = request.getRequestDispatcher("F_index_CRUD.jsp");
                    r.forward(request, response);
        		
       
            } catch(Exception e){
            	String alert="ERROR el n�mero de documento no es v�lido";
            	session.setAttribute("alert", alert);
            	System.out.println("Error "+e);
            	RequestDispatcher r = request.getRequestDispatcher("F_eliminar.jsp");
                r.forward(request, response);
                } finally {
                	
                }
            
         
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
        processRequest(request, response);
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
