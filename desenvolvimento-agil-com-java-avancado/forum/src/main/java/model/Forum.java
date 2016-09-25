package model;

import dao.ComentarioDAO;
import dao.ComentarioDAOImpl;
import dao.TopicoDAO;
import dao.TopicoDAOImpl;
import exception.DAOException;

import java.util.List;

public class Forum {

    private TopicoDAO topicoDAO = new TopicoDAOImpl();
    private ComentarioDAO comentarioDAO = new ComentarioDAOImpl();

    public List<Topico> recuperarTopicos(String usuarioLogin) throws DAOException {
        return topicoDAO.recuperarTopicos(usuarioLogin);
    }

    public Topico recuperar(int id) throws DAOException {
        return topicoDAO.recuperar(id);
    }

    public List<Comentario> recuperarComentarios(int topicoId) throws DAOException {
        return comentarioDAO.recuperarComentarios(topicoId);
    }
}
