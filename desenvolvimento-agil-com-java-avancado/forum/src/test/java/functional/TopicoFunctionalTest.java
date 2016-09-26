package functional;

import model.Comentario;
import model.Topico;
import model.Usuario;
import org.junit.Test;

public class TopicoFunctionalTest extends AbstractFunctionalTest {

    @Test
    public void run() {
        Usuario ze = new Usuario("ze", "ze@gmail.com", "Jose", "123", 0);
        Topico topico = new Topico("Futebol", "Palmeiras lider do brasileirao", ze.getLogin());
        Comentario comentario = new Comentario("Melhor ataque do campeonato", ze.getLogin(), topico.getId());

        open();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ze);

        CadastroTopicoPage cadastroTopicoPage = new CadastroTopicoPage(driver);
        cadastroTopicoPage.inserir(topico);

        ExibeTopicoPage exibeTopicoPage = new ExibeTopicoPage(driver);
        exibeTopicoPage.exibir(topico);
        exibeTopicoPage.addComentario(comentario);
    }
}
