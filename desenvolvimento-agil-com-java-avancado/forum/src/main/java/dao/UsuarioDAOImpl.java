package dao;

import exception.DAOException;
import model.Usuario;

import java.sql.*;

public class UsuarioDAOImpl implements UsuarioDAO {

    public static final String USUARIO = "postgres";
    public static final String SENHA = "postgres";
    public static final String JDBC_POSTGRESQL = "jdbc:postgresql://127.0.0.1:5432/forum";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(Usuario usuario) throws DAOException {
        try (Connection connection = DriverManager.getConnection(JDBC_POSTGRESQL, USUARIO, SENHA)) {

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
        try (Connection connection = DriverManager.getConnection(JDBC_POSTGRESQL, USUARIO, SENHA)) {

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
            throw new DAOException("Erro ao recuperar usuário!", exception);
        }

        return null;
    }
}
