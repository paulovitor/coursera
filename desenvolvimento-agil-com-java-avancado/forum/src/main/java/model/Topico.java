package model;

public class Topico {

    private int id;
    private final String titulo;
    private final String conteudo;
    private final String login;

    public Topico(int id, String titulo, String conteudo, String login) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
    }

    public Topico(String titulo, String conteudo, String login) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getLogin() {
        return login;
    }
}
