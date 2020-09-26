package com.project.poclases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.base.Base;

public class HomePage extends Base {

	/*
	 * Constructor
	 * 
	 * @author williams.vega
	 * 
	 * @param driver
	 * 
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Objects
	By link_chapter1 = By.xpath("//a[contains(text(), \"Chapter1\")]");

	/*
	 * Click Chapter 1
	 * 
	 * @author williams.vega
	 * 
	 */
	public void clickChapter1() throws IOException {
		takeScreenshot("TC001", "Click Chapter 1");
		reporterLog("Click Chapter 1");
		waitForElementPresent(link_chapter1);
		click(link_chapter1);
	}

}
