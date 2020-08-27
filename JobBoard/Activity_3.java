package JobBoard;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Activity_3 extends CommonSteps{
	
  @Test(groups = { "Frontend" })
  public void imageURL() {
	  
	  System.out.println("Starting Activity 3: Print the url of the header image to the console");
	  String img = driver.findElement(By.tagName("img")).getAttribute("src");
	  System.out.println(img);
  }
}
