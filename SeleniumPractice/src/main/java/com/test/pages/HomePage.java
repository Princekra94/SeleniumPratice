package com.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.test.base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(className = "jfHeader-logoLink")
	public WebElement logo;
	
	@FindBys(@FindBy(tagName = "a"))
	public List<WebElement> allLinks;
	
	@FindBy(id = "chat-widget-container")
	public WebElement liveChat;
	
	
	@FindBy(xpath = "//*[@class = 'lc-ptrtto e7bf83j3']")
	public WebElement wlcmMsg;
	
	@FindBy(xpath = "//*[@aria-label='Minimize window']")
	public WebElement minimizeWindow;
	
	
	
	
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
