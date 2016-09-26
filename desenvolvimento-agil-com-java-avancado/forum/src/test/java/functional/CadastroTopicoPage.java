package functional;

import model.Topico;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CadastroTopicoPage {

    private WebDriver driver;

    public CadastroTopicoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inserir(Topico topico) {
        driver.findElement(By.linkText("Insere Tópico")).click();
        driver.findElement(By.id("titulo")).clear();
        driver.findElement(By.id("titulo")).sendKeys(topico.getTitulo());
        driver.findElement(By.id("conteudo")).clear();
        driver.findElement(By.id("conteudo")).sendKeys(topico.getConteudo());
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        assertEquals("Palmeiras lider do brasileirao", driver.findElement(By.xpath("//td[2]")).getText());
    }
}
