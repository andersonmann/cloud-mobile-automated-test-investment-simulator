/**
* 
*/
package test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BrowserStackTestNGTest;

/**
 * @author anderson.mann
 *
 */
public class SimulationResultTest extends BrowserStackTestNGTest {
	private static final String ACTION_1 = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/strong[1]";
	public static final String PROFILE1 = "pessoa fisica";
	public static final String PROFILE2 = "pessoa juridica";
	public static final String TIME1 = "meses";
	public static final String TIME2 = "anos";

	public enum Profiles {
		PROFILE1, PROFILE2;
	}

	public enum TimeType {
		TIME1, TIME2;
	}

	@DataProvider(name = "months")
	public static Object[][] months() {
		return new Object[][] { { PROFILE1, "500000", "10000", "36", TIME1 } };
	}

	@DataProvider(name = "years")
	public static Object[][] years() {
		return new Object[][] { { PROFILE2, "500000", "10000", "2", TIME2 } };
	}

	public void switchTo(int value) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[value]);
	}

	public void flowSimulateInvestment(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		switchTo(0);
		selectProfile(profile);
		inputInitialValue(initialValue);
		inputMonthlylValue(monthlyValue);
		inputTime(time);
		selectTimeType(timeType);
	}

	public void simulateInvestiment(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		flowSimulateInvestment(profile, initialValue, monthlyValue, time, timeType);
	}

	private void selectProfile(String profile) {
		try {
			if (profile.equalsIgnoreCase("pessoa juridica")) {
				List<WebElement> rdBtProfile = driver.findElements(By.name("perfil"));
				boolean bValue = false;
				bValue = rdBtProfile.get(0).isSelected();
				if (bValue == true) {
					rdBtProfile.get(1).click();
				}
			} else {
				return;
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Option not found: " + e.getMessage());
		}
	}

	public void inputInitialValue(String value) {
		driver.findElement(By.id("valorAplicar")).click();
		driver.findElement(By.id("valorAplicar")).sendKeys(value);
	}

	public void inputMonthlylValue(String value) {
		driver.findElement(By.id("valorInvestir")).click();
		driver.findElement(By.id("valorInvestir")).sendKeys(value);
	}

	public void inputTime(String time) {
		driver.findElement(By.id("tempo")).click();
		driver.findElement(By.id("tempo")).sendKeys(time);
	}

	public void selectTimeType(String timeType) {
		driver.findElement(By.xpath("//span[@class='seta']")).click();
		if (timeType.equalsIgnoreCase("anos")) {
			driver.findElement(By.xpath("//a[contains(text(),'Anos')]")).click();
		} else {
			return;
		}
	}

	public void clicksimulateButton() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void exitFrame() {
		driver.switchTo().defaultContent();
	}

	private void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	private void simulateInvestment(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		switchTo(0);
		selectProfile(profile);
		inputInitialValue(initialValue);
		inputMonthlylValue(monthlyValue);
		inputTime(time);
		selectTimeType(timeType);
		clicksimulateButton();
	}

	@Test(dataProvider = "months", priority = 0)
	public void validSimulationMonths(String profile, String initialValue, String monthlyValue, String time,
			String timeType) throws InterruptedException {
		simulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		exitFrame();
		waitForElement(By.xpath(ACTION_1));
		String textValue = driver.findElement(By.xpath(ACTION_1)).getText();
		assertEquals("36 meses", textValue);
	}

	@Test(dataProvider = "years", priority = 1)
	public void validSimulationYears(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		exitFrame();
		waitForElement(By.xpath(ACTION_1));
		String textValue = driver.findElement(By.xpath(ACTION_1)).getText();
		assertEquals("24 meses", textValue);
	}
}