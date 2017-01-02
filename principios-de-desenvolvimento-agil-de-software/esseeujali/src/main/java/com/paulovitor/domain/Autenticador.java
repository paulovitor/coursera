package com.paulovitor.domain;

import com.paulovitor.dao.UsuarioDAO;
import com.paulovitor.dao.UsuarioDAOImpl;
import com.paulovitor.exception.DAOException;

public class Autenticador {

    private static Autenticador instance;

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private Autenticador() {

    }

    public static Autenticador get() {
        if (instance == null)
            instance = new Autenticador();
        return instance;
    }

    public Usuario autenticar(String login, String senha) throws DAOException {
        Usuario usuario = usuarioDAO.recuperar(login, senha);
        if (usuario == null) throw new RuntimeException("Login ou senha inválidos!");
        return usuario;
    }
}
