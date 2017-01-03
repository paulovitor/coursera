package com.paulovitor.domain;

import com.paulovitor.AbstractTest;
import com.paulovitor.dao.LivroDAO;
import com.paulovitor.dao.LivroDAOImpl;
import com.paulovitor.exception.DAOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GamificacaoTest extends AbstractTest {

    private LivroDAO livroDAO = new LivroDAOImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp("/usuario.xml", "/livro.xml", "/usuario_leu_livros.xml", "/usuario_tem_trofeus.xml");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown("/usuario.xml", "/livro.xml", "/usuario_leu_livros.xml", "/usuario_tem_trofeus.xml");
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

    @Test
    public void deveGanharTrofeuPorLerLivrosDoMesmoEstilo() throws Exception {
        Gamificacao.get().marcarLivroComoLidoPorUsuario(livroDAO.recuperar(2), "maria");
        Gamificacao.get().marcarLivroComoLidoPorUsuario(livroDAO.recuperar(3), "maria");
        Gamificacao.get().marcarLivroComoLidoPorUsuario(livroDAO.recuperar(4), "maria");
        Gamificacao.get().marcarLivroComoLidoPorUsuario(livroDAO.recuperar(5), "maria");

        assertTable("/verifica-marcacao-usuario_tem_trofeus.xml", "usuario_tem_trofeus");
    }

    @Test
    public void devePerderTrofeuPorLerLivrosDoMesmoEstilo() throws Exception {
        Livro livro = livroDAO.recuperar(10);
        Gamificacao.get().desmarcarLivroComoLidoPorUsuario(livro, "jose");

        assertTable("/verifica-desmarcacao-usuario_tem_trofeus.xml", "usuario_tem_trofeus");
    }

    @Test
    public void deveRecuperarPerfil() throws DAOException {
        String login = "jose";

        Usuario usuario = Gamificacao.get().recuperarPerfil(login);

        assertNotNull(usuario);
        assertEquals(login, usuario.getLogin());
        assertNotNull(usuario.getTrofeus());
        assertTrue(usuario.getTrofeus().size() == 1);
        assertEquals("Religião", usuario.getTrofeus().get(0));
    }
}
