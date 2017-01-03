package com.paulovitor.domain;

import java.util.List;

public class Usuario {

    private final String login;
    private final String email;
    private final String nome;
    private final String senha;
    private final int pontos;
    private List<String> trofeus;

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

    public List<String> getTrofeus() {
        return trofeus;
    }

    public void setTrofeus(List<String> trofeus) {
        this.trofeus = trofeus;
    }
}
