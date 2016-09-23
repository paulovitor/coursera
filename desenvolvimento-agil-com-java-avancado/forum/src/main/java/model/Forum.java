package model;

import dao.TopicoDAO;
import dao.TopicoDAOImpl;
import exception.DAOException;

import java.util.List;

public class Forum {

    TopicoDAO dao = new TopicoDAOImpl();

    public List<Topico> recuperarTopicos(String usuarioLogin) throws DAOException {
        return dao.recuperar(usuarioLogin);
    }
}
