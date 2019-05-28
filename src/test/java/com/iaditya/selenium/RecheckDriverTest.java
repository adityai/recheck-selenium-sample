package com.iaditya.selenium;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.web.selenium.RecheckDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Configuring a test method to run in multiple threads


 * @author adityai
 *
 */
public class RecheckDriverTest
{
	RecheckDriver driver;

	@BeforeMethod
	public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/drivers/chromedriver");
        driver = new RecheckDriver( new ChromeDriver() );
	}

	@Test
	public void testMethod() 
    {
		driver.get("http://iaditya.herokuapp.com/prime");
		WebElement primeTile = driver.findElementByCssSelector("div.widget.widget-text.prime");
        Assert.assertEquals(primeTile.isDisplayed(), true);
	}

	@AfterMethod
	public void tearDown() {
	    driver.quit();
	}
}