package maven.selenium.testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class NewTest {
	//maven.selenium.testng.NewTest
  @Test
  public void testCase1() {
	  System.out.println("This is first test case");
  }
  @BeforeSuite
  public void beforesuite() {
	  System.out.println("before suite conditions");
  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite conditions");
  }

  @Test(priority=1)
  public void testCase2() {
	  System.out.println("This is second test case");
  }
  @BeforeClass
  public void beforeclass() {
	  System.out.println("after class conditions");
  }
  @AfterClass
  public void afterclass() {
	  System.out.println("after class conditions");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("execute before method");
  }

  @AfterMethod
  public void afterMethod() {
System.out.println("execute after method");  }

}
