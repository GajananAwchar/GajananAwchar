package maven.selenium.testng;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpeedwayTechUrlValidate {
	WebDriver driver;
	@BeforeMethod
	public void loginWebsite() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aarya\\eclipse\\Eclipse Ide 2021 22\\firstProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule']")));
		boolean status =driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).isDisplayed();
		AssertJUnit.assertTrue(status);
		
	}
	@Test
	public void logout() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='welcome']")));
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		Thread.sleep(2000);
		WebElement ele= driver.findElement(By.xpath("//a[@href='/index.php/auth/logout']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
			boolean statusLogout  = driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		AssertJUnit.assertTrue(statusLogout);
	}
	@AfterMethod
	public void closeResources() {
		driver.close();

	}
}
