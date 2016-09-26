package functional;

import model.Usuario;
import org.junit.Test;

public class UsuarioFunctionalTest extends AbstractFunctionalTest {

    @Test
    public void run() {
        open();

        CadastroUsuarioPage page = new CadastroUsuarioPage(driver);

        page.cadastrar(new Usuario("ze", "ze@gmail.com", "Jose", "123", 0));
        page.cadastrar(new Usuario("maria", "maria@gmail.com", "Maria", "123", 0));
    }
}
