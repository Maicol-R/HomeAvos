/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets_AD;

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

import DAO_AD.DAO_administrador_Impl;
import DAO_F.DAO_familiar_Impl;
import DAO_HG.DAO_hogarGeriatrico_Impl;
import Modelo.administrador;
import Modelo.familiar;
import Modelo.hogar_geriatrico;





/**
 *
 * @author DeividAlexander
 */
@WebServlet("/inicioS_administrador")
public class inicioS_administrador extends HttpServlet {

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
    //List<hogar_geriatrico> hogares = (ArrayList<hogar_geriatrico>)HGsession.getAttribute("datosHG");
    ArrayList <administrador> Dadmin = new ArrayList();
    DAO_administrador_Impl a = new DAO_administrador_Impl ();
        
        try {
        	
            String correo = request.getParameter("correoISF");
            String contr =request.getParameter("contraISF");
            
            request.setAttribute("correo", correo);
            request.setAttribute("contr", contr);
           
            System.out.print(correo+" "+contr);
            
            Dadmin.add(0, (administrador) a.iniciarSesion(correo, contr)); 
       	    
        } catch (Exception e) {
            System.out.println("error admin");
            String alert="Usuario y/o Contrase�a INCORRECTOS";
       	    session.setAttribute("alertE", alert);
       	    RequestDispatcher r = request.getRequestDispatcher("/Principal.jsp");
            r.forward(request, response);
        }
        
        if(Dadmin.get(0).getDocumentoAd()!=0) {
        	
        	System.out.println("error admin");
        	String alert="Usuario V�lido";
        	session.setAttribute("alertB", alert);
        	String alert2="Bienvenido(a) ADMINISTRADOR(a) "+Dadmin.get(0).getNombres()+" "+Dadmin.get(0).getApellidos();
        	session.setAttribute("alertB2", alert2);
        	session.setAttribute("imgs", null);
			session.setAttribute("nombre", null);
       	    session.setAttribute("datosAD", Dadmin);
            RequestDispatcher r = request.getRequestDispatcher("/AD_index_CRUD.jsp");
            r.forward(request, response);
        	 
        }else {
        	System.out.println("error admin 2");
        	String alert="Usuario y/o Contrase�a INCORRECTOS";
       	    session.setAttribute("alertE", alert);
       	    RequestDispatcher r = request.getRequestDispatcher("/Principal.jsp");
            r.forward(request, response);
        
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
        doGet(request, response);
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
