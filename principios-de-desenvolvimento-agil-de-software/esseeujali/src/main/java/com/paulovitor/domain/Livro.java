package com.paulovitor.domain;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private String estilo;
    private int paginas;

    public Livro(int id, String titulo, String autor, String estilo, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estilo = estilo;
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEstilo() {
        return estilo;
    }

    public int getPaginas() {
        return paginas;
    }
}
