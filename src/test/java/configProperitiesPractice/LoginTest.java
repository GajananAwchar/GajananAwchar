package configProperitiesPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void launchUrlTest(String browser) {
		System.out.println("The current browser is"+browser);
			
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				}
			else if(browser.equals("opera")) {
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				driver.manage().window().maximize();
				}
			else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				}
			else if(browser.equals("edge")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				}
}
	@Parameters({"url","username" ,"password"})
	@Test
	public void loginWebsite(String url ,String username, String password) throws Exception {
		driver.get(url);
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule']")));
		boolean status =driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).isDisplayed();
		Assert.assertTrue(status);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/index.php/auth/logout']")).click();
			boolean statusLogout  = driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		Assert.assertTrue(statusLogout);	}


@AfterTest
public void close() {
driver.quit();	
}}
