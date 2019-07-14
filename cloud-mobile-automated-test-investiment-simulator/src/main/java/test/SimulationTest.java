/**
 * 
 */
package test;

import static org.testng.Assert.assertTrue;

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
public class SimulationTest extends BrowserStackTestNGTest {
	private static final String ACTION_1 = "//a[@class='btn btnAmarelo btnRefazer']";
	public static final String PROFILE1 = "pessoa fisica";
	public static final String PROFILE2 = "pessoa juridica";

	public enum Profiles {
		PROFILE1, PROFILE2;
	}

	@DataProvider(name = "profile1-months")
	public static Object[][] pf1() {
		return new Object[][] { { PROFILE1, "500000", "10000", "36", "meses" } };
	}

	@DataProvider(name = "profile1-years")
	public static Object[][] pf2() {
		return new Object[][] { { PROFILE1, "500000", "10000", "2", "anos" } };
	}

	@DataProvider(name = "profile2-months")
	public static Object[][] pj1() {
		return new Object[][] { { PROFILE2, "500000", "10000", "36", "meses" } };
	}

	@DataProvider(name = "profile2-years")
	public static Object[][] pj2() {
		return new Object[][] { { PROFILE2, "500000", "10000", "2", "anos" } };
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

	public boolean existElement(By by) throws NoSuchElementException {
		try {
			waitForElement(by);
			List<WebElement> elementos = driver.findElements(by);
			return elementos.size() > 0;
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
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

	@Test(dataProvider = "profile1-months", priority = 0)
	public void validSimulationProfile1Months(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(existElement(By.xpath(ACTION_1)));
	}

	@Test(dataProvider = "profile1-years", priority = 1)
	public void validSimulationProfile1Years(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(existElement(By.xpath(ACTION_1)));
	}

	@Test(dataProvider = "profile2-months", priority = 2)
	public void validSimulationProfile2Months(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(existElement(By.xpath(ACTION_1)));
	}

	@Test(dataProvider = "profile2-years", priority = 3)
	public void validSimulationProfile2Years(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		simulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		assertTrue(existElement(By.xpath(ACTION_1)));
	}
}