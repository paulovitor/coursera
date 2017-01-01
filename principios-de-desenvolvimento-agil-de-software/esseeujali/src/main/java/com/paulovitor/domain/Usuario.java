package com.paulovitor.domain;

public class Usuario {

    private final String login;
    private final String email;
    private final String nome;
    private final String senha;
    private final int pontos;

    public Usuario(String login, String email, String nome, String senha, int pontos) {
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.pontos = pontos;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public int getPontos() {
        return pontos;
    }
}
