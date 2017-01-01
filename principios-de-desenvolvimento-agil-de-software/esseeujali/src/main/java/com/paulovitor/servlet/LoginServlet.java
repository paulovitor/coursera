package com.paulovitor.servlet;

import com.paulovitor.domain.Autenticador;
import com.paulovitor.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Usuario usuario = Autenticador.get().autenticar(request.getParameter("login"), request.getParameter("senha"));
            request.setAttribute("nome", usuario.getNome());

            String login = usuario.getLogin();
            request.getSession().setAttribute("login", login);

            response.sendRedirect("livro?acao=lista");

        } catch (Exception exception) {
            request.setAttribute("erro", exception.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
