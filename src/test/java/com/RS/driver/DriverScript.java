package com.RS.driver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.RS.utilities.PropertyFileReadUtil;

/**
 * @author Toshiba
 * 
 */
public class DriverScript {

	protected WebDriver driver = null;
	public String browser = null;

	/**
	 * @return the driver
	 * @throws Exception
	 */
	@BeforeTest
	public WebDriver createWebdriver() throws Exception {

		PropertyFileReadUtil propertyFileReadUtil = new PropertyFileReadUtil();
		browser = propertyFileReadUtil.getdrivetype();

		try {

			if (browser.equalsIgnoreCase("IE")) {
				DesiredCapabilities iedesiredCapabilities = DesiredCapabilities
						.internetExplorer();
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "/" + "IE.exe");
				iedesiredCapabilities.setJavascriptEnabled(true);
				// Initialize the IE driver
				driver = new InternetExplorerDriver();

			} else if (browser.equalsIgnoreCase("chrome")) {
				Log.info("enter chrome");

				DesiredCapabilities chromeCaps = DesiredCapabilities.chrome();
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/"
								+ "chromedriver.exe");
				chromeCaps.setJavascriptEnabled(true);
				// Initialize the Chrome driver
				driver = new ChromeDriver(chromeCaps);

			} else if (browser.equals("firefox")) {
				// Initialize the Firefox driver
				driver = new FirefoxDriver();
			} else {
				throw new Exception("we are not supporting a broswer");
			}
			Log.info(propertyFileReadUtil.getappurl());
			Log.info(propertyFileReadUtil.getappurl());
			// Opening the application URL
			driver.get(propertyFileReadUtil.getappurl());
			// Maximize the browser after opening with URL
			// driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Log.info("Launch the app" + driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return driver;
	}

	/**
	 * @throws IOException
	 *             Close and quit methods
	 */
	@AfterTest
	public void destroyDriver() throws IOException {
		driver.close();
		driver.quit();

	}

	/**
	 * Fetching the screenshots
	 */
	public void getscreenshots() {
		try {
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")
					+ "/Screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
