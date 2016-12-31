package functional.page;

import model.Comentario;
import model.Topico;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ExibeTopicoPage {

    private WebDriver driver;

    public ExibeTopicoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void exibir(Topico topico) {
        assertEquals("Exibe tópico", driver.findElement(By.linkText("Exibe tópico")).getText());

        driver.findElement(By.linkText("Exibe tópico")).click();

        assertEquals("Voltar para os tópicos", driver.findElement(By.linkText("Voltar para os tópicos")).getText());

        assertEquals(topico.getTitulo(), driver.findElement(By.id("titulo")).getText());
        assertEquals(topico.getLogin(), driver.findElement(By.id("login")).getText());
        assertEquals(topico.getConteudo(), driver.findElement(By.id("conteudo")).getText());
    }

    public void addComentario(Comentario comentario) {
        driver.findElement(By.id("comentario")).clear();
        driver.findElement(By.id("comentario")).sendKeys(comentario.getComentario());
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();

        assertEquals("Comentário adicionado com sucesso!", driver.findElement(By.cssSelector("div.alert.alert-success")).getText());
        assertEquals("Melhor ataque do campeonato", driver.findElement(By.xpath("//td[2]")).getText());
        assertEquals(comentario.getLogin(), driver.findElement(By.xpath("//td[3]")).getText());
    }
}
