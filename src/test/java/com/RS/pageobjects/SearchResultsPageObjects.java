package com.RS.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Sarath
 *
 */
public class SearchResultsPageObjects {

	// Initialize the driver
	public WebDriver driver;

	// Identifying the web element
	By SearchBrand = By.xpath("//*[@id=\"galleryPopularCategory\"]/li");
	By ClickBrand = By.xpath("//*[@id=\"galleryPopularCategory\"]/li[1]/a");
	By Product = By.xpath("//a[contains(text(), 'ABB')]");
	By rsStockNo = By.xpath("//span[contains(text(), '870-0742')]");
	By productImage = By.xpath("//*[@id=\"mainImage\"]");
	By mfrPartNo = By.xpath("//span[contains(text(), 'DV164140-1')]");
	By ProductClick = By.xpath("//*[@id=\"galleryPopularCategory\"]/li[1]/a");
	By Quantity = By.id("atbQty-1");
	By Addbutton = By.id("atbBtn-1");
	By Basketbutton = By.xpath("(//i[@class='icon-cart'])[2]");
	By ClearAllProducts = By.xpath("//*[@id=\"clearBasketButton\"]");
	By ConfirmButton = By.xpath("//*[@id=\"confirmDeleteContinue\"]");
	By ClearText = By
			.xpath("//*[contains(text(),'You do not have any products in your basket')]");
	By BatteryProduct = By.linkText("AA Batteries");
	By Checkoutbutton = By.xpath("//*[@id=\"checkoutSecurelyAndPuchBtn\"]");

	public SearchResultsPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the search results
	 */
	public WebElement searchBrand() {
		WebElement searchResults = driver.findElement(SearchBrand);
		return searchResults;
	}

	/**
	 * Selected brand is clicked
	 */
	public void clickBrand() {
		driver.findElement(ClickBrand).click();
	}

	/**
	 * @return the chosen product
	 */
	public WebElement product() {
		WebElement product = driver.findElement(Product);
		return product;
	}

	/**
	 * @return the RS Stock Number
	 */
	public WebElement rsStockNo() {
		WebElement RSstockNo = driver.findElement(rsStockNo);
		return RSstockNo;
	}

	/**
	 * @return the Manufacture Part Number
	 */
	public WebElement mfrPartNo() {
		WebElement MFRPartNo = driver.findElement(mfrPartNo);
		return MFRPartNo;
	}

	/**
	 * @return the product Image
	 */
	public WebElement productImage() {
		WebElement ProductImage = driver.findElement(productImage);
		return ProductImage;
	}

	/**
	 * Click the chosen product
	 */
	public void productClick() {
		driver.findElement(ProductClick).click();
	}

	/**
	 * Enter the provided quantity
	 */
	public void Quantity() {
		driver.findElement(Quantity).clear();
		driver.findElement(Quantity).sendKeys("20");
	}

	/**
	 * click on the add button
	 */
	public void addbutton() {
		driver.findElement(Addbutton).click();
	}

	/**
	 * click on the basket button
	 */
	public void basketbutton() {
		driver.findElement(Basketbutton).click();
	}

	/**
	 * clearing all the products
	 */
	public void ClearAllProducts() {
		driver.findElement(ClearAllProducts).click();
	}

	/**
	 * click on the confirm button
	 */
	public void ConfirmButton() {
		driver.findElement(ConfirmButton).click();
	}

	/**
	 * @return the text to verify
	 */
	public WebElement clearText() {
		WebElement clearText = driver.findElement(ClearText);
		return clearText;

	}

	/**
	 * click on the battery product
	 * 
	 * @throws InterruptedException
	 */
	public void batteryProduct() throws InterruptedException {

		driver.findElement(BatteryProduct).click();
	}

	/**
	 * @return the checkout securely button
	 */
	public WebElement checkoutbutton() {
		WebElement checkoutbutton = driver.findElement(Checkoutbutton);
		return checkoutbutton;

	}

}
