package org.jjoselon.webapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class PostRequestAuthenticatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        /* input:text */
        String userId = req.getParameter("user_id");
        String userPassword = req.getParameter("user_password");
        /* input:select */
        String userLanguage = req.getParameter("user_idioma"); // String[] si es select:multiple
        /* input:checkbox */
        String userStayLogin = req.getParameter("mantener_sesion"); // String[] si son mas de uno
        /* input:radio */
        String userTheme = req.getParameter("tipo_tema");

        try (PrintWriter out = resp.getWriter()) {
            out.println("Usuario: " + userId);
            out.println("Password: " + userPassword);
            out.println("Idioma: " + userLanguage);
            out.println("Mantener sesión: " + userStayLogin);
            out.println("Tema: " + userTheme);
        }
    }
}
