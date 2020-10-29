package com.assignment.pages;

import org.openqa.selenium.WebDriver;

import com.assignment.utils.Utility;

public class PurchasePage {

	private Utility util;

	public PurchasePage(WebDriver driver) {
		util = new Utility(driver);
	}

	public void enterName(String name) {
		util.setText("name_xpath", name);
	}

	public void enterAddress(String address) {
		util.setText("address_xpath", address);
	}

	public void enterCity(String city) {
		util.setText("city_xpath", city);
	}

	public void enterState(String state) {
		util.setText("state_xpath", state);
	}

	public void enterZipCode(String zipCode) {
		util.setText("zipcode_xpath", zipCode);
	}

//	public void enterCardType(String cardType) {
//		util.setText(objKey, cardType);
//	}

	public void enterCreditCardNumber(String creditCardNumber) {
		util.setText("creditCardNumber_xpath", creditCardNumber);
	}

	public void enterMonth(String month) {
		util.setText("month_xpath", month);
	}

	public void enterNameonCard(String nameonCard) {
		util.setText("nameonCard_xpath", nameonCard);
	}

	public void enterYear(String year) {
		util.setText("year_xpath", year);
	}

	public void selectRememberMe(String rememberMe) {
		if (rememberMe.equalsIgnoreCase("yes")) {
			util.click("rememberMe_xpath");
		}
	}

	public void clickPurchaseFlight() {
		util.click("purchaseFlight_xpath");
	}

}
