package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Base;

public class AddProductPage extends Base {

	private By bannerLocator = By.xpath("//div[@class='dy-lb-close']");

	private By hamburgerLocator = By.xpath("//button[@id=\"testId-HamburgerBtn-toggle\"]/div[1]");
	private By listOfCategories = By
			.xpath("//ul[@class='TaxonomyDesktop-module_firstLevelMenu__desktop__3GtpC']/li/div/p");
	private By selectCaterory = By
			.xpath("//ul[@class='SecondLevelMenu-module_secondLevelMenu__dekstop__3s7_e']/li/ul/li/a");

	private By bannerCellphone = By.xpath("//a[@id='acc-alert-close']");

	private By selectProduct = By.xpath("//div[@id=\"testId-searchResults-products\"]/div[1]");

	private By selectItem = By.xpath("//img[@alt=\"Blu - Celular Adulto Mayor BLU Joy Boton SOS 3G Dual SIM\"]");

	private By addCar = By.xpath(".//button[contains(text(), 'Agregar a la Bolsa')]");
	private By showItems = By.xpath("//a[contains(text(), 'Ver Bolsa de Compras')]");
	private By nameItem = By.xpath("//span[contains(text(), 'Celular Adulto Mayor BLU Joy Boton SOS 3G Dual SIM')]");

	private String titleProduct = "Celulares Básicos - Falabella.com";

	private String title = "Lo encontré en Falabella.com";

	public AddProductPage(WebDriver driver) {
		super(driver);
	}

	private void closeAlert() {
		click(bannerLocator);
	}

	public boolean selectMenu() {
		try {
			closeAlert();
			click(hamburgerLocator);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}

	public boolean selectSection(String section) {
		try {
			Thread.sleep(2000);
			selectOption(listOfCategories, section);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}

	public boolean selectCategory(String category) {
		try {
			Thread.sleep(2000);
			selectOption(selectCaterory, category);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}

	public void cellphonePage() {
		click(bannerCellphone);
	}

	public boolean productPageDisplayed() {
		waitDriver();
		if (isDisplayed(bannerCellphone)) {
			click(bannerCellphone);
			return true;
		}
		return false;
	}

	public boolean selectProduct(String name) {
		try {
			click(selectItem);
			click(addCar);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}

	public boolean productNameIsDisplayed() {
		return getName().equalsIgnoreCase(titleProduct);
	}

	public boolean homePageisDisplayed() {
		return getName().equalsIgnoreCase(title);
	}

	public boolean showItems() {
		click(showItems);
		if (isDisplayed(nameItem)) {
			return true;
		}
		return false;
	}
}
