package gluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Configuration {

	private static WebDriver driver;

	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("incognito");
		options.addArguments("--disable-gpu");
		options.addArguments("--verbose");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.falabella.com/falabella-cl/");
	}

	public static ChromeDriver getDriver() {
		return (ChromeDriver) driver;
	}

	@After
	public void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] ss = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(ss, "images/png");
		}
		driver.quit();
	}
}
