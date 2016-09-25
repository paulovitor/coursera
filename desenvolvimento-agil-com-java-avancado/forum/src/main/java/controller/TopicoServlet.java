package controller;

import exception.DAOException;
import model.Cadastro;
import model.Forum;
import model.Topico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/topico")
public class TopicoServlet extends HttpServlet {

    private Cadastro cadastro = new Cadastro();
    private Forum forum = new Forum();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("acao") != null && request.getParameter("acao").equals("insere"))
            request.getRequestDispatcher("/WEB-INF/jsp/insere-topico.jsp").forward(request, response);
        else if (request.getParameter("acao") != null && request.getParameter("acao").equals("exibe")) {
            try {
                Topico topico = forum.recuperar(Integer.parseInt(request.getParameter("id")));

                request.setAttribute("topico", topico);
                request.getRequestDispatcher("/WEB-INF/jsp/exibe-topico.jsp").forward(request, response);
            } catch (Exception exception) {
                request.setAttribute("erro", exception.getMessage());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else
            request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = (String) request.getSession().getAttribute("login");
            cadastro.inserir(new Topico(request.getParameter("titulo"), request.getParameter("conteudo"), login));

            List<Topico> topicos = forum.recuperarTopicos(login);
            request.setAttribute("topicos", topicos);

            request.getRequestDispatcher("/WEB-INF/jsp/topicos.jsp").forward(request, response);
        } catch (DAOException exception) {
            request.setAttribute("erro", exception.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
