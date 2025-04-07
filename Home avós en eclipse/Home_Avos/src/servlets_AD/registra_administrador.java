/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets_AD;

import Modelo.administrador;
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

import DAO_AD.DAO_administrador_Impl;

/**
 *
 * 
 */
 @WebServlet("/registra_administrador")
public class registra_administrador extends HttpServlet {

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
        DAO_administrador_Impl a=new DAO_administrador_Impl(); 
        
        try {
            /* TODO output your page here. You may use following sample code. */
        	long nDoc=Long.parseLong(request.getParameter("NdocAD"));
        	String tipoDoc=request.getParameter("tipoDocAD");
        	String fecha=request.getParameter("fechaAD");
        	String nom=request.getParameter("nombreAD");
    		String apll=request.getParameter("apellidoAD");
    		long tel=Long.parseLong(request.getParameter("celularAD"));
    		String ciudad=request.getParameter("ciudadAD");
    		String dir=request.getParameter("direccionAD");
    		String correo=request.getParameter("correoAD");
    		String contr=request.getParameter("contraAD");
    		
    		administrador ob=new administrador(nDoc,tel,dir,correo,contr,nDoc,tipoDoc,fecha,nom,apll,ciudad);
    		
            try{
            a.registrar(ob);
            String alert="Usuario ADMINISTRADOR registrado EXITOSAMENTE\nInicia sesión para continuar";
        	session.setAttribute("alert", alert);
            }
            catch(Exception e){
            	String alert="ERROR no se pudo completar el registro";
            	session.setAttribute("alert", alert);
            System.out.print("Error en REGISTRAR "+e.getMessage());
            }
        } catch(Exception e){
        	String alert="ERROR no se pudo completar el registro";
        	session.setAttribute("alert", alert);
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
