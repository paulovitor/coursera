package com.paulovitor.dao;

import com.paulovitor.domain.Livro;
import com.paulovitor.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl extends AbstractDAO implements LivroDAO {

    @Override
    public List<Livro> recuperarTodos() throws DAOException {
        List<Livro> livros = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM livro ORDER BY id";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                livros.add(criar(resultSet));
            }

        } catch (SQLException exception) {
            throw new DAOException("Erro ao recuperar livros!", exception);
        }

        return livros;
    }

    private Livro criar(ResultSet resultSet) throws SQLException {
        return new Livro(resultSet.getInt("id"), resultSet.getString("titulo"),
                resultSet.getString("autor"), resultSet.getString("estilo"),
                resultSet.getInt("paginas"));
    }
}
