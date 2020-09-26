package com.project.poclases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.project.base.Base;

public class ChapterOnePage extends Base {

	public ChapterOnePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Objects
	By rad_unique = By.xpath("//input[@id='radiobutton']");
	By dd_selenium = By.xpath("//select[@id='selecttype']");
	By link_homePage = By.xpath("//a[contains(text(), \"Home Page\")]");

	/*
	 * Click Radio Button
	 * 
	 * @author williams.vega
	 * 
	 */
	public void clickRadio() throws IOException {
		takeScreenshot("TC001", "Click Radio button");
		reporterLog("Click Radio button");
		waitForElementPresent(rad_unique);
		click(rad_unique);
	}

	/*
	 * Select dropdown by value in chapter 1
	 * 
	 * @author williams.vega
	 * 
	 * @value chapterValue
	 * 
	 */
	public void selectTypeSelenium(String chapterValue) throws IOException {
		takeScreenshot("TC001", "Select dropdown by value in chapter 1");
		reporterLog("Select dropdown by value in chapter 1");
		waitForElementPresent(dd_selenium);
		selectByValueDropdown(dd_selenium, chapterValue);
		implicitWait(2);
	}

	/*
	 * Navigate Home Page
	 * 
	 * @author williams.vega
	 * 
	 */
	public void navigateHomePage() throws IOException {
		takeScreenshot("TC001", "Navigate Home Page");
		reporterLog("Navigate Home Page");
		waitForElementPresent(link_homePage);
		click(link_homePage);
	}
}
