package com.RS.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.jetty.util.log.Log;

public class PropertyFileReadUtil {
	Properties prop;
	Properties properties;

	final String propConfigFile = System.getProperty("user.dir")
			+ "\\config.properties";

	private String driverType, appURL, chromedrivepath;

	/**
	 * @throws IOException
	 *             Reading the properties from the properties file
	 */
	public PropertyFileReadUtil() throws IOException {
		try {
			this.properties = new Properties();
			File file = new File(propConfigFile);
			FileInputStream ipstream = new FileInputStream(file);
			properties.load(ipstream);
			appURL = properties.getProperty("appURL");
			driverType = properties.getProperty("drivetype");
			chromedrivepath = properties.getProperty("chromepath");

		} catch (FileNotFoundException e) {
			Log.info("file is not found");
		}
	}

	/**
	 * @return the application URL
	 */
	public String getappurl() {
		return appURL;
	}

	/**
	 * @return the chrome driver path
	 */
	public String getchromedrivepath() {
		return chromedrivepath;
	}

	/**
	 * @return the browser type
	 */
	public String getdrivetype() {
		return driverType;
	}
}
