package com.paulovitor.domain;

import com.paulovitor.AbstractTest;
import com.paulovitor.dao.LivroDAO;
import com.paulovitor.dao.LivroDAOImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GamificacaoTest extends AbstractTest {

    private LivroDAO livroDAO = new LivroDAOImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp("/usuario.xml", "/livro.xml", "/usuario_leu_livros.xml");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown("/usuario.xml", "/livro.xml", "/usuario_leu_livros.xml");
    }

    @Test
    public void deveMarcarLivroComoLidoPorUsuario() throws Exception {
        Livro livro = livroDAO.recuperar(2);
        Gamificacao.get().marcarLivroComoLidoPorUsuario(livro, "maria");

        assertTable("/verifica-marcacao-usuario_leu_livros.xml", "usuario_leu_livros");
        assertTable("/verifica-marcacao-usuario.xml", "usuario");
    }

    @Test
    public void deveDesmarcarLivroComoLidoPorUsuario() throws Exception {
        Livro livro = livroDAO.recuperar(1);
        Gamificacao.get().desmarcarLivroComoLidoPorUsuario(livro, "maria");

        assertTable("/verifica-desmarcacao-usuario_leu_livros.xml", "usuario_leu_livros");
        assertTable("/verifica-desmarcacao-usuario.xml", "usuario");
    }
}
