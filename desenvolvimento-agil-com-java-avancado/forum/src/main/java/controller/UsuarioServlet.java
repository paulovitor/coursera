package controller;

import exception.DAOException;
import model.Cadastro;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro")
public class UsuarioServlet extends HttpServlet {

    public Cadastro cadastro = new Cadastro();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            cadastro.inserir(new Usuario(request.getParameter("login"), request.getParameter("email"), request.getParameter("nome"), request.getParameter("senha"), 0));
            request.setAttribute("mensagem", "Cadastro realizado com sucesso!");
        } catch (DAOException e) {
            request.setAttribute("erro", e.getMessage());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
