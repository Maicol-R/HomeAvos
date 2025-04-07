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
import Modelo.familiar;
import Modelo.hogar_geriatrico;


/**
 *
 * @author DeividAlexander
 */
@WebServlet("/modifica_hogarGeriatrico")
public class modifica_hogarGeriatrico extends HttpServlet {

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
        	long nit=Long.parseLong(request.getParameter("nitHG"));
    		String rep=request.getParameter("representanteHG");
    		String tipo=request.getParameter("tipoDocHG");
    		long num=Long.parseLong(request.getParameter("NdocHG"));
    		String nom=request.getParameter("nombreResHG");
    		long tel=Long.parseLong(request.getParameter("NcontactoHG"));
    		long tel2=Long.parseLong(request.getParameter("Ncontacto2HG"));
    		String direc=request.getParameter("direccionHG");
    		String ciu=request.getParameter("ciudadHG");
    		String cor=request.getParameter("correoHG");
    		String cl=request.getParameter("contraHG");
    		String des=request.getParameter("descrp");
    		String desC=request.getParameter("descrp-corta");
    		
    		hogar_geriatrico ob=new hogar_geriatrico(nit,tel,direc,cor,cl,nit,rep,tipo,num,nom,tel2,ciu,des,desC);
    		
    	
    		List <hogar_geriatrico> busqueda = new ArrayList(a.buscar(nit));
    		long cond=0;
    		cond=busqueda.get(0).getNit();
    		
    			a.modificar(ob);
                String alert="Datos actualizados EXITOSAMENTE";
            	session.setAttribute("alert", alert);
            	RequestDispatcher r = request.getRequestDispatcher("HG_index_CRUD.jsp");
                r.forward(request, response); 
                
            }catch(Exception e){
            	String alert="ERROR no se pudo ACTUALIZAR correctamente los datos";
            	session.setAttribute("alert", alert);
                System.out.println("Error "+e);
                RequestDispatcher r = request.getRequestDispatcher("HG_modificar.jsp");
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
