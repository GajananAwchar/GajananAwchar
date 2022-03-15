package maven.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpeedwatTech_Url_Validation {
	WebDriver driver;
	@BeforeMethod
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://speedwaytech.co.in/");
	}
	@Test
	public void validateUrl() {
		String currentUrl = driver.getCurrentUrl();
		String title =driver.getTitle();
		System.out.println("title is "+title);
		System.out.println(currentUrl);
		}
	@AfterMethod
	public void closeResources() {
		driver.close();
	}

}
