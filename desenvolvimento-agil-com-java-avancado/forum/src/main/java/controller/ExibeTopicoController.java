package controller;

import model.Comentario;
import model.Forum;
import model.Topico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ExibeTopicoController implements Controller {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Topico topico = Forum.get().recuperar(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("topico", topico);

        List<Comentario> comentarios = Forum.get().recuperarComentarios(topico.getId());
        request.setAttribute("comentarios", comentarios);

        request.getRequestDispatcher("/WEB-INF/jsp/exibe-topico.jsp").forward(request, response);
    }
}
