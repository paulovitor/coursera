package com.paulovitor.dao;

import com.paulovitor.domain.Usuario;
import com.paulovitor.exception.DAOException;

import java.util.List;

public interface UsuarioDAO {

    Usuario recuperar(String login, String senha) throws DAOException;

    boolean usuarioJaLeuLivro(String login, int idLivro) throws DAOException;

    void marcarLivroComoLido(int idLivro, String login) throws DAOException;

    void desmarcarLivroComoLido(int idLivro, String login) throws DAOException;

    void marcarPontos(int pontos, String login) throws DAOException;

    void desmarcarPontos(int pontos, String login) throws DAOException;

    List<Usuario> ranking() throws DAOException;

    int contarLivrosLidoDeUmEstilo(String login, String estilo) throws DAOException;

    void adicionarTrofeu(String login, String estilo) throws DAOException;

    boolean temTrofeu(String login, String estilo) throws DAOException;

    void removerTrofeu(String login, String estilo) throws DAOException;
}
