package model;

import dao.*;
import exception.DAOException;

import java.util.List;

public class Forum {

    private ComentarioDAO comentarioDAO = new ComentarioDAOImpl();
    private TopicoDAO topicoDAO = new TopicoDAOImpl();
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public List<Topico> recuperarTopicos(String usuarioLogin) throws DAOException {
        return topicoDAO.recuperarTopicos(usuarioLogin);
    }

    public Topico recuperar(int id) throws DAOException {
        return topicoDAO.recuperar(id);
    }

    public List<Comentario> recuperarComentarios(int topicoId) throws DAOException {
        return comentarioDAO.recuperarComentarios(topicoId);
    }

    public List<Usuario> ranking() throws DAOException {
        return usuarioDAO.ranking();
    }
}
