package dao;

import exception.DAOException;
import model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void inserir(Usuario usuario) throws DAOException;

    Usuario recuperar(String login, String senha) throws DAOException;

    void adicionarPontos(String login, int pontos);

    List<Usuario> ranking() throws DAOException;
}
