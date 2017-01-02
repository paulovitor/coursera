package com.paulovitor.dao;

import com.paulovitor.domain.Usuario;
import com.paulovitor.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl extends AbstractDAO implements UsuarioDAO {

    @Override
    public Usuario recuperar(String login, String senha) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, login);
            prepareStatement.setString(2, senha);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) return criar(resultSet);

        } catch (SQLException exception) {
            throw new DAOException("Erro ao recuperar usuário!", exception);
        }

        return null;
    }

    @Override
    public boolean usuarioJaLeuLivro(String login, int idLivro) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "SELECT COUNT(*) FROM usuario_leu_livros WHERE login = ? AND id_livro = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, login);
            prepareStatement.setInt(2, idLivro);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1) > 0;

        } catch (SQLException exception) {
            throw new DAOException("Erro ao verificar se usuário leu livro!", exception);
        }

        return false;
    }

    private Usuario criar(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet.getString("login"), resultSet.getString("email"),
                resultSet.getString("nome"), resultSet.getString("senha"),
                resultSet.getInt("pontos"));
    }
}
