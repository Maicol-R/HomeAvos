/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsHG;

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
import Modelo.hogar_geriatrico;





/**
 *
 * @author DeividAlexander
 */
@WebServlet("/inicioS_hogarGeriatrico")
public class inicioS_hogarGeriatrico extends HttpServlet {

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
    ArrayList <hogar_geriatrico> hogares = new ArrayList();
    DAO_hogarGeriatrico_Impl a = new DAO_hogarGeriatrico_Impl ();
        
        try {
        	
            long nit = Long.parseLong(request.getParameter("nitISHG"));
            String contr =request.getParameter("contraISHG");
            
            request.setAttribute("nit", nit);
            request.setAttribute("contr", contr);
           
           
 	        	hogares.add(0, (hogar_geriatrico) a.iniciarSesion(nit, contr)); 	
 	       
           
            //String n=hogares.get(0).getNom_Residencia();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            String alert="NIT y/o Contraseña INCORRECTOS";
       	 session.setAttribute("alertE", alert);
       	 RequestDispatcher r = request.getRequestDispatcher("/Principal.jsp");
            r.forward(request, response);
        }
        
        if(hogares.get(0).getCod()==0) {
        	 String alert="NIT y/o Contraseña INCORRECTOS";
        	 session.setAttribute("alertE", alert);
        	 RequestDispatcher r = request.getRequestDispatcher("/Principal.jsp");
             r.forward(request, response);
             
        }else {
        	String alert="Usuario Válido";
        	session.setAttribute("alertB", alert);
        	String alert2="Bienvenido(a) "+hogares.get(0).getNom_Residencia();
        	session.setAttribute("alertB2", alert2);
        	session.setAttribute("datosHG", hogares);
            //request.setAttribute("datosHG", HGsession);
            RequestDispatcher r = request.getRequestDispatcher("/HG_index_CRUD.jsp");
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
