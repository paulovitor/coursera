package model;

import dao.TopicoDAO;
import dao.TopicoDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import exception.DAOException;

public class Cadastro {

    UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    TopicoDAO topicoDAO = new TopicoDAOImpl();

    public void inserir(Usuario usuario) throws DAOException {
        usuarioDAO.inserir(usuario);
    }

    public void inserir(Topico topico) throws DAOException {
        topicoDAO.inserir(topico);
    }
}
