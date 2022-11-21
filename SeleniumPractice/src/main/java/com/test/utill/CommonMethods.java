package com.test.utill;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.test.base.BasePage;

public class CommonMethods extends BasePage{


	public void takeScreenshot(String testMethod) {


		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcFile, new File("../SeleniumPractice/FailureScreenshots/"+testMethod+"_"+System.currentTimeMillis()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public String GetAvailableText(WebElement getText)  {
		String text = null;
		WebElement availableText = getText;
		if (availableText != null && availableText.isDisplayed()) {
			try {
				Thread.sleep(1000);
				text = availableText.getText();
				System.out.println("Available Text:  " + text);

			} catch (InterruptedException e) {
				e.printStackTrace();
				e.getMessage();
			}
		}
		return text;
	}


	public boolean isPagedisplaying(WebElement links) {
		boolean open = false;
		WebElement pageLink = links;
		if (pageLink != null && pageLink.isDisplayed()) {
			String ele =	pageLink.getText();
			System.out.println("\n"+ele);
			open = true;
		}
		return open;
	}


	public boolean Openlinks(WebElement link){
		boolean	clickOnLink = false;

		try {
			Thread.sleep(100);
			link.click();
			clickOnLink = true;

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();

		}
		return clickOnLink;

	}

	public boolean addValue(WebElement link, String text){
		boolean	clickOnLink = false;

		try {
			Thread.sleep(100);
			link.sendKeys(text);

			clickOnLink = true;

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();

		}
		return clickOnLink;

	}

}
