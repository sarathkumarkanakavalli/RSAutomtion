package com.RS.pageobjects;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObjects {

	// Initialize the driver
	public WebDriver driver;

	// Identifying the web elements
	By SearchField = By.xpath("//*[@id=\"searchTerm\"]");
	By SearchButton = By.id("btnSearch");
	By AllproductsLink = By.linkText("All Products");
	By BatteriesLink = By.linkText("Batteries");
	By NonrechargeablebatteriesLink = By.linkText("Non-Rechargeable Batteries");
	By Ourbrandlink = By.linkText("Our Brands");
	By SelectBrand = By.xpath("//a[@class='sprite sprite-brand-2']");

	// Constructor to verify the right page is loaded
	public HomePageObjects(WebDriver driver) {

		this.driver = driver;

		Boolean isTitleCorrect = driver.getTitle().contains("Components");

		if (isTitleCorrect)
			Log.info("page loaded");
		else
			throw new RuntimeException("results page is not displayed");

	}

	/**
	 * @return
	 */
	public void searchField(String Brand) {
		driver.findElement(SearchField).sendKeys(Brand);

	}

	/**
	 * Search button is clicked
	 */
	public void searchButton() {
		driver.findElement(SearchButton).click();
	}

	/**
	 * All products link is clicked
	 */
	public void allproductsLink() {
		driver.findElement(AllproductsLink).click();
	}

	/**
	 * Our brand link is clicked
	 */
	public void ourbrandlink() {
		driver.findElement(Ourbrandlink).click();
	}

	/**
	 * Selected brand is clicked
	 */
	public void selectBrand() {
		driver.findElement(SelectBrand).click();
	}

	/**
	 * Selected battery link is clicked
	 */
	public void batteriesLink() {
		driver.findElement(BatteriesLink).click();
	}

	/**
	 * Selected link is clicked
	 */
	public void nonrechargeablebatteriesLink() {
		driver.findElement(NonrechargeablebatteriesLink).click();
	}

}
