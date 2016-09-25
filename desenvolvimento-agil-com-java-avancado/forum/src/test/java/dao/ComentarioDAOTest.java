package dao;

import exception.DAOException;
import model.Comentario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComentarioDAOTest extends AbstractDAOTest {

    private ComentarioDAO dao = new ComentarioDAOImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp("/usuario.xml", "/topico.xml", "/comentario.xml");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown("/usuario.xml", "/topico.xml", "/comentario.xml");
    }

    @Test
    public void deveRecuperarComentarios() throws DAOException {
        int topicoId = 1;

        List<Comentario> comentarios = dao.recuperarComentarios(topicoId);

        assertNotNull(comentarios);
        assertEquals(1, comentarios.size());
        assertEquals(topicoId, comentarios.get(0).getTopicoId());
    }

    @Test
    public void deveInserirComentario() throws Exception {
        Comentario topico = new Comentario("Palmeiras é o time com melhor ataque", "mariazinha", 1);

        dao.inserir(topico);

        assertTable("/verifica-insert-comentario.xml", "comentario", new String[]{"id_comentario"});
    }
}
