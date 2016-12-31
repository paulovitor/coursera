package model;

import dao.*;
import exception.DAOException;

public class Cadastro {

    private static Cadastro instance;

    private ComentarioDAO comentarioDAO = new ComentarioDAOImpl();
    private TopicoDAO topicoDAO = new TopicoDAOImpl();
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private Cadastro() {

    }

    public static Cadastro get() {
        if (instance == null)
            instance = new Cadastro();
        return instance;
    }

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
