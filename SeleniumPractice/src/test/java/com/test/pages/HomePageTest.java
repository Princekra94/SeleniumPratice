package com.test.pages;



import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.test.base.BasePage;
import com.test.utill.CommonMethods;


public class HomePageTest extends BasePage {


	HomePage hp;
	SoftAssert sAsert;
	CommonMethods cm;

	public HomePageTest() {
		super();
		
	}

	@BeforeMethod (alwaysRun = true)
	public void setup() {
		sAsert = new SoftAssert();
		cm = new CommonMethods();
		hp = new HomePage();
	}

	@Test(priority = 0, groups = {"Regression", "Smoke"})
	public void VerifyHomePage() {

		String title = driver.getTitle();
		sAsert.assertEquals("Book Your Free Demo Now - Phptravels", title, "Title didn't match");

		String tct = cm.GetAvailableText(hp.logo);
		sAsert.assertEquals("PHPTRAVELS\n"
				+ "TRAVEL TECHNOLOGY PARTNER", tct, "Logo text didn't match");

		sAsert.assertAll();
	}


	@Test(groups = {"Regression"})
 	public void getAllLinks() {

		System.out.println("**************_Print available links on page_***************");
		List<WebElement> allAvailableLinks = hp.allLinks;
		for(WebElement link:allAvailableLinks){
			System.out.println(" ");
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
		System.out.println("*************_Above are the available links on page_************");

	}


	@Test(priority = 1,groups = { "Smoke"})
	public void VerifyChat() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat-widget-container")));

		Boolean liveChatLink = 	cm.Openlinks(hp.liveChat);
		sAsert.assertTrue(liveChatLink, "Chat icon not clickable");
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);

		
		String WelcomeMsg = cm.GetAvailableText(hp.wlcmMsg);
		sAsert.assertEquals(WelcomeMsg, "Welcome to LiveChat");
		
		if (WelcomeMsg!=null) {
			cm.Openlinks(hp.minimizeWindow);
		} else {
			System.out.println("Chat window doesn't open up");
		}
		
		driver.switchTo().defaultContent();

		sAsert.assertAll();
	}
	
	


}
