package JobBoard;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_2 extends CommonSteps{
	
  @Test(groups = { "Frontend" })
  public void headingCheck() {
	  
	  System.out.println("Starting Activity 2: Read the heading of the website and verify the text");
	  String heading = driver.findElement(By.id("post-16")).findElement(By.tagName("h1")).getText();
	  System.out.println(heading);
	  Assert.assertEquals(heading, "Welcome to Alchemy Jobs","Heading does not match.");
	  
  }
}
