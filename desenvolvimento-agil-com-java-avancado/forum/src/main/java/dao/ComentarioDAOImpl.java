package dao;

import exception.DAOException;
import model.Comentario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAOImpl extends AbstractDAO implements ComentarioDAO {

    @Override
    public List<Comentario> recuperarComentarios(int topicoId) throws DAOException {
        List<Comentario> comentarios = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM comentario WHERE id_topico = ? ORDER BY comentario";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, topicoId);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                comentarios.add(criar(resultSet));
            }

        } catch (SQLException exception) {
            throw new DAOException("Erro ao recuperar tópicos por login!", exception);
        }

        return comentarios;
    }

    @Override
    public void inserir(Comentario comentario) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, comentario.getComentario());
            prepareStatement.setString(2, comentario.getLogin());
            prepareStatement.setInt(3, comentario.getTopicoId());
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new DAOException("Erro ao inserir comentário!", exception);
        }
    }

    private Comentario criar(ResultSet resultSet) throws SQLException {
        return new Comentario(resultSet.getInt("id_comentario"), resultSet.getString("comentario"),
                resultSet.getString("login"), resultSet.getInt("id_topico"));
    }
}
