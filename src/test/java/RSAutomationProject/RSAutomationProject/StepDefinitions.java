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

	@Given("^User on the RS homepage$")
	public void navigateToHomePage() throws Throwable {
		// Open the browser and navigate to the URL
		driver = createWebdriver();
		homePageObjects = new HomePageObjects(driver);
		searchResultsPageObjects = new SearchResultsPageObjects(driver);
		String path = System.getProperty("user.dir");
		getscreenshots();
	}

	@When("^User search for a product by \"([^\"]*)\" brand$")
	public void SearchForAProductByBrand(String arg1) throws Throwable {
		// search for the product by using brand name via search field
		homePageObjects.searchField(arg1);
		homePageObjects.searchButton();
		getscreenshots();
	}

	@Then("^Products from the specified brand should be retrieved$")
	public void ProductsFromTheSpecifiedBrandShouldBeRetrieved()
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

	@When("^User search for a product by \"([^\"]*)\" Mfr\\. Part No\\.$")
	public void searchForProductByMfrPartNo(String arg1)
			throws Throwable {
		// search the product by manufacture part number
		homePageObjects.searchField(arg1);
		homePageObjects.searchButton();
		getscreenshots();
	}

	@Then("^Product Details Page With The Specified Mfr\\. Part No\\. Should Be Opened$")
	public void verifiedDetailsPageForProductWithTheSpecifiedMfrPartNo()
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

	@When("^User search for a product by \"([^\"]*)\" RS Stock No\\.$")
	public void searchForProductByRsStockNo(String arg1)
			throws Throwable {
		// search product by RS stock number
		homePageObjects.searchField(arg1);
		homePageObjects.searchButton();
		getscreenshots();
	}

	@Then("^Product Details Page With The Specified RS Stock No\\. Should Be Opened$")
	public void verifiedDetailsPageForProductWithTheSpecifiedRSStockNo()
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

	@When("^User click on the All Products link$")
	public void ClickOnOurProductslink() throws Throwable {
		// Product link is clicked
		homePageObjects.allproductsLink();
		getscreenshots();
	}

	@When("^User click on the Non-Rechargeable Batteries on Batteries mouseover$")
	public void ClickOnNonRechargeableBatteriesLink()
			throws Throwable {
		// Sub option link is clicked
		homePageObjects.batteriesLink();
		getscreenshots();
		Thread.sleep(3000);
		homePageObjects.nonrechargeablebatteriesLink();
		getscreenshots();

	}

	@Given("^User click on the AA Volt Batteries$")
	public void ClickOnAAVoltBatteries() throws Throwable {
		// click on the batter link
		searchResultsPageObjects.batteryProduct();
		getscreenshots();
	}

	@Then("^User Should see Checkout securely button$")
	public void verifyCheckoutSecurelyButton() throws IOException {
		// checkout securely button is verified
		WebElement checkoutbutton = searchResultsPageObjects.checkoutbutton();
		getscreenshots();
		Assert.assertTrue(checkoutbutton.isDisplayed());
		destroyDriver();
	}

	@When("^User click on 'Our Brands' link$")
	public void ClickOnOurBrandslink() throws Throwable {
		// our brand link is clicked
		homePageObjects.ourbrandlink();
		getscreenshots();
	}

	@When("^User select a brand from the list$")
	public void SelectBrandFromList() throws Throwable {
		// specified brand is selected
		homePageObjects.selectBrand();
		getscreenshots();
	}

	@When("^User select a product from the list$")
	public void SelectProductFromList() throws Throwable {
		// Obtained product are clicked
		searchResultsPageObjects.productClick();
		getscreenshots();

	}

	@When("^User select a product from the category$")
	public void SelectProductFromCategory() throws Throwable {
		// Product are selected from category
		searchResultsPageObjects.batteryProduct();

	}

	@When("^enter the quantity and add it to basket$")
	public void EnterQuantityAndAddToBasket() throws Throwable {
		// quantity is provided and then click on the add button
		searchResultsPageObjects.Quantity();
		getscreenshots();
		searchResultsPageObjects.addbutton();

	}

	@When("^User click on View basket link$")
	public void ClickOnViewBasketLink() throws Throwable {
		// click on the basket button
		searchResultsPageObjects.basketbutton();
		getscreenshots();

	}

	@When("^User click on Clear all products link$")
	public void verifyClearAllProductAndUpdateButtons() throws Throwable {
		// clear the all the products from basket
		searchResultsPageObjects.ClearAllProducts();
		searchResultsPageObjects.ConfirmButton();
		getscreenshots();

	}

	@Then("^My Basket Should Be Empty$")
	public void VerifyMyBasket() throws Throwable {
	// verify that the basket is empty
		WebElement clearBasket = searchResultsPageObjects.clearText();
		getscreenshots();
		Assert.assertTrue(clearBasket.isDisplayed());
		destroyDriver();

	}

}
