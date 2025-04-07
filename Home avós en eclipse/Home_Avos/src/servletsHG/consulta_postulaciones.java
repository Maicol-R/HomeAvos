/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsHG;

import Modelo.hogar_geriatrico;
import Modelo.info_postulacion;
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

import DAO_HG.DAO_hogarGeriatrico_Impl;
import DAO_infoP.DAO_infoPostulacion_Impl;


/**
 *
 * @author DeividAlexcander
 */
 @WebServlet("/consulta_postulaciones")
public class consulta_postulaciones extends HttpServlet {

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
        DAO_hogarGeriatrico_Impl a=new DAO_hogarGeriatrico_Impl(); 
        List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)(session.getAttribute("datosHG"));
        
        DAO_infoPostulacion_Impl s=new DAO_infoPostulacion_Impl();
       
        
        try {
            /* TODO output your page here. You may use following sample code. */
        	
        	long codPost=Long.parseLong(request.getParameter("codPost"));
        	ArrayList<info_postulacion> infoP = (ArrayList<info_postulacion>)(s.buscarPostEspecificas(codPost));
        	System.out.println(infoP.get(0).getDoc_familiar());
        	session.setAttribute("infoP", infoP);
    		RequestDispatcher r = request.getRequestDispatcher("HG_info_postulacion.jsp");
            r.forward(request, response);
            
        } catch(Exception e){
        	
            System.out.println("ERROR en SERVLET mostrar info de postulaciones "+e);
            RequestDispatcher r = request.getRequestDispatcher("HG_postulaciones.jsp");
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
