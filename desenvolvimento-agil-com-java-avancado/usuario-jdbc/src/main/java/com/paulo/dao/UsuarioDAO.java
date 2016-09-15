package com.paulo.dao;

import java.util.List;

import com.paulo.model.Usuario;

public interface UsuarioDAO {

	public static final String USUARIO = "coursera";
	public static final String SENHA = "coursera";
	public static final String JDBC_POSTGRESQL = "jdbc:postgresql://127.0.0.1:5432/coursera";

	// insere um novo usuário no banco de dados
	public void inserir(Usuario u);

	// recupera o usuário pelo seu login
	public Usuario recuperar(String login);

	// adiciona os pontos para o usuário no banco
	public void adicionarPontos(String login, int pontos);

	// retorna a lista de usuários ordenada por pontos (maior primeiro)
	public List<Usuario> ranking();
}
