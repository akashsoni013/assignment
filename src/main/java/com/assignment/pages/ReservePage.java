package com.assignment.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.assignment.utils.Utility;

public class ReservePage {

	private Utility util;

	public ReservePage(WebDriver driver) {
		util = new Utility(driver);
	}

	public void selectFlight(String airLineName) {
		List<WebElement> flightList = util.getElements("airLineNames_xpath");
		WebElement element = null;
		String currentflight;
		for (int count = 1; count <= flightList.size(); count++) {
			element = flightList.get(count);
			currentflight = element.getText();
			if (currentflight.contentEquals(airLineName)) {
				List<WebElement> chooseFlightBtns = util.getElements("chooseFlight_xpath");
				chooseFlightBtns.get(count).click();
				break;
			}
		}
	}
}
