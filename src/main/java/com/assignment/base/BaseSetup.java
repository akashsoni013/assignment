package com.assignment.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.assignment.utils.PropertiesUtil;

public abstract class BaseSetup {

	protected static WebDriver driver;
	protected static PropertiesUtil propUtil;

	@BeforeClass
	public void setupBase() {
		propUtil = new PropertiesUtil();
		String browserName = propUtil.getConfigurationValue("browser_name");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + propUtil.getConfigurationValue("system_property"));
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(propUtil.getConfigurationValue("url"));
	}
}
