package JobBoard;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_4 extends CommonSteps{
	
  @Test(groups = { "Frontend" })
  public void secondHeadingCheck() {
	  
	  System.out.println("Starting Activity 4: Read the second heading of the website and verify the text");
	  String SecondHeading = driver.findElement(By.tagName("h2")).getText();
	  System.out.println(SecondHeading);
	  Assert.assertEquals(SecondHeading, "Quia quis non","Second Heading does not match.");
  }
}
