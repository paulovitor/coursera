package controller;

import model.Autenticador;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Autenticador autenticador = new Autenticador();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Usuario usuario = autenticador.autenticar(request.getParameter("login"), request.getParameter("senha"));
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/WEB-INF/jsp/topicos.jsp").forward(request, response);
        } catch (Exception exception) {
            request.setAttribute("erro", exception.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
