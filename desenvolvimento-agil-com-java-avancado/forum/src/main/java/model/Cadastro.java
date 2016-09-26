package model;

import dao.*;
import exception.DAOException;

public class Cadastro {

    private ComentarioDAO comentarioDAO = new ComentarioDAOImpl();
    private TopicoDAO topicoDAO = new TopicoDAOImpl();
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public void inserir(Usuario usuario) throws DAOException {
        usuarioDAO.inserir(usuario);
    }

    public void inserir(Topico topico) throws DAOException {
        topicoDAO.inserir(topico);
        usuarioDAO.adicionarPontos(topico.getLogin(), 10);
    }

    public void inserir(Comentario comentario) throws DAOException {
        comentarioDAO.inserir(comentario);
        usuarioDAO.adicionarPontos(comentario.getLogin(), 3);
    }
}
