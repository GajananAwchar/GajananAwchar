package com.testng.practice;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
public class SecondTest {
	WebDriver driver;
	@Parameters("url")
	@BeforeMethod
	public void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Parameters("orangeHrmExpTitle")
	@Test(priority=0)
	public void orangeHrmTitleValidateUrl(String orangeHrmExpTitle) {
		
		String orangeHrmActualTitle = driver.getTitle();
		Assert.assertEquals(orangeHrmActualTitle, orangeHrmExpTitle, "Title is not matched");
		}
	@Parameters({"username" ,"password"})
	@Test(priority=1)
	public void loginWebsite(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule']")));
		boolean status =driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).isDisplayed();
		Assert.assertTrue(status);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/index.php/auth/logout']")));
		driver.findElement(By.xpath("//a[@href='/index.php/auth/logout']")).click();
			boolean statusLogout  = driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		Assert.assertTrue(statusLogout);	
	}
	@AfterMethod
	public void closeResources() {
		driver.close();
	}

	

}
