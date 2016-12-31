package functional;

import functional.page.*;
import model.Comentario;
import model.Topico;
import model.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FunctionalTest {

    private WebDriver driver;
    private String baseUrl;
    private Usuario ze;
    private Usuario maria;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(baseUrl + "/forum/");

        ze = new Usuario("ze", "ze@gmail.com", "Jose", "123", 13);
        maria = new Usuario("maria", "maria@gmail.com", "Maria", "123", 10);
    }

    @Test
    public void deveCadastrarUsuarios() {
        CadastroUsuarioPage page = new CadastroUsuarioPage(driver);

        page.cadastrar(ze);
        page.cadastrar(maria);
    }

    @Test
    public void deveInserirTopicos() {
        Topico topico = new Topico("Futebol", "Palmeiras lider do brasileirao", ze.getLogin());
        Comentario comentario = new Comentario("Melhor ataque do campeonato", ze.getLogin(), topico.getId());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ze);

        CadastroTopicoPage cadastroTopicoPage = new CadastroTopicoPage(driver);
        cadastroTopicoPage.inserir(topico);

        ExibeTopicoPage exibeTopicoPage = new ExibeTopicoPage(driver);
        exibeTopicoPage.exibir(topico);
        exibeTopicoPage.addComentario(comentario);
    }

    @Test
    public void deveMostrarRanking() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ze);

        RankingPage rankingPage = new RankingPage(driver);
        rankingPage.exibe(ze, maria);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
