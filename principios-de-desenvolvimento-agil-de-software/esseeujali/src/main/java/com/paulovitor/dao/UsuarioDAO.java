package com.paulovitor.dao;

import com.paulovitor.domain.Usuario;
import com.paulovitor.exception.DAOException;

public interface UsuarioDAO {

    Usuario recuperar(String login, String senha) throws DAOException;
}
