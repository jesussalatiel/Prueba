package utils;

import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public void selectOption(By locator, String name) {
		List<WebElement> elements = driver.findElements(locator);
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(name)) {
				elements.get(i).click();
			}
		}
		elements.clear();
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void sendText(String inputText, By locator) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(inputText);
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isEnabled();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public int getWindowsHandle() {
		int position = -1;
		String currentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		while (i.hasNext()) {
			String childwindow = i.next();
			if (!childwindow.equalsIgnoreCase(currentwindow)) {
				driver.switchTo().window(childwindow);
				position = Integer.parseInt(childwindow);
			} else {
				position = -1;
			}
		}
		return position;
	}

	public void waitDriver() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public String getName() {
		return driver.getTitle();
	}
}