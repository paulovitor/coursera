package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TradutorFunctionalTest {

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
	public void deveTraduzirPalavrasQueExistemNoArquivo() {
		driver.get(baseUrl + "/tradutor/");
		driver.findElement(By.name("palavra")).clear();
		driver.findElement(By.name("palavra")).sendKeys("luz");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Tradução: light", driver.findElement(By.cssSelector("p")).getText());
		
		driver.get(baseUrl + "/tradutor/");
		driver.findElement(By.name("palavra")).clear();
		driver.findElement(By.name("palavra")).sendKeys("carro");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Tradução: car", driver.findElement(By.cssSelector("p")).getText());
	}

	@Test
	public void naoDeveTraduzirPalavraQueNaoExisteNoArquivo() {
		driver.get(baseUrl + "/tradutor/");
		driver.findElement(By.name("palavra")).clear();
		driver.findElement(By.name("palavra")).sendKeys("bom");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Tradução: bom", driver.findElement(By.cssSelector("p")).getText());
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
