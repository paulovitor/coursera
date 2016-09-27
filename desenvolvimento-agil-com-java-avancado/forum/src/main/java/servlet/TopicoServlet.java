package servlet;

import controller.Controller;
import exception.DAOException;
import model.Cadastro;
import model.Topico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/topico")
public class TopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String nomeDaClasse = "controller." + Character.toUpperCase(acao.charAt(0)) + acao.substring(1) + "TopicoController";

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
            String login = (String) request.getSession().getAttribute("login");
            Cadastro.get().inserir(new Topico(request.getParameter("titulo"), request.getParameter("conteudo"), login));

            response.sendRedirect("topico?acao=lista");

        } catch (DAOException exception) {
            request.setAttribute("erro", exception.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
