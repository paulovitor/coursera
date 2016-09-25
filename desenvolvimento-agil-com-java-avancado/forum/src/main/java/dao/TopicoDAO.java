package dao;

import exception.DAOException;
import model.Topico;

import java.util.List;

public interface TopicoDAO {

    List<Topico> recuperarTopicos(String login) throws DAOException;

    void inserir(Topico topico) throws DAOException;

    Topico recuperar(int id) throws DAOException;
}
