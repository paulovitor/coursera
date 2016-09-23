package dao;

import exception.DAOException;
import model.Usuario;

public interface UsuarioDAO {

    void inserir(Usuario usuario) throws DAOException;

    Usuario recuperar(String login, String senha) throws DAOException;
}
