package servlet;

import controller.Controller;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String nomeDaClasse = "controller." + Character.toUpperCase(acao.charAt(0)) + acao.substring(1) + "UsuarioController";

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Controller instance = (Controller) classe.newInstance();

            instance.executar(request, response);

        } catch (Exception exception) {
            request.setAttribute("erro", exception.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            Cadastro.get().inserir(new Usuario(request.getParameter("login"), request.getParameter("email"), request.getParameter("nome"), request.getParameter("senha"), 0));
            request.setAttribute("mensagem", "Cadastro realizado com sucesso!");

        } catch (DAOException exception) {
            request.setAttribute("erro", exception.getMessage());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
