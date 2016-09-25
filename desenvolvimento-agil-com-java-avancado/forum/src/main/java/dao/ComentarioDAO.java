package dao;

import exception.DAOException;
import model.Comentario;

import java.util.List;

public interface ComentarioDAO {

    List<Comentario> recuperarComentarios(int topicoId) throws DAOException;

    void inserir(Comentario comentario) throws DAOException;
}
