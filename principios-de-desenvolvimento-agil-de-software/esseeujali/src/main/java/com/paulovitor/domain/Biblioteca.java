package com.paulovitor.domain;

import com.paulovitor.dao.LivroDAO;
import com.paulovitor.dao.LivroDAOImpl;
import com.paulovitor.exception.DAOException;

import java.util.List;

public class Biblioteca {

    private static Biblioteca instance;

    private LivroDAO livroDAO = new LivroDAOImpl();

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
}
