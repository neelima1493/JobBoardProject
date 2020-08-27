package JobBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_5and6 extends CommonSteps{
  @Test (groups = { "Frontend" })
  public void navigateToJobs() {
	  
	  System.out.println("Starting Activity 5: Navigate to the “Jobs” page");
	  driver.findElement(By.xpath("//li[@id='menu-item-24']/a[contains(text(),'Jobs')]")).click();
	  String job = driver.findElement(By.id("post-7")).findElement(By.tagName("h1")).getText();
	  System.out.println(job);
	  Assert.assertEquals(job, "Jobs","You are on the wrong page.");
  }
  
  @Test (dependsOnMethods = { "navigateToJobs" }, groups = { "Frontend" })
  public void applyingForJob() {
	  
	  System.out.println("Starting Activity 6: Search for a job and apply for it");
//	  String JobTitle = "Test Special Engineer";
	  WebDriverWait wait = new WebDriverWait(driver, 40);
	  driver.findElement(By.id("search_keywords")).sendKeys(JobTitle);
	  driver.findElement(By.className("search_submit")).findElement(By.tagName("input")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[contains(@class,'job_listings')]/li)[1]")));
	  driver.findElement(By.xpath("(//ul[contains(@class,'job_listings')]/li)[1]")).click();
	  
	  String job = driver.findElement(By.tagName("h1")).getText();
	  System.out.println(job);
	  Assert.assertEquals(job, JobTitle);
	  
	  driver.findElement(By.xpath("//input[contains(@value,'Apply for job')]")).click();
	  String email = driver.findElement(By.className("application_details")).findElement(By.tagName("p")).getText();
	  System.out.println(email);
}
}
