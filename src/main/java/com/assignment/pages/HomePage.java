package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.assignment.utils.Utility;

public class HomePage {
	
	Select city;
	private Utility util;

	public HomePage(WebDriver driver) {
		util = new Utility(driver);
	}

	public void selectDepartureCity(String departureCity) {
		city = new Select(util.getElement("selectDepartureCity_xpath"));
		city.selectByValue(departureCity);
	}

	public void selectDestinationCity(String destinationCity) {
		city = new Select(util.getElement("selectDestinationCity_xpath"));
		city.selectByValue(destinationCity);		
	}

	public void findFlights() {
		util.getElement("findFlights_xpath").click();
	}

	public void close() {
		util.closeBrowser();
	}

}
