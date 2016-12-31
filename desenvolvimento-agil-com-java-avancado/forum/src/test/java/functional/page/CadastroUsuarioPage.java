package functional.page;

import model.Usuario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CadastroUsuarioPage {

    private WebDriver driver;

    public CadastroUsuarioPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cadastrar(Usuario usuario) {
        driver.findElement(By.linkText("Ir para tela de cadastro")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(usuario.getLogin());
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(usuario.getEmail());
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys(usuario.getNome());
        driver.findElement(By.id("senha")).clear();
        driver.findElement(By.id("senha")).sendKeys(usuario.getSenha());
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        assertEquals("Cadastro realizado com sucesso!", driver.findElement(By.cssSelector("div.alert.alert-success")).getText());
    }
}
