package com.automatedtester.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_Chapter1_ValidateDropdown {

  @BeforeTest
  public void beforeTest() {
  }

  @Test
  public void f() {
	  //Step 1
	  Reporter.log("Launch automatedtester app");
	  System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://book.theautomatedtester.co.uk/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }
  
  @AfterTest
  public void afterTest() {
  }

}
