package com.paulovitor.dao;

import com.paulovitor.domain.Usuario;
import com.paulovitor.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void marcarLivroComoLido(int idLivro, String login) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "INSERT INTO usuario_leu_livros(login, id_livro) VALUES (?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, login);
            prepareStatement.setInt(2, idLivro);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new DAOException("Erro ao marcar livro como lido!", exception);
        }
    }

    @Override
    public void desmarcarLivroComoLido(int idLivro, String login) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "DELETE FROM usuario_leu_livros WHERE login = ? AND id_livro = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, login);
            prepareStatement.setInt(2, idLivro);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new DAOException("Erro ao desmarcar livro como lido!", exception);
        }
    }

    @Override
    public void marcarPontos(int pontos, String login) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, pontos);
            prepareStatement.setString(2, login);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new DAOException("Erro ao marcar pontos para usuário!", exception);
        }
    }

    @Override
    public void desmarcarPontos(int pontos, String login) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "UPDATE usuario SET pontos = pontos - ? WHERE login = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, pontos);
            prepareStatement.setString(2, login);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new DAOException("Erro ao desmarcar pontos para usuário!", exception);
        }
    }

    @Override
    public List<Usuario> ranking() throws DAOException {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM usuario ORDER BY pontos DESC LIMIT 10";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                usuarios.add(criar(resultSet));
            }

        } catch (SQLException exception) {
            throw new DAOException("Erro ao recuperar usuarios!", exception);
        }

        return usuarios;
    }

    private Usuario criar(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet.getString("login"), resultSet.getString("email"),
                resultSet.getString("nome"), resultSet.getString("senha"),
                resultSet.getInt("pontos"));
    }
}
