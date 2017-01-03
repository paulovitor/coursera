package com.paulovitor.dao;

import com.paulovitor.AbstractTest;
import com.paulovitor.domain.Livro;
import com.paulovitor.exception.DAOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LivroDAOTest extends AbstractTest {

    private LivroDAO dao = new LivroDAOImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp("/livro.xml");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown("/livro.xml");
    }

    @Test
    public void deveRecuperarTodosOsLivros() throws DAOException {
        List<Livro> livros = dao.recuperarTodos();

        assertNotNull(livros);
        assertEquals(10, livros.size());
    }

    @Test
    public void deveRecuperarLivro() throws DAOException {
        int id = 1;

        Livro livro = dao.recuperar(id);

        assertNotNull(livro);
        assertEquals(id, livro.getId());
    }
}
