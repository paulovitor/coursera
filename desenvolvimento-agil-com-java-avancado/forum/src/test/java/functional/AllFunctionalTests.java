package functional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AllFunctionalTests {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1CadastroUsuario() throws Exception {
        driver.get(baseUrl + "/forum/");
        driver.findElement(By.linkText("Ir para tela de cadastro")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("ze");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ze@gmail.com");
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("Jose");
        driver.findElement(By.id("senha")).clear();
        driver.findElement(By.id("senha")).sendKeys("123");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        assertEquals("Cadastro realizado com sucesso!", driver.findElement(By.cssSelector("div.alert.alert-success")).getText());
        driver.findElement(By.linkText("Ir para tela de cadastro")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("maria");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("maria@gmail.com");
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("Maria");
        driver.findElement(By.id("senha")).clear();
        driver.findElement(By.id("senha")).sendKeys("123");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        assertEquals("Cadastro realizado com sucesso!", driver.findElement(By.cssSelector("div.alert.alert-success")).getText());
    }

    @Test
    public void test2Login() throws Exception {
        driver.get(baseUrl + "/forum/");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("ze");
        driver.findElement(By.id("senha")).clear();
        driver.findElement(By.id("senha")).sendKeys("123");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        assertEquals("Bem vindo Jose", driver.findElement(By.cssSelector("p.lead")).getText());
    }

    @Test
    public void test3InsertTopico() throws Exception {
        test2Login();
        driver.findElement(By.linkText("Insere Tópico")).click();
        driver.findElement(By.id("titulo")).clear();
        driver.findElement(By.id("titulo")).sendKeys("Futebol");
        driver.findElement(By.id("conteudo")).clear();
        driver.findElement(By.id("conteudo")).sendKeys("Palmeiras lider do brasileirao");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        assertEquals("Palmeiras lider do brasileirao", driver.findElement(By.xpath("//td[2]")).getText());
    }

    @Test
    public void test4ExibeTopico() throws Exception {
        test2Login();
        try {
            assertEquals("Exibe tópico", driver.findElement(By.linkText("Exibe tópico")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Exibe tópico")).click();
        assertEquals("Voltar para os tópicos", driver.findElement(By.linkText("Voltar para os tópicos")).getText());
        assertEquals("Futebol", driver.findElement(By.id("titulo")).getText());
        assertEquals("ze", driver.findElement(By.id("login")).getText());
        assertEquals("Palmeiras lider do brasileirao", driver.findElement(By.id("conteudo")).getText());
        driver.findElement(By.id("comentario")).clear();
        driver.findElement(By.id("comentario")).sendKeys("Melhor ataque do campeonato");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        assertEquals("Comentário adicionado com sucesso!", driver.findElement(By.cssSelector("div.alert.alert-success")).getText());
        assertEquals("Melhor ataque do campeonato", driver.findElement(By.xpath("//td[2]")).getText());
        assertEquals("ze", driver.findElement(By.xpath("//td[3]")).getText());
        driver.findElement(By.linkText("Voltar para os tópicos")).click();
    }

    @Test
    public void test5Ranking() throws Exception {
        test2Login();
        driver.get(baseUrl + "/forum/topico?acao=lista");
        driver.findElement(By.linkText("Ranking")).click();
        assertEquals("1", driver.findElement(By.cssSelector("td")).getText());
        assertEquals("Jose", driver.findElement(By.xpath("//td[2]")).getText());
        assertEquals("ze", driver.findElement(By.xpath("//td[3]")).getText());
        assertEquals("13", driver.findElement(By.xpath("//td[4]")).getText());
        assertEquals("2", driver.findElement(By.xpath("//tr[2]/td")).getText());
        assertEquals("Maria", driver.findElement(By.xpath("//tr[2]/td[2]")).getText());
        assertEquals("maria", driver.findElement(By.xpath("//tr[2]/td[3]")).getText());
        assertEquals("0", driver.findElement(By.xpath("//tr[2]/td[4]")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
