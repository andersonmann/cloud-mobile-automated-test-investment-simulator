/**
 * 
 */
package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import core.BasePage;
import interfaces.Simulation;
import io.appium.java_client.MobileElement;

/**
 * @author anderson.mann
 *
 */
public class SimulationPage extends BasePage implements Simulation {

	public void selectProfile(String profile) {
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
		write(By.id("valorAplicar"), value);
	}

	public void inputMonthlylValue(String value) {
		write(By.id("valorInvestir"), value);
	}

	public void inputTime(String time) {
		write(By.id("tempo"), time);
	}

	public void selectTimeType(String timeType) {
		click(By.xpath("//span[@class='seta']"));
		if (timeType.equalsIgnoreCase("anos")) {
			click(By.xpath("//a[contains(text(),'Anos')]"));
		} else {
			return;
		}
	}

	public void clicksimulateButton() {
		click(By.xpath("//button[@class='btn btnAmarelo btnSimular']"));
	}

	public void clickCleanFormButton() {
		click(By.className("btn btnAmarelo btnSimular"));
	}

	public void flowSimulateInvestment(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		scrollToDown();
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
		clicksimulateButton();
	}

	public void inputDataAndCleanFields(String profile, String initialValue, String monthlyValue, String time,
			String timeType) {
		flowSimulateInvestment(profile, initialValue, monthlyValue, time, timeType);
		clickCleanFormButton();
	}

	public void validateMandatoryFields() {
		scrollToDown();
		clicksimulateButton();
	}
}