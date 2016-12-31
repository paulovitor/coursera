package com.paulovitor.dao;

import com.paulovitor.domain.Livro;
import com.paulovitor.exception.DAOException;

import java.util.List;

public interface LivroDAO {

    List<Livro> recuperarTodos() throws DAOException;
}
