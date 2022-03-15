package configProperitiesPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadProperties {
	/*sequential testing on different browsers selection as per .properties file here using properties
	Properties is a subclass of Hash table. It is used to maintain lists of values
	in which the key is a String and the value is also a String.
	use # before any properties name to igore it in .properties file
	This properties file concept is used by dev., QA , also use. to store dev., QA environment value eg. login object, home page object, sign up page object, 
	search page object,  like this we can segreegate objects..
	But this approach is useful in only limited pages.. for large pages.. there can be hundread of object... it will become completed... 
	useful in limited pages object storing in .properties....
	  */

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = null;
		// properties class object
		Properties prop =new Properties();
		// fileInputStreamObject to access .properties file through path
		FileInputStream ip = new FileInputStream("C:\\Users\\Aarya\\eclipse\\Eclipse Ide 2021 22\\maven.selenium.testng\\src\\test\\java\\"
				+ "configProperitiesPractice\\config.properties");
		// access properties file by load method of properties class
		prop.load(ip);
		System.out.println(prop.getProperty("browser"));
		String browserName =prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {      // if we give two value for browser in properties file then 
			WebDriverManager.chromedriver().setup();       //  it will take first with alfabetically
			driver = new ChromeDriver();       // eg. browser = chrome and browser = opera... it will select chrome.. not rec. to use two value for same prop.
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();		
		}
		else if(browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.manage().window().maximize();
		}
		else {
			System.out.println("please select valid browser");	
		}
		// removing all hard coded value ... storing them in one place .properties file
		// by using properties class and fileInputStream class we can call all properties values stored with their name
		// it is easy to up date change in value in properties  which will get reflected here. 
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("username_NameXpath"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("password_NameXpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id(prop.getProperty("loginInBtn"))).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("welcomeLinkButton"))));
		driver.findElement(By.xpath(prop.getProperty("welcomeLinkButton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("LogutoutButtonXpath"))).click();
		driver.close();
	}
}
