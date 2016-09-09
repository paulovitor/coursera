import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ConvertFunctionalTest {

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
	public void testConvertFahrenheitParaCelsius() throws Exception {
		driver.get(baseUrl + "/celsius-fahrenheit/");
		new Select(driver.findElement(By.name("conversao"))).selectByVisibleText("Fahrenheit para Celsius");
		driver.findElement(By.name("valor")).clear();
		driver.findElement(By.name("valor")).sendKeys("212");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Resultado: 100", driver.findElement(By.cssSelector("h3")).getText());
	}

	@Test
	public void testConvertCelsiusParaFahrenheit() throws Exception {
		driver.get(baseUrl + "/celsius-fahrenheit/");
		driver.findElement(By.name("valor")).clear();
		driver.findElement(By.name("valor")).sendKeys("100");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Resultado: 212", driver.findElement(By.cssSelector("h3")).getText());
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
