package model;

public class Comentario {

    private int id;
    private final String comentario;
    private final String login;
    private final int topicoId;

    public Comentario(int id, String comentario, String login, int topicoId) {
        this.id = id;
        this.comentario = comentario;
        this.login = login;
        this.topicoId = topicoId;
    }

    public Comentario(String comentario, String login, int topicoId) {
        this.comentario = comentario;
        this.login = login;
        this.topicoId = topicoId;
    }

    public int getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public String getLogin() {
        return login;
    }

    public int getTopicoId() {
        return topicoId;
    }
}
