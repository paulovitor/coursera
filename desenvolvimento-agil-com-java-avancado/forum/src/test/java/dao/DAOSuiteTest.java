package dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                UsuarioDAOTest.class,
                TopicoDAOTest.class,
                ComentarioDAOTest.class
        }
)
public class DAOSuiteTest {
}
