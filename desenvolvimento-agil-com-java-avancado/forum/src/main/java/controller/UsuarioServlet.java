package controller;

import exception.DAOException;
import model.Cadastro;
import model.Forum;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private Cadastro cadastro = new Cadastro();
    private Forum forum = new Forum();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("acao") != null && request.getParameter("acao").equals("insere"))
            request.getRequestDispatcher("/WEB-INF/jsp/insere-usuario.jsp").forward(request, response);
        else if (request.getParameter("acao") != null && request.getParameter("acao").equals("ranking")) {
            try {
                List<Usuario> usuarios = forum.ranking();
                request.setAttribute("usuarios", usuarios);

                request.getRequestDispatcher("/WEB-INF/jsp/ranking.jsp").forward(request, response);
            } catch (DAOException exception) {
                request.setAttribute("erro", exception.getMessage());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            cadastro.inserir(new Usuario(request.getParameter("login"), request.getParameter("email"), request.getParameter("nome"), request.getParameter("senha"), 0));
            request.setAttribute("mensagem", "Cadastro realizado com sucesso!");
        } catch (DAOException exception) {
            request.setAttribute("erro", exception.getMessage());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
