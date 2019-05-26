package com.iaditya.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import de.retest.recheck.*;

/**
 * Configuring a test method to run in multiple threads


 * @author adityai
 *
 */
public class IndependentTest 
{
	private WebDriver browser;
	private Recheck recheck;

	@BeforeMethod
	public void setUp() {
		recheck = new RecheckImpl();
		System.setProperty("webdriver.chrome.driver", "/opt/drivers/chromedriver");
		browser = new ChromeDriver();
	}

	@Test
	public void testMethod() 
	{
		recheck.startTest();

		browser.get("http://iaditya.herokuapp.com/prime");
		final WebElement href = browser.findElement(By.cssSelector(""));

		recheck.check(browser, "open");
		recheck.capTest();

		//		Assert.assertTrue(href.isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		browser.quit();
		recheck.cap();
	}
}