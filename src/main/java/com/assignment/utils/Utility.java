package com.assignment.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	private WebDriver driver;
	private GetObject getObject;

	public Utility(WebDriver driver) {
		this.driver = driver;
		getObject = new GetObject(driver);
	}

	public WebElement getElement(String objKey) {
		return getObject.findElement(objKey);
	}

	public boolean isElementPresent(String objKey) {
		try {
			getObject.findElement(objKey);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public List<WebElement> getElements(String objKey) {
		return getObject.findElements(objKey);
	}

	public void setText(String objKey, String value) {
		WebElement element = getObject.findElement(objKey);
		try {
			element.clear();
		} catch (Exception e) {

		}
		element.sendKeys(value);
	}

	public String getText(String objKey) {
		WebElement element = getObject.findElement(objKey);
		return element.getText();
	}
	
	public void click(String objKey) {
		WebElement element = getObject.findElement(objKey);
		element.click();
	}

	public void waitForVisibilityOfElement(String objKey, int seconds) {
		String locatorName = getObject.getLocatorName(objKey);
		String locator = getObject.getLocator(objKey);
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		try {
			if (locatorName.equalsIgnoreCase("XPATH")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			} else if (locatorName.equalsIgnoreCase("CSS")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			} else if (locatorName.equalsIgnoreCase("id")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void closeBrowser() {
		driver.close();
	}
}
