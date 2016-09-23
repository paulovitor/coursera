package dao;

import exception.DAOException;
import model.Topico;

import java.util.List;

public interface TopicoDAO {

    List<Topico> recuperar(String login) throws DAOException;
}
