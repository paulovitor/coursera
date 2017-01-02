package com.paulovitor.domain;

public class Livro {

    private final int id;
    private final String titulo;
    private final String autor;
    private final String estilo;
    private final int paginas;

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
