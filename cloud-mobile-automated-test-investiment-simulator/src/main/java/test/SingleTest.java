package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.BrowserStackTestNGTest;
import page.HomePage;
import page.SimulationPage;

public class SingleTest extends BrowserStackTestNGTest {
	private SimulationPage simulation = new SimulationPage();
	// HomePage home = new HomePage();

	// @Test
	public void test() throws Exception {
//		driver.get("https://www.google.com/ncr");
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
//		driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);

		driver.findElement(By.id("valorAplicar")).sendKeys("999999");

//		WebElement element = driver.findElement(By.name("q"));
//		element.sendKeys("BrowserStack");
//		element.submit();
		Thread.sleep(5000);
		assertTrue(true);
//		Assert.assertEquals("BrowserStack - Google Search", driver.getTitle());
	}

	@Test
	public void test2() throws Exception {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.xpath("//button[@class='btn btnAmarelo btnSimular']")).click();

		String value = driver.findElement(By.id("valorAplicar-error")).getText();
		assertEquals("Valor mínimo de 20.00", value);
	}
}
