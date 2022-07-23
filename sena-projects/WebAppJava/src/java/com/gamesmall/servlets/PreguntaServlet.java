/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesmall.servlets;

import com.gamesmall.daos.PreguntaDao;
import com.gamesmall.entities.Pregunta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamesmall.mysql.connection.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "PreguntaServlet", urlPatterns = {"/pregunta"}, initParams = {
    @WebInitParam(name = "param1", value = "valueparam1")})
public class PreguntaServlet extends HttpServlet {

    final private Connection connObj = new Connection();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PreguntaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PreguntaServlet at " + request.getContextPath() + "with method" + request.getMethod() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
        //java.sql.Connection connection = connObj.getConnection();
        PreguntaDao preguntaDAO = new PreguntaDao();
        ResultSet rs = preguntaDAO.obtenerTodas();
        try {
            Pregunta pregunta = new Pregunta();
            while (rs.next()) {
                pregunta.setId(rs.getInt("idpregunta"));
                pregunta.setEnunciado(rs.getString("EnunciadoPregunta"));
                pregunta.setValor(rs.getInt("ValorPregunta"));
                listaPreguntas.add(pregunta);
                pregunta = new Pregunta();
            }
        } catch (SQLException se) {
            System.out.println("An exception has ocurred on doGet" + se.getMessage());
        }
        
        String json = new Gson().toJson(listaPreguntas);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        processRequest(req, resp);
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
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>" + request.getMethod() + "</h1>");
        }
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
