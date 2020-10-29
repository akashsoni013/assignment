package com.assignment.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetObject {
	private WebDriver driver;
	private PropertiesUtil propUtil;
	
	
	public GetObject(WebDriver driver) {
		this.driver = driver;
		propUtil = new PropertiesUtil();
	}

	public WebElement findElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}
	
	public WebElement findElementBycss(String css) {
		return driver.findElement(By.cssSelector(css));
	}
	
	public List<WebElement> findElementsByXpath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}
	
	public List<WebElement> findElementsById(String id) {
		return driver.findElements(By.id(id));
	}
	
	public List<WebElement> findElementsBycss(String css) {
		return driver.findElements(By.cssSelector(css));
	}
	
	public String getLocator(String objKey) {
		return propUtil.getObjectRepVal(objKey);
	}
	
	public String getLocatorName(String objKey) {
		String[] arr = objKey.split("_");
		return arr[arr.length-1];
	}
	
	public WebElement findElement(String objKey) {
		String locatorName = getLocatorName(objKey);
		String locator = getLocator(objKey);
		WebElement element = null;
		
		try {
			if (locatorName.equalsIgnoreCase("XPATH")) {
				element = findElementByXpath(locator);
			}
			else if (locatorName.equalsIgnoreCase("CSS")) {
				element = findElementBycss(locator);
			}
			else if (locatorName.equalsIgnoreCase("id")) {
				element = findElementById(locator);				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return element;
	}
	
	public List<WebElement> findElements(String objKey) {
		String locatorName = getLocatorName(objKey);
		String locator = getLocator(objKey);
		List<WebElement> element = null;
		
		try {
			if (locatorName.equalsIgnoreCase("XPATH")) {
				element = findElementsByXpath(locator);
			}
			else if (locatorName.equalsIgnoreCase("CSS")) {
				element = findElementsBycss(locator);
			}
			else if (locatorName.equalsIgnoreCase("id")) {
				element = findElementsById(locator);				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return element;
	}

}
