package controller;

import model.Forum;
import model.Topico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListaTopicoController implements Controller {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = (String) request.getSession().getAttribute("login");

        List<Topico> topicos = Forum.get().recuperarTopicos(login);
        request.setAttribute("topicos", topicos);

        request.getRequestDispatcher("/WEB-INF/jsp/topicos.jsp").forward(request, response);
    }
}
