package com.assignment.pages;

import org.openqa.selenium.WebDriver;

import com.assignment.utils.Utility;

public class ConfirmationPage {

	private Utility util;

	public ConfirmationPage(WebDriver driver) {
		util = new Utility(driver);
	}

	public void enterName(String name) {
		util.setText("name_xpath", name);
	}

	public boolean verifyPurchaseMessage() {
		return util.isElementPresent("purchaseMsg_xpath");
	}

	public boolean verifyPurchaseId() {
		String purchaseId = util.getText("ticketId_xpath");
		System.out.println(purchaseId);
		return purchaseId.length() == 13;
	}
}
