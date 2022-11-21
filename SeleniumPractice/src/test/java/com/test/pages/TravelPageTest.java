package com.test.pages;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.test.base.BasePage;
import com.test.utill.CommonMethods;

public class TravelPageTest extends BasePage{

	SoftAssert sAsert;
	CommonMethods cm;
	TravelPage tp;

	public TravelPageTest() {
		super();
	}


	@BeforeMethod(alwaysRun = true)
	public void setup() {
		sAsert = new SoftAssert();
		cm = new CommonMethods();
		tp = new TravelPage();
	}


	@Test(groups = {"Regression"})
	public void VerifyCoustomerTravelPage()  {

		Boolean tapOnTravelLink = cm.Openlinks(tp.travelLink);
		sAsert.assertTrue(tapOnTravelLink, "Customer Account Link not clickable");

		//Handle another tap

		String mainWindow = driver.getWindowHandle();

		Set<String> allTab= driver.getWindowHandles();
		Iterator<String> iterator= allTab.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if(!mainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-title title']")));

				String LoginText = cm.GetAvailableText(tp.loginText);
				sAsert.assertEquals(LoginText, "Login", "Login header text didn't matched");

				Boolean addUserName = cm.addValue(tp.userName, prop.getProperty("UserName"));
				sAsert.assertTrue(addUserName, "UserName field not clickable");

				Boolean addPassword = cm.addValue(tp.password, prop.getProperty("Password"));
				sAsert.assertTrue(addPassword, "Password field not clickable");

				Boolean tapOnLogin = cm.Openlinks(tp.loginBtn);
				sAsert.assertTrue(tapOnLogin, "Login Link not clickable");
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/*[@class='author__meta']")));
				
				String UserProfileWlcmMsg = cm.GetAvailableText(tp.userTitle);
				sAsert.assertEquals(UserProfileWlcmMsg, "Welcome Back", "User Title text didn't matched");

				driver.close();

			}
		}

		driver.switchTo().window(mainWindow);

		String HomePageTet = cm.GetAvailableText(tp.demoPageText);
		sAsert.assertEquals(HomePageTet, "PHPTRAVELS Demo", "Demo page text didn't matched");

		sAsert.assertAll();

	}


}
