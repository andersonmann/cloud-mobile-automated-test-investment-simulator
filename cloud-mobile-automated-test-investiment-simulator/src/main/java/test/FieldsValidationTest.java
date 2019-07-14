package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import core.BrowserStackTestNGTest;

/**
 * @author anderson.mann
 *
 */
public class FieldsValidationTest extends BrowserStackTestNGTest {

	private void simulateError() {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.xpath("//button[@class='btn btnAmarelo btnSimular']")).click();
	}

	@Test
	public void validateMandatoryFields1() {
		simulateError();
		String value = driver.findElement(By.id("valorAplicar-error")).getText();
		assertEquals("Valor mínimo de 20.00", value);
	}

	@Test
	public void validateMandatoryFields2() {
		simulateError();
		String value = driver.findElement(By.id("valorInvestir-error")).getText();
		assertEquals("Valor mínimo de 20.00", value);
	}

	@Test
	public void validateMandatoryFields3() {
		simulateError();
		String value = driver.findElement(By.id("tempo-error")).getText();
		assertEquals("Obrigatório", value);
	}
}