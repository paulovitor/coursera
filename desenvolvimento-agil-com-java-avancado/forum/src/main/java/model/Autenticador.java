package model;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import exception.DAOException;

public class Autenticador {

    public UsuarioDAO dao = new UsuarioDAOImpl();

    public Usuario autenticar(String login, String senha) throws DAOException {
        Usuario usuario = dao.recuperar(login, senha);
        if (usuario == null) throw new RuntimeException("Login ou senha inválidos!");
        return usuario;
    }
}
