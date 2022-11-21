package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.BasePage;

public class TravelPage extends BasePage{
	
	@FindBy(linkText = "https://phptavels.net/login")
	public WebElement travelLink;

	
	@FindBy(xpath = "//*[@class='modal-title title']")
	public WebElement loginText;
	
	@FindBy(name = "email")
	public WebElement userName;
	
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(xpath = "//*[@class='ladda-label' and text()='Login']")
	public WebElement loginBtn;
	
	@FindBy(xpath = "//*[@class='author__meta']")
	public WebElement userTitle;
	
	@FindBy(xpath = "//*[@class='mb-0']")
	public WebElement demoPageText;
	
	
	
	
	
	
	public TravelPage() {
		PageFactory.initElements(driver, this);
	}
}
