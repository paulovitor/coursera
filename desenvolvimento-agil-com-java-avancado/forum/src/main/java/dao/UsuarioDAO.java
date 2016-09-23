package dao;

import exception.DAOException;
import model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void inserir(Usuario usuario) throws DAOException;

    Usuario recuperar(String login, String senha) throws DAOException;

    List<Usuario> recuperarTodos() throws DAOException;
}
