package JobBoard;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_1 extends CommonSteps{
	
	
  @Test(groups = { "Frontend" })
  public void titleCheck() {
	  
	  System.out.println("Starting Activity 1: Read the title of the website and verify the text");
	  System.out.println(driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application","Title does not match.");
  }
}
