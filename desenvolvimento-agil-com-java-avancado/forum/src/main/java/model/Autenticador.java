package model;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import exception.DAOException;

public class Autenticador {

    private static Autenticador instance;

    public UsuarioDAO dao = new UsuarioDAOImpl();

    private Autenticador() {

    }

    public static Autenticador get() {
        if (instance == null)
            instance = new Autenticador();
        return instance;
    }

    public Usuario autenticar(String login, String senha) throws DAOException {
        Usuario usuario = dao.recuperar(login, senha);
        if (usuario == null) throw new RuntimeException("Login ou senha inválidos!");
        return usuario;
    }
}
