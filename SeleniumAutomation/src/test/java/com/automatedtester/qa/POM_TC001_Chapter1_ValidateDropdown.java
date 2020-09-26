package com.automatedtester.qa;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.project.base.Base;
import com.project.base.GlobalVariables;
import com.project.poclases.ChapterOnePage;
import com.project.poclases.HomePage;

public class POM_TC001_Chapter1_ValidateDropdown {

	WebDriver driver;
	Base base;
	HomePage home;
	ChapterOnePage chapter1;
	String valueSeleniumType; 

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		base = new Base(driver);
		driver = base.chromedriverConnection();
		home = new HomePage(driver);
		chapter1 = new ChapterOnePage(driver);
		
		//Get Data from JSON file
		this.valueSeleniumType = base.getJSONValue(this.getClass().getSimpleName(), "seleniumType");
	}

	@Test
	public void TC001() throws IOException {
		//STEP 1
		base.launchBrowser(GlobalVariables.SELENIUM_MAIN_URL);
		
		//STEP 2
		home.clickChapter1();
		
		//STEP 3
		chapter1.clickRadio();
		
		//STEP 4
		chapter1.selectTypeSelenium(valueSeleniumType);
		
		//STEP 5
		chapter1.navigateHomePage();
		
	}

	@AfterTest
	public void afterTest() {
		base.closeBrowser();
	}

}
