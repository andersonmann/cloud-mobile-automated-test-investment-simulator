/**
 * 
 */
package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * @author andersonmann
 *
 */
public class JavaSample {
	public static final String USERNAME = "testesicredi1";
	public static final String AUTOMATE_KEY = "sq7MHetDbsGcMHy5YF7K";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone XS");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "12");
		caps.setCapability("name", "Bstack-[Java] Sample Test");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);


		System.out.println(driver.getTitle());
		driver.quit();

	}

}
