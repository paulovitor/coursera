package com.paulovitor.dao;

import com.paulovitor.AbstractTest;
import com.paulovitor.domain.Usuario;
import com.paulovitor.exception.DAOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UsuarioDAOTest extends AbstractTest {

    private UsuarioDAO dao = new UsuarioDAOImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp("/usuario.xml", "/livro.xml", "/usuario_leu_livros.xml", "/usuario_tem_trofeus.xml");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown("/usuario.xml", "/livro.xml", "/usuario_leu_livros.xml", "/usuario_tem_trofeus.xml");
    }

    @Test
    public void deveRecuperarUsuarioPorLoginESenha() throws DAOException {
        String login = "maria";

        Usuario usuario = dao.recuperar(login, "maria");

        assertNotNull(usuario);
        assertEquals(login, usuario.getLogin());
    }

    @Test
    public void deveVerificarSeUsuarioJaLeuLivro() throws DAOException {
        assertTrue(dao.usuarioJaLeuLivro("maria", 1));
    }

    @Test
    public void deveRecuperarUsuariosComMaiorPontuacao() throws DAOException {
        List<Usuario> ranking = dao.ranking();

        assertNotNull(ranking);
        assertTrue(ranking.size() <= 10);
        assertEquals("jose", ranking.get(0).getLogin());
    }

    @Test
    public void deveContarLivrosLidoDeUmEstilo() throws DAOException {
        int quantidade = dao.contarLivrosLidoDeUmEstilo("jose", "Religião");

        assertEquals(5, quantidade);
    }

    @Test
    public void deveVerificarSeUsuarioTemTrofeu() throws DAOException {
        assertFalse(dao.temTrofeu("maria", "Tecnologia"));
        assertTrue(dao.temTrofeu("jose", "Religião"));
    }
}
