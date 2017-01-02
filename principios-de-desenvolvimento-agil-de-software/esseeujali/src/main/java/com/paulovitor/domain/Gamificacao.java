package com.paulovitor.domain;

import com.paulovitor.dao.UsuarioDAO;
import com.paulovitor.dao.UsuarioDAOImpl;
import com.paulovitor.exception.DAOException;

public class Gamificacao {

    private static Gamificacao instance;

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private Gamificacao() {

    }

    public static Gamificacao get() {
        if (instance == null)
            instance = new Gamificacao();
        return instance;
    }

    public void marcarLivroComoLidoPorUsuario(Livro livro, String login) throws DAOException {
        usuarioDAO.marcarLivroComoLido(livro.getId(), login);
        usuarioDAO.marcarPontos(livro.getPaginas() / 100, login);
    }

    public void desmarcarLivroComoLidoPorUsuario(Livro livro, String login) throws DAOException {
        usuarioDAO.desmarcarLivroComoLido(livro.getId(), login);
        usuarioDAO.desmarcarPontos(livro.getPaginas() / 100, login);
    }
}
