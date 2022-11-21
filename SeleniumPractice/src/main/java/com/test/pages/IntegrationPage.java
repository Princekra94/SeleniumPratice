package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.BasePage;

public class IntegrationPage extends BasePage{
	
	@FindBy(xpath = "//*[contains(@class,'jfHeader-menuListLink jfHeader-dynamicLink js-tracking js-i')]")
	public WebElement IntegrationLink;
	
	@FindBy(xpath = "//*[@class='jfHeader-subMenuItemLink js-tracking' and text()='Flights']")
	public WebElement flightsMenu;
	
	@FindBy(xpath = "//*[@data-text-name='kiwi']/span[1]")
	public WebElement KiwiMenu;
	
	
	@FindBy(xpath = "//*[@class='m0 name']")
	public WebElement KiwiHeaderText;
	
	
	public IntegrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
