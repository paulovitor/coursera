package dao;

import exception.DAOException;
import model.Topico;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TopicoDAOTest extends AbstractDAOTest {

    private TopicoDAO dao = new TopicoDAOImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp("/usuario.xml", "/topico.xml");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown("/usuario.xml", "/topico.xml");
    }

    @Test
    public void deveRecuperarTopicos() throws DAOException {
        String login = "mariazinha";

        List<Topico> topicos = dao.recuperarTopicos(login);

        assertNotNull(topicos);
        assertEquals(1, topicos.size());
        assertEquals(login, topicos.get(0).getLogin());
    }

    @Test
    public void deveInserirTopico() throws Exception {
        Topico topico = new Topico("basquete", "Brasília campeão brasileiro", "mariazinha");

        dao.inserir(topico);

        assertTable("/verifica-insert-topico.xml", "topico", new String[]{"id_topico"});
    }

    @Test
    public void deveRecuperarUsuarioPorLogin() throws DAOException {
        int id = 1;

        Topico topico = dao.recuperar(id);

        assertNotNull(topico);
        assertEquals(id, topico.getId());
    }
}
