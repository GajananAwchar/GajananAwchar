package com.testng.practice;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	WebDriver driver;
	@BeforeMethod
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void speedwaytechUrlValidation() throws Exception  {
		driver.get("https://speedwaytech.co.in/");
		String ActualSpeedWayTitle= driver.getTitle();
		String expSpeedwayTitle = "Speed Way Tech – Speed Way Tech";
		AssertJUnit.assertEquals(ActualSpeedWayTitle, expSpeedwayTitle,"TItle is mismatched");
	}
	@Test
	public void hyrTutorialsUrlValidation() throws Exception  {
		driver.get("https://www.hyrtutorials.com/");
		String ActualHYRTitle = driver.getTitle();
		String expHYRTitle = "H Y R Tutorials - H Y R Tutorials";
		
		AssertJUnit.assertEquals(ActualHYRTitle, expHYRTitle,"Title is mismatched");
	}

	@Test
	public void orangeHrmUrlValidation() throws Exception  {
		driver.get("https://www.orangehrm.com/");
		String ActualHrmTitle = driver.getTitle();
		String expHrmTitle = "H Y R Tutorials - H Y R Tutorials";
		AssertJUnit.assertEquals(ActualHrmTitle, expHrmTitle,"Title is mismatched");
	}
	
	
	@AfterMethod
	public void closeResources() {
		driver.quit();
	}
}
