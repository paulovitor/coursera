package dao;

import exception.DAOException;
import model.Usuario;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UsuarioDAOTest extends AbstractDAOTest {

    private UsuarioDAO dao = new UsuarioDAOImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp("/usuario.xml");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown("/usuario.xml", "/topico.xml");
    }

    @Test
    public void deveInserirUsuario() throws Exception {
        Usuario usuario = new Usuario("zezinho", "jose@coursera.org", "José", "joseph", 30);

        dao.inserir(usuario);

        assertTable("/verifica-insert-usuario.xml", "usuario");
    }

    @Test
    public void deveRecuperarUsuarioPorLogin() throws DAOException {
        String login = "mariazinha";

        Usuario usuario = dao.recuperar(login, "marie");

        assertNotNull(usuario);
        assertEquals(login, usuario.getLogin());
    }

    @Test
    public void deveListarUsuariosOrdenadosPorPontos() throws DAOException {
        List<Usuario> usuarios = dao.ranking();

        assertNotNull(usuarios);
        assertEquals(2, usuarios.size());
        assertEquals("mariazinha", usuarios.get(0).getLogin());
    }
}
