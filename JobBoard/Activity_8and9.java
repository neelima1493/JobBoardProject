package JobBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_8and9 extends CommonSteps{
	
  @Test(groups = { "Backend" })
  public void logintoBackend() {
	  
	  System.out.println("Starting Activity 8: Visit the site’s backend and login");
	  
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
	  Assert.assertEquals(driver.getTitle(), "Dashboard ‹ Alchemy Jobs — WordPress", "Not Logged In: "+ driver.getTitle());
  }
  
  @Test(dependsOnMethods = "logintoBackend", groups = { "Backend" })
  public void createJobListBackend() {
	  
	  System.out.println("Starting Activity 9: Visit the site’s backend and create a job listing");
	  navigateToJobsPost();
	  enterDetails();
	  verifyJobPosting();	
	  
  }
  
  
  
 public void navigateToJobsPost() {
	 driver.findElement(By.xpath("//div[contains(text(),'Job Listings')]")).click();
	  String pageTitle = driver.findElement(By.tagName("h1")).getText();
	  Assert.assertEquals(pageTitle, "Jobs");
	  driver.findElement(By.xpath("//h1/following-sibling::a")).click();
 }
 
 public void enterDetails() {
	 if(driver.findElement(By.xpath("//div[contains(@class,'components-modal__header')]//button")).isDisplayed()) {
		  driver.findElement(By.xpath("//div[contains(@class,'components-modal__header')]//button")).click();
	  }
	  
	  
	  driver.findElement(By.id("post-title-0")).sendKeys(JobTitle);
	  driver.findElement(By.xpath("//div[contains(@class,'block-editor-block-list__layout')]/div/div")).click();
	  driver.findElement(By.xpath("//div[contains(@class,'block-editor-block-list__layout')]/div/div/following-sibling::div"))
	  														.sendKeys("IBM SDET Batch 2 Training Test Job");
	  driver.findElement(By.id("_application")).clear();
	  driver.findElement(By.id("_application")).sendKeys("https://alchemy.hguy.co/");
	  driver.findElement(By.id("_job_location")).sendKeys("India");
	  driver.findElement(By.id("_company_name")).sendKeys("Alchemy IBM");
	  driver.findElement(By.id("_company_tagline")).sendKeys("Alchemy IBM Testing");
	  driver.findElement(By.id("_job_expires")).sendKeys("November 30, 2020");
	  

	  driver.findElement(By.xpath("//button[contains(text(),'Publish…')]")).click();
	  driver.findElement(By.xpath("//button[text()='Publish']")).click();
 }
 
 public void verifyJobPosting() {
	 WebDriverWait wait = new WebDriverWait(driver, 40);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='post-publish-panel__postpublish']")));
	  String successMessage = driver.findElement(By.xpath("//div[@class='post-publish-panel__postpublish']")).findElement(By.tagName("div")).getText();
	  System.out.println(successMessage);
	  Assert.assertEquals(successMessage, JobTitle+" is now live.");
	  driver.findElement(By.xpath("//a[contains(text(),'View Job')]")).click();
	  driver.findElement(By.xpath("//input[contains(@value,'Apply for job')]")).click();
	  String expectedEmail = "To apply for this job please visit alchemy.hguy.co.";
	  String email = driver.findElement(By.className("application_details")).findElement(By.tagName("p")).getText();
	  Assert.assertEquals(email, expectedEmail);
 }
}
