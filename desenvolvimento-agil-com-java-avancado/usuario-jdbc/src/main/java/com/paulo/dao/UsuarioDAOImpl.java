package com.paulo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paulo.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void inserir(Usuario u) {
		try (Connection connection = DriverManager.getConnection(JDBC_POSTGRESQL, USUARIO, SENHA)) {

			String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, u.getLogin());
			prepareStatement.setString(2, u.getEmail());
			prepareStatement.setString(3, u.getNome());
			prepareStatement.setString(4, u.getSenha());
			prepareStatement.setInt(5, u.getPontos());
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o comando", e);
		}
	}

	public Usuario recuperar(String login) {
		try (Connection connection = DriverManager.getConnection(JDBC_POSTGRESQL, USUARIO, SENHA)) {

			String sql = "SELECT * FROM usuario WHERE login = ?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, login);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				return new Usuario(resultSet.getString("login"), resultSet.getString("email"),
						resultSet.getString("nome"), resultSet.getString("senha"), resultSet.getInt("pontos"));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o comando", e);
		}

		return null;
	}

	public void adicionarPontos(String login, int pontos) {
		try (Connection connection = DriverManager.getConnection(JDBC_POSTGRESQL, USUARIO, SENHA)) {

			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, pontos);
			prepareStatement.setString(2, login);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o comando", e);
		}
	}

	public List<Usuario> ranking() {
		List<Usuario> usuarios = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(JDBC_POSTGRESQL, USUARIO, SENHA)) {

			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				usuarios.add(new Usuario(resultSet.getString("login"), resultSet.getString("email"),
						resultSet.getString("nome"), resultSet.getString("senha"), resultSet.getInt("pontos")));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o comando", e);
		}

		return usuarios;
	}
}
