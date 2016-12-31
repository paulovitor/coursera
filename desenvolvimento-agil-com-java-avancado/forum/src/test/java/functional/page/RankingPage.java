package functional.page;

import model.Usuario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class RankingPage {

    private WebDriver driver;

    public RankingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void exibe(Usuario... usuarios) {
        driver.findElement(By.linkText("Ranking")).click();

        for (int i = 0; i < usuarios.length; i++) {
            assertEquals(String.valueOf((i + 1)), driver.findElement(i == 0 ? By.cssSelector("td") : By.xpath("//tr[" + (i + 1) + "]/td")).getText());
            assertEquals(usuarios[i].getNome(), driver.findElement(By.xpath(i == 0 ? "//td[2]" : "//tr[" + (i + 1) + "]/td[2]")).getText());
            assertEquals(usuarios[i].getLogin(), driver.findElement(By.xpath(i == 0 ? "//td[3]" : "//tr[" + (i + 1) + "]/td[3]")).getText());
            assertEquals(String.valueOf(usuarios[i].getPontos()), driver.findElement(By.xpath(i == 0 ? "//td[4]" : "//tr[" + (i + 1) + "]/td[4]")).getText());
        }
    }
}
