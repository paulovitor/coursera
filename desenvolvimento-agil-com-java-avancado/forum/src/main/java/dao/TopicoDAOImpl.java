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
    public List<Topico> recuperar(String login) throws DAOException {
        List<Topico> topicos = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM topico WHERE login = ? ORDER BY titulo";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, login);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                topicos.add(new Topico(resultSet.getInt("id_topico"), resultSet.getString("titulo"),
                        resultSet.getString("conteudo"), resultSet.getString("login")));
            }

        } catch (SQLException exception) {
            throw new DAOException("Erro ao recuperar tópicos por login!", exception);
        }

        return topicos;
    }
}
