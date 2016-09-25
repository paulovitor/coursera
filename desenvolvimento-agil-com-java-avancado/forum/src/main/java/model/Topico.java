package model;

public class Topico {

    private int id;
    private String titulo;
    private String conteudo;
    private String login;

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
