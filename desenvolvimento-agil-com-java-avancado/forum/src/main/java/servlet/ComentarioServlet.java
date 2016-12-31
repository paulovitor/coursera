package servlet;

import model.Cadastro;
import model.Comentario;
import model.Forum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/comentario")
public class ComentarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String login = (String) request.getSession().getAttribute("login");
            int topicoId = Integer.parseInt(request.getParameter("topicoId"));

            Cadastro.get().inserir(new Comentario(request.getParameter("comentario"), login, topicoId));
            request.setAttribute("mensagem", "Comentário adicionado com sucesso!");

            List<Comentario> comentarios = Forum.get().recuperarComentarios(topicoId);
            request.setAttribute("comentarios", comentarios);

        } catch (Exception exception) {
            request.setAttribute("erro", exception.getMessage());
        }

        request.getRequestDispatcher("/WEB-INF/jsp/exibe-topico.jsp").forward(request, response);
    }
}
