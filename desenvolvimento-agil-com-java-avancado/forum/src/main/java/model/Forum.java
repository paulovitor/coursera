package model;

import dao.*;
import exception.DAOException;

import java.util.List;

public class Forum {

    private static Forum instance;

    private ComentarioDAO comentarioDAO = new ComentarioDAOImpl();
    private TopicoDAO topicoDAO = new TopicoDAOImpl();
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private Forum() {

    }

    public static Forum get() {
        if (instance == null)
            instance = new Forum();
        return instance;
    }

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
