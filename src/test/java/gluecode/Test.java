package gluecode;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test extends TestBase {

	@Given("^the user is the main page$")
	public void the_user_is_the_main_page() {
		Assert.assertTrue(homePage.homePageisDisplayed());
	}

	@Then("^the user click the button hamburguer$")
	public void the_user_click_the_button_hamburguer() {
		Assert.assertTrue(homePage.selectMenu());
	}

	@When("^the user choose the \"([^\"]*)\" section$")
	public void theUserChooseTheSection(String section) throws Throwable {
		Assert.assertTrue(homePage.selectSection("Telefonía"));

	}

	@When("^the user select the \"([^\"]*)\" product$")
	public void theUserSelectTheProduct(String product) throws Throwable {
		homePage.selectCategory("Celulares básicos");

	}

	@Then("^the cellphone page apppears$")
	public void the_cellphone_page_apppears() throws Throwable {
		Assert.assertTrue(homePage.productPageDisplayed());
	}

	@When("^the user is in the cellphone page$")
	public void the_user_is_in_the_cellphone_page() throws Throwable {
		Assert.assertTrue(homePage.productNameIsDisplayed());
	}

	@Then("^the user should be able to select a \"(.*)\"$")
	public void the_user_should_be_able_to_select_a(String product) throws Throwable {
		Assert.assertTrue(homePage.selectProduct("Celular Adulto Mayor BLU Joy Boton SOS 3G Dual SIM"));
	}

	@Then("^the user will be able to see the product in the shooping car$")
	public void the_user_will_be_able_to_see_the_product_in_the_shooping_car() throws Throwable {
		Assert.assertTrue(homePage.showItems());
	}

}
