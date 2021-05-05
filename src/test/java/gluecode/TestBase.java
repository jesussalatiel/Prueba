package gluecode;

import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddProductPage;

public class TestBase {

	protected ChromeDriver driver = Configuration.getDriver();
	protected AddProductPage homePage = new AddProductPage(driver);
}
