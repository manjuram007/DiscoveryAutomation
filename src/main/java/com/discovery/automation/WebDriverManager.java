package com.discovery.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.discovery.automation.Enum.DriverType;


public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";

	ConfigFileReader configfileReader = new ConfigFileReader();

	public WebDriverManager() {
		driverType = configfileReader.getBrowser();
			}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	//Initializing driver
	private WebDriver createDriver() {
		driver = createLocalDriver();
		return driver;
	}

	//For multiple browser
	private WebDriver createLocalDriver() {
		switch (driverType) {	    
		case FIREFOX : 
			System.setProperty(FIREFOX_DRIVER_PROPERTY, configfileReader.getDriverPath());
			driver = new FirefoxDriver();
			break;
		case CHROME : 
			System.setProperty(CHROME_DRIVER_PROPERTY, configfileReader.getDriverPath());
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER :
			System.setProperty(IE_DRIVER_PROPERTY, configfileReader.getDriverPath());
			driver = new InternetExplorerDriver();
			break;
		}

		if(configfileReader.getBrowserWindowSize()) driver.manage().window().maximize();
		return driver;
	}	

	//Quit the browser
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
