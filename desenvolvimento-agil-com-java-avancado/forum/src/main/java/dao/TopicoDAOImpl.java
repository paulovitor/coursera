package dao;

import exception.DAOException;
import model.Topico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicoDAOImpl extends BaseDAO implements TopicoDAO {

    @Override
    public List<Topico> recuperarTopicos(String login) throws DAOException {
        List<Topico> topicos = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM topico WHERE login = ? ORDER BY titulo";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, login);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                topicos.add(criar(resultSet));
            }

        } catch (SQLException exception) {
            throw new DAOException("Erro ao recuperar tópicos por login!", exception);
        }

        return topicos;
    }

    @Override
    public void inserir(Topico topico) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, topico.getTitulo());
            prepareStatement.setString(2, topico.getConteudo());
            prepareStatement.setString(3, topico.getLogin());
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new DAOException("Erro ao inserir usuário!", exception);
        }
    }

    @Override
    public Topico recuperar(int id) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM topico WHERE id_topico = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) return criar(resultSet);

        } catch (SQLException exception) {
            throw new DAOException("Erro ao recuperar tópico!", exception);
        }

        return null;
    }

    private Topico criar(ResultSet resultSet) throws SQLException {
        return new Topico(resultSet.getInt("id_topico"), resultSet.getString("titulo"),
                resultSet.getString("conteudo"), resultSet.getString("login"));
    }
}
