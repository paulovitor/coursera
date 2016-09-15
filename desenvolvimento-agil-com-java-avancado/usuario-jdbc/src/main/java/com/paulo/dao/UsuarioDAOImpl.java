package com.paulo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	public List<Usuario> ranking() {
		// TODO Auto-generated method stub
		return null;
	}

}
