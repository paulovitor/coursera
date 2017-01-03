package com.paulovitor.domain;

import com.paulovitor.dao.UsuarioDAO;
import com.paulovitor.dao.UsuarioDAOImpl;
import com.paulovitor.exception.DAOException;

import java.util.List;

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
        usuarioDAO.marcarPontos(1 + livro.getPaginas() / 100, login);

        String estilo = livro.getEstilo();
        int quantidade = usuarioDAO.contarLivrosLidoDeUmEstilo(login, estilo);
        if (quantidade >= 5 && !usuarioDAO.temTrofeu(login, estilo)) {
            usuarioDAO.adicionarTrofeu(login, estilo);
        }
    }

    public void desmarcarLivroComoLidoPorUsuario(Livro livro, String login) throws DAOException {
        usuarioDAO.desmarcarLivroComoLido(livro.getId(), login);
        usuarioDAO.desmarcarPontos(1 + livro.getPaginas() / 100, login);

        String estilo = livro.getEstilo();
        int quantidade = usuarioDAO.contarLivrosLidoDeUmEstilo(login, estilo);
        if (quantidade < 5 && usuarioDAO.temTrofeu(login, estilo)) {
            usuarioDAO.removerTrofeu(login, estilo);
        }
    }

    public List<Usuario> ranking() throws DAOException {
        return usuarioDAO.ranking();
    }
}
