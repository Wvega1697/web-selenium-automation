package com.project.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Base {
	/*
	 * Constructor WebDriver
	 * 
	 * @author williams.vega
	 * 
	 */
	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Chrome driver connection
	 * 
	 * @author williams.vega
	 * 
	 */
	public WebDriver chromedriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	/*
	 * Launch Browser
	 * 
	 * @author williams.vega
	 * 
	 * @param url
	 * 
	 */
	public void launchBrowser(String url) throws IOException {
		reporterLog("Launch Browser");
		driver.get("http://book.theautomatedtester.co.uk/");
		driver.manage().window().maximize();
		takeScreenshot("TC001", "Launch Browser");
		implicitWait(3);
	}

	/*
	 * Reporter log
	 * 
	 * @author williams.vega
	 * 
	 */
	public void reporterLog(String log) {
		Reporter.log(log);
	}

	/*
	 * Implicit Wait
	 * 
	 * @author williams.vega
	 * 
	 */
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/*
	 * Click Object
	 * 
	 * @author williams.vega
	 * 
	 * @param locator
	 * 
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	/*
	 * Wait for Element Present
	 * 
	 * @author williams.vega
	 * 
	 * @param locator
	 * 
	 */
	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.GENERAL_TIMEOUT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			reporterLog("Timeout error");
		}
	}

	/*
	 * Select value from dropdown by Value
	 * 
	 * @author williams.vega
	 * 
	 * @param locator, value
	 */
	public void selectByValueDropdown(By locator, String value) {
		waitForElementPresent(locator);
		WebElement element = driver.findElement(locator);
		Select dd_selenium = new Select(element);
		dd_selenium.selectByValue(value);
	}

	/*
	 * Close Browser
	 * 
	 * @author williams.vega
	 * 
	 */
	public void closeBrowser() {
		try {
			reporterLog("Close Browser");
			driver.close();
		} catch (NoSuchSessionException e) {
			reporterLog("Close Browser is failed");
		}
	}

	/*
	 * Get Data from JSON file (Directly)
	 * 
	 * @author Williams Vega
	 * 
	 * @param jsonFile, jsonKey
	 * 
	 * @return jsonValue
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) throws FileNotFoundException {
		try {
			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));
			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;
		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}

	/*
	 * Take screenshot
	 * 
	 * @author Williams Vega
	 * @param locator
	 * @return locator
	 * @throws IOException
	 */
	public void takeScreenshot(String testcase,String fileName) throws IOException {
		try {
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File("./test-output/screenshots/" + testcase + "/" + fileName + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}