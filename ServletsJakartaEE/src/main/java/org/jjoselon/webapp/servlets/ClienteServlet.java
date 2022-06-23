package org.jjoselon.webapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String clientId = req.getParameter("clientId");

        out.print("<html>");
        out.print("<body>");
        out.print("Hola cliente " + clientId);
        out.print("</body>");
        out.print("</html>");

        out.close();
    }
}
