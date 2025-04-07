/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsF;

import Modelo.familiar;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_F.DAO_familiar_Impl;

/**
 *
 * @author DeividAlexcander
 */
 @WebServlet("/registra_familiar")
public class registra_familiar extends HttpServlet {

    /**
	 * 
	 */

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
            /* TODO output your page here. You may use following sample code. */
        	long nDoc=Long.parseLong(request.getParameter("NdocumentoFam"));
        	String tipoDoc=request.getParameter("tipoDocFam");
        	String nom=request.getParameter("nombreFam");
    		String apll=request.getParameter("apellidoFam");
    		String gen=request.getParameter("sexoFam");
    		long tel=Long.parseLong(request.getParameter("celularFam"));
    		String dir=request.getParameter("direccionFam");
    		String correo=request.getParameter("correoFam");
    		String contr=request.getParameter("contraFam");
    		
    		familiar ob=new familiar(nDoc,tel,dir,correo,contr,nDoc,tipoDoc,nom,apll,gen);
    		
            try{
            a.registrar(ob);
            String alert2="Registro Exitoso";
        	session.setAttribute("alertB", alert2);
        	String alert="Inicia sesión para continuar";
        	session.setAttribute("alertB2", alert);
            }
            catch(Exception e){
            	String alert="ERROR no se pudo completar el registro";
            	session.setAttribute("alertE", alert);
            System.out.print("Error en REGISTRAR "+e.getMessage());
            }
        } catch(Exception e){
        	String alert="ERROR no se pudo completar el registro";
        	session.setAttribute("alertE", alert);
            System.out.println("ERROR en SERVLET Registrar "+e);
            } finally {
            
            }
     
        RequestDispatcher r = request.getRequestDispatcher("Principal.jsp");
        r.forward(request, response);
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
