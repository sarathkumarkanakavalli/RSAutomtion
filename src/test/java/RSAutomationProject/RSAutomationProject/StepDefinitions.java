package RSAutomationProject.RSAutomationProject;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.RS.driver.DriverScript;
import com.RS.pageobjects.HomePageObjects;
import com.RS.pageobjects.SearchResultsPageObjects;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends DriverScript {

	// Initialize the driver
	public WebDriver driver;
	// Creating the objects for page objects classes

	HomePageObjects homePageObjects;
	SearchResultsPageObjects searchResultsPageObjects;

	@Given("^I am on the RS homepage$")
	public void i_am_on_the_RS_homepage() throws Throwable {
		// Open the browser and navigate to the URL
		driver = createWebdriver();
		homePageObjects = new HomePageObjects(driver);
		searchResultsPageObjects = new SearchResultsPageObjects(driver);
		String path = System.getProperty("user.dir");
		getscreenshots();
	}

	@When("^I search for a product by \"([^\"]*)\" brand$")
	public void i_search_for_a_product_by_brand(String arg1) throws Throwable {
		// search for the product by using brand name via search field
		homePageObjects.searchField(arg1);
		homePageObjects.searchButton();
		getscreenshots();
	}

	@Then("^Products from the specified brand should be retrieved$")
	public void products_from_the_specified_brand_should_be_retrieved()
			throws Throwable {
		// Verify the search results are displayed

		WebElement searchResults = searchResultsPageObjects.searchBrand();
		getscreenshots();
		Assert.assertTrue(searchResults.isDisplayed());
		searchResultsPageObjects.clickBrand();
		WebElement product = searchResultsPageObjects.product();
		getscreenshots();
		Assert.assertTrue(product.isDisplayed());
		destroyDriver();
	}

	@When("^I search for a product by \"([^\"]*)\" Mfr\\. Part No\\.$")
	public void i_search_for_a_product_by_Mfr_Part_No(String arg1)
			throws Throwable {
		// search the product by manufacture part number
		homePageObjects.searchField(arg1);
		homePageObjects.searchButton();
		getscreenshots();
	}

	@Then("^Product Details Page With The Specified Mfr\\. Part No\\. Should Be Opened$")
	public void product_Details_Page_With_The_Specified_Mfr_Part_No_Should_Be_Opened()
			throws Throwable {
		// Product is verified

		WebElement mfrPartNo = searchResultsPageObjects.mfrPartNo();
		getscreenshots();
		Assert.assertTrue(mfrPartNo.isDisplayed());
		WebElement productImage = searchResultsPageObjects.productImage();
		getscreenshots();
		Assert.assertTrue(productImage.isDisplayed());
		destroyDriver();

	}

	@When("^I search for a product by \"([^\"]*)\" RS Stock No\\.$")
	public void i_search_for_a_product_by_RS_Stock_No(String arg1)
			throws Throwable {
		// search product by RS stock number
		homePageObjects.searchField(arg1);
		homePageObjects.searchButton();
		getscreenshots();
	}

	@Then("^Product Details Page With The Specified RS Stock No\\. Should Be Opened$")
	public void product_Details_Page_With_The_Specified_RS_Stock_No_Should_Be_Opened()
			throws Throwable {
		// Product with page is opened

		WebElement rsStockNo = searchResultsPageObjects.rsStockNo();
		getscreenshots();
		Assert.assertTrue(rsStockNo.isDisplayed());
		WebElement productImage = searchResultsPageObjects.productImage();
		getscreenshots();
		Assert.assertTrue(productImage.isDisplayed());
		destroyDriver();
	}

	@When("^I click on the All Products link$")
	public void i_click_on_the_All_Products_link() throws Throwable {
		// Product link is clicked
		homePageObjects.allproductsLink();
		getscreenshots();
	}

	@When("^I click on the Non-Rechargeable Batteries on Batteries mouseover$")
	public void i_click_on_the_Non_Rechargeable_Batteries_on_Batteries_mouseover()
			throws Throwable {
		// Sub option link is clicked
		homePageObjects.batteriesLink();
		getscreenshots();
		Thread.sleep(3000);
		homePageObjects.nonrechargeablebatteriesLink();
		getscreenshots();

	}

	@Given("^click on the AA Volt Batteries$")
	public void click_on_the_AA_Volt_Batteries() throws Throwable {
		// click on the batter link
		searchResultsPageObjects.batteryProduct();
		getscreenshots();
	}

	@Then("^I Should see Checkout securely button$")
	public void verifyCheckoutSecurelyButton() throws IOException {
		// checkout securely button is verified
		WebElement checkoutbutton = searchResultsPageObjects.checkoutbutton();
		getscreenshots();
		Assert.assertTrue(checkoutbutton.isDisplayed());
		destroyDriver();
	}

	@When("^I click on 'Our Brands' link$")
	public void i_click_on_Our_Brands_link() throws Throwable {
		// our brand link is clicked
		homePageObjects.ourbrandlink();
		getscreenshots();
	}

	@When("^I select a brand from the list$")
	public void i_select_a_brand_from_the_list() throws Throwable {
		// specified brand is selected
		homePageObjects.selectBrand();
		getscreenshots();
	}

	@When("^I select a product from the list$")
	public void i_select_a_product_from_the_list() throws Throwable {
		// Obtained product are clicked
		searchResultsPageObjects.productClick();
		getscreenshots();

	}

	@When("^I select a product from the category$")
	public void i_select_a_product_from_the_category() throws Throwable {
		// Product are selected from category
		searchResultsPageObjects.batteryProduct();

	}

	@When("^enter the quantity and add it to basket$")
	public void enter_the_quantity_and_add_it_to_basket() throws Throwable {
		// quantity is provided and then click on the add button
		searchResultsPageObjects.Quantity();
		getscreenshots();
		searchResultsPageObjects.addbutton();

	}

	@When("^I click on View basket link$")
	public void i_click_on_View_basket_link() throws Throwable {
		// click on the basket button
		searchResultsPageObjects.basketbutton();
		getscreenshots();

	}

	@When("^I click on Clear all products link$")
	public void i_click_on_Clear_all_products_link() throws Throwable {
		// clear the all the products from basket
		searchResultsPageObjects.ClearAllProducts();
		searchResultsPageObjects.ConfirmButton();
		getscreenshots();

	}

	@Then("^My Basket Should Be Empty$")
	public void my_Basket_Should_Be_Empty() throws Throwable {
		// verify that the basket is empty

		WebElement clearBasket = searchResultsPageObjects.clearText();
		getscreenshots();
		Assert.assertTrue(clearBasket.isDisplayed());
		destroyDriver();

	}

}
