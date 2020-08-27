package JobBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_7 extends CommonSteps{
	

	
  @Test (groups = { "Frontend" })
  public void postingJob() {
	  
	  System.out.println("Starting Activity 7: Create a new job listing");
	  navigateToPostJob();
	  signIn();
	  fillDetails();
	  verifyJobPOst();
  }
  
  public void navigateToPostJob() {
	  driver.findElement(By.xpath("//a[contains(text(),'Post a Job')]")).click();
	  String postjob = driver.findElement(By.id("post-5")).findElement(By.tagName("h1")).getText();
	  System.out.println(postjob);
	  Assert.assertEquals(postjob, "Post a Job","You are on the wrong page.");
  }
  
  public void signIn() {
	  driver.findElement(By.className("button")).click();
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
  }
  
  public void fillDetails() {
//	  driver.findElement(By.id("create_account_email")).sendKeys("sdet.training.batch2@alchemy.com");
	  driver.findElement(By.id("job_title")).sendKeys(JobTitle);
	  driver.findElement(By.id("job_location")).sendKeys("India");
	  Select jobtype = new Select(driver.findElement(By.id("job_type")));
	  jobtype.selectByVisibleText("Full Time");
	  
	  driver.switchTo().frame("job_description_ifr");
	  driver.findElement(By.id("tinymce")).sendKeys("IBM SDET Batch 2 Training Test Job");
	  driver.switchTo().defaultContent();
	  driver.findElement(By.id("application")).clear();
	  driver.findElement(By.id("application")).sendKeys("https://alchemy.hguy.co/");
	  driver.findElement(By.id("company_name")).clear();
	  driver.findElement(By.id("company_name")).sendKeys("Alchemy IBM");
	  driver.findElement(By.id("company_tagline")).sendKeys("Alchemy IBM Testing");
	  driver.findElement(By.name("submit_job")).click();
	  
	  //Submitting the Job Listing
	  
	  
	  String JobtitleNew = driver.findElement(By.xpath("//div[contains(@class,'job_listing_preview_title')]//following-sibling::div")).findElement(By.tagName("h1")).getText();
	  Assert.assertEquals(JobtitleNew, JobTitle, "An Error has Occured: "+JobtitleNew );
	  driver.findElement(By.id("job_preview_submit_button")).click();
	  
	  String success = driver.findElement(By.xpath("//div[contains(@class,'entry-content clear')]")).getText();
	  Assert.assertEquals(success, "Job listed successfully. To view your listing click here.");
  }
 
  public void verifyJobPOst() {
	  driver.findElement(By.xpath("//li[@id='menu-item-24']/a[contains(text(),'Jobs')]")).click();

	  String expectedEmail = "To apply for this job please visit alchemy.hguy.co.";
	  WebDriverWait wait = new WebDriverWait(driver, 40);
	  driver.findElement(By.id("search_keywords")).sendKeys(JobTitle);
	  driver.findElement(By.className("search_submit")).findElement(By.tagName("input")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[contains(@class,'job_listings')]/li)[1]")));
	  driver.findElement(By.xpath("(//ul[contains(@class,'job_listings')]/li)[1]")).click();
	  driver.findElement(By.xpath("//input[contains(@value,'Apply for job')]")).click();
	  String email = driver.findElement(By.className("application_details")).findElement(By.tagName("p")).getText();
	  Assert.assertEquals(email, expectedEmail);
  }
}
