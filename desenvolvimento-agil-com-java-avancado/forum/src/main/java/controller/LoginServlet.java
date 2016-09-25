package controller;

import model.Autenticador;
import model.Forum;
import model.Topico;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Autenticador autenticador = new Autenticador();
    private Forum forum = new Forum();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Usuario usuario = autenticador.autenticar(request.getParameter("login"), request.getParameter("senha"));
            request.setAttribute("nome", usuario.getNome());

            String login = usuario.getLogin();
            request.getSession().setAttribute("login", login);

            List<Topico> topicos = forum.recuperarTopicos(login);
            request.setAttribute("topicos", topicos);

            request.getRequestDispatcher("/WEB-INF/jsp/topicos.jsp").forward(request, response);
        } catch (Exception exception) {
            request.setAttribute("erro", exception.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
