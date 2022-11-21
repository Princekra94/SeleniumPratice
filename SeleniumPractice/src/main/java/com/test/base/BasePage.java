package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;



public class BasePage {

	public static WebDriver driver;
	public static Properties prop;


	public BasePage() {

		try {

			prop = new Properties();
			FileInputStream fip = new FileInputStream("../SeleniumPractice/src/main/java/com/test/config/demo.properties");
			prop.load(fip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			e.getMessage();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@BeforeSuite
	public void deleteScreenShots() {
		File f = new File("../SeleniumPractice/FailureScreenshots");
		String[] s = f.list();
		for(String s1:s) {
			File f1 = new File(f,s1);
			f1.delete();
		}
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	@Parameters(value="browser")
	public static void setupBrowser(String browser){

		try {
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println("\n"+"****EXECUTING Test SCRIPT ON FIREFOX BROWSER****");
				driver = new FirefoxDriver();

			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.out.println("\n"+"****EXECUTING Test SCRIPT ON CHROME BROWSER****");
				
				ChromeOptions handlingSSL = new ChromeOptions();

				handlingSSL.setAcceptInsecureCerts(true);
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("safari")){
				System.out.println("\n"+"****EXECUTING Test SCRIPT ON Safari BROWSER****");
				driver = new SafariDriver();
			}

			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}


	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	}

	
	

}
