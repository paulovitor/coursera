package model;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import exception.DAOException;

public class Cadastro {

    UsuarioDAO dao = new UsuarioDAOImpl();

    public void inserir(Usuario usuario) throws DAOException {
        dao.inserir(usuario);
    }
}
