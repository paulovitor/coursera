package functional;

import model.Usuario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(Usuario usuario) {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(usuario.getLogin());
        driver.findElement(By.id("senha")).clear();
        driver.findElement(By.id("senha")).sendKeys(usuario.getSenha());
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    }
}
