/*package com.automatedtester.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_Chapter1_ValidateDropdown {

  @BeforeTest
  public void beforeTest() {
  }

  @Test
  public void TC001() {
	  //Step 1
	  Reporter.log("Launch automatedtester app");
	  System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://book.theautomatedtester.co.uk/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //Step 2
	  Reporter.log("Click link Chapter 1");
	  driver.findElement(By.xpath("//a[contains(text(), \"Chapter1\")]")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='radiobutton']")));
	  
	  //Step 3
	  Reporter.log("Check Radio button");
	  driver.findElement(By.xpath("//input[@id='radiobutton']")).click();
	  
	  //Step 4
	  Reporter.log("Select \"Selenium Core\" from dropdown");
	  Select dd_selenium = new Select(driver.findElement(By.xpath("//select[@id='selecttype']")));
	  dd_selenium.selectByValue("Selenium Code");
	  
	  //Step 5
	  Reporter.log("");
	  driver.findElement(By.xpath("//a[contains(text(), \"Home Page\")]"));
	  
	  //Step 6
	  Reporter.log("");
	  
	  
  }
  
  @AfterTest
  public void afterTest() {
  }

}
*/