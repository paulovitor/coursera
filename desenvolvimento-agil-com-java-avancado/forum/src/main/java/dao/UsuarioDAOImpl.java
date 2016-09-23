package dao;

import exception.DAOException;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl extends BaseDAO implements UsuarioDAO {

    @Override
    public void inserir(Usuario usuario) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, usuario.getLogin());
            prepareStatement.setString(2, usuario.getEmail());
            prepareStatement.setString(3, usuario.getNome());
            prepareStatement.setString(4, usuario.getSenha());
            prepareStatement.setInt(5, usuario.getPontos());
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new DAOException("Erro ao inserir usuário!", exception);
        }
    }

    @Override
    public Usuario recuperar(String login, String senha) throws DAOException {
        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, login);
            prepareStatement.setString(2, senha);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                return new Usuario(resultSet.getString("login"), resultSet.getString("email"),
                        resultSet.getString("nome"), resultSet.getString("senha"), resultSet.getInt("pontos"));
            }

        } catch (SQLException exception) {
            throw new DAOException("Erro ao recuperarTopicos usuário!", exception);
        }

        return null;
    }

    @Override
    public List<Usuario> recuperarTodos() throws DAOException {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                usuarios.add(new Usuario(resultSet.getString("login"), resultSet.getString("email"),
                        resultSet.getString("nome"), resultSet.getString("senha"), resultSet.getInt("pontos")));
            }

        } catch (SQLException e) {
            throw new DAOException("Erro ao recuperarTopicos todos os usuários!", e);
        }

        return usuarios;
    }
}
