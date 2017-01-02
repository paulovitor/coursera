package com.paulovitor.dao;

import com.paulovitor.domain.Usuario;
import com.paulovitor.exception.DAOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioDAOTest extends AbstractDAOTest {

    private UsuarioDAO dao = new UsuarioDAOImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp("/usuario.xml", "/livro.xml", "/usuario_leu_livros.xml");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown("/usuario.xml", "/livro.xml", "/usuario_leu_livros.xml");
    }

    @Test
    public void deveRecuperarUsuarioPorLogin() throws DAOException {
        String login = "mariazinha";

        Usuario usuario = dao.recuperar(login, "marie");

        assertNotNull(usuario);
        assertEquals(login, usuario.getLogin());
    }

    @Test
    public void deveVerificarSeUsuarioJaLeuLivro() throws DAOException {
        assertTrue(dao.usuarioJaLeuLivro("mariazinha", 1));
    }
}
