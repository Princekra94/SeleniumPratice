package com.test.pages;


import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.test.base.BasePage;
import com.test.utill.CommonMethods;

public class IntegrationPageTest extends BasePage{

	SoftAssert sAsert;
	CommonMethods cm;
	IntegrationPage ip;

	public IntegrationPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		sAsert = new SoftAssert();
		cm = new CommonMethods();
		ip = new IntegrationPage();
	}


	@Test(groups = {"Regression", "Smoke"})
	public void verifyKiwiModule_ActionClass() {


		Boolean IntLink= cm.Openlinks(ip.IntegrationLink);
		sAsert.assertTrue(IntLink, "Integration link not clickable");

		Actions action = new Actions(driver);

		action.moveToElement(ip.flightsMenu).perform();

		Boolean KiwiLink= cm.Openlinks(ip.KiwiMenu);
		sAsert.assertTrue(KiwiLink, "Kiwi link not clickable");

		

		sAsert.assertAll();

	}


}
