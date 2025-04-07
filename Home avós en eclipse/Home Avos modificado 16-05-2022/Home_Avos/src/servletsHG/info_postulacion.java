/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsHG;

import Modelo.hogar_geriatrico;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO_HG.DAO_hogarGeriatrico_Impl;


/**
 *
 * @author DeividAlexcander
 */
 @WebServlet("/info_postulacion")
public class info_postulacion extends HttpServlet {

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
        DAO_hogarGeriatrico_Impl a=new DAO_hogarGeriatrico_Impl(); 
        
        try {
            /* TODO output your page here. You may use following sample code. */
        	long nit=Long.parseLong(request.getParameter("nitHogarG"));
    		String rep=request.getParameter("representanteHogarG");
    		String tipo=request.getParameter("tipoDocHogarG");
    		long num=Long.parseLong(request.getParameter("NdocHogarG"));
    		String nom=request.getParameter("nombreResHogarG");
    		long tel=Long.parseLong(request.getParameter("NcontactoHogarG"));
    		long tel2=Long.parseLong(request.getParameter("Ncontacto2HogarG"));
    		String direc=request.getParameter("direccionHogarG");
    		String ciu=request.getParameter("ciudadHogarG");
    		String cor=request.getParameter("correoHogarG");
    		String cl=request.getParameter("contraHogarG");
    		
    		hogar_geriatrico ob=new hogar_geriatrico(nit,tel,direc,cor,cl,nit,rep,tipo,num,nom,tel2,ciu);
    		
            try{
            a.registrar(ob);
            String alert2="Registro Exitoso";
        	session.setAttribute("alertB", alert2);
        	String alert="Inicia sesi�n para continuar";
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
        //processRequest(request, response);
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
