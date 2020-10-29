package com.assigment.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assignment.base.BaseSetup;
import com.assignment.pages.ConfirmationPage;
import com.assignment.pages.HomePage;
import com.assignment.pages.PurchasePage;
import com.assignment.pages.ReservePage;
import com.assignment.utils.PropertiesUtil;;

public class AssigmentScenarioTest extends BaseSetup {

	private HomePage homePage;
	private ReservePage reserve;
	private PurchasePage purchase;
	private ConfirmationPage confirmation;
	private String departureCity, destinationCity, airLineName, name, address, city, state, zipCode, cardType,
			creditCardNumber, month, nameonCard, year, rememberMe;

	@BeforeClass
	public void beforeClass() {
		homePage = new HomePage(driver);
		reserve = new ReservePage(driver);
		purchase = new PurchasePage(driver);
		confirmation = new ConfirmationPage(driver);
		propUtil = new PropertiesUtil();
	}

	public void getData() {
		departureCity = propUtil.getStringValue("departureCity");
		destinationCity = propUtil.getStringValue("destinationCity");
		airLineName = propUtil.getStringValue("airLineName");
		name = propUtil.getStringValue("name");
		address = propUtil.getStringValue("address");
		city = propUtil.getStringValue("city");
		state = propUtil.getStringValue("state");
		zipCode = propUtil.getStringValue("zipCode");
		cardType = propUtil.getStringValue("cardType");
		creditCardNumber = propUtil.getStringValue("creditCardNumber");
		month = propUtil.getStringValue("month");
		nameonCard = propUtil.getStringValue("nameonCard");
		year = propUtil.getStringValue("year");
		rememberMe = propUtil.getStringValue("rememberMe");
	}

	@Test(description = "Book a flight ticket")
	public void bookFlightTicket() {
		getData();
		homePage.selectDepartureCity(departureCity);
		homePage.selectDestinationCity(destinationCity);
		homePage.findFlights();
		reserve.selectFlight(airLineName);
		purchase.enterName(name);
		purchase.enterAddress(address);
		purchase.enterCity(city);
		purchase.enterState(state);
		purchase.enterZipCode(zipCode);
//		purchase.enterCardType(cardType);
		purchase.enterCreditCardNumber(creditCardNumber);
		purchase.enterMonth(month);
		purchase.enterYear(year);
		purchase.enterNameonCard(nameonCard);
		purchase.selectRememberMe(rememberMe);
		purchase.clickPurchaseFlight();
		Assert.assertTrue(confirmation.verifyPurchaseMessage(), "Confirm Thank you message");
		Assert.assertTrue(confirmation.verifyPurchaseId(), "Confirm Purchase Id");
	}
	
	@AfterClass
	public void tearDown() {
		homePage.close();
	}

}