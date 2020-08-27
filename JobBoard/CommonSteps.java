package JobBoard;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class CommonSteps {
	
	WebDriver driver;
	
	String JobTitle = "Test Specialist";
  
  @BeforeClass (groups = { "Frontend" }, alwaysRun=false)
  public void launchJobPortal() {
	  
	  //For Firefox driver
	  System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  
	  //For Chrome browser
	  /*System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	  driver = new ChromeDriver();*/
	  
	  driver.get("https://alchemy.hguy.co/jobs/");
	  driver.manage().window().maximize();
  }
  
  @BeforeClass (groups = { "Backend" }, alwaysRun=false)
  public void launchBackEnd() {
	  
		//For Firefox driver
		  System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  
		  //For Chrome browser
		  /*System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		  driver = new ChromeDriver();*/
		  
		  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		  driver.manage().window().maximize();
  }

  @AfterClass (alwaysRun=true)
  public void closeBrowser() {
	  driver.close();
  }

}
