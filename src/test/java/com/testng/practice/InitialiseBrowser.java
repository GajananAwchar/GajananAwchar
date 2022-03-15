package com.testng.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class InitialiseBrowser {
	WebDriver driver;
	@Parameters("browserName")
	@BeforeTest
	public void browserSelect(String browserName) {
		// we can aslo use .contains() method
		switch(browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:
			System.err.println("Browser is invalid. Please provide valid Browser");
		}	}	
	@Parameters("url1")
		@Test
		public void speedwaytechUrlValidation(String url1) throws Exception  {
			driver.get(url1);
			String ActualUrl = driver.getCurrentUrl();
			String expectedUrl =url1;
			Assert.assertEquals(ActualUrl, expectedUrl, "Url is not matched");
	}
		@AfterTest
	public void close() {
			driver.close();
		}
	
	
}
