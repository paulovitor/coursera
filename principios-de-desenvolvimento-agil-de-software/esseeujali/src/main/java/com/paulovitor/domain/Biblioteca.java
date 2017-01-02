package com.paulovitor.domain;

import com.paulovitor.dao.LivroDAO;
import com.paulovitor.dao.LivroDAOImpl;
import com.paulovitor.dao.UsuarioDAO;
import com.paulovitor.dao.UsuarioDAOImpl;
import com.paulovitor.exception.DAOException;

import java.util.List;

public class Biblioteca {

    private static Biblioteca instance;

    private LivroDAO livroDAO = new LivroDAOImpl();
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private Biblioteca() {

    }

    public static Biblioteca get() {
        if (instance == null)
            instance = new Biblioteca();
        return instance;
    }

    public List<Livro> recuperarLivros() throws DAOException {
        return livroDAO.recuperarTodos();
    }

    public Livro recuperarLivro(int id) throws DAOException {
        return livroDAO.recuperar(id);
    }

    public boolean usuarioJaLeuLivro(String login, int idLivro) throws DAOException {
        return usuarioDAO.usuarioJaLeuLivro(login, idLivro);
    }
}
