package com.iaditya.testng.parallelsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Configuring a test method to run in multiple threads


 * @author adityai
 *
 */
public class IndependentTest 
{
    @Test
    public void testMethod() 
    {
        Long id = Thread.currentThread().getId();
        System.out.println("Test method executing on thread with id: " + id);
		System.setProperty("webdriver.chrome.driver", "/opt/drivers/chromedriver");
		WebDriver browser = new ChromeDriver();
		browser.get("https://iaditya.herokuapp.com/ai");
	    WebElement href = browser.findElement(By.xpath("//*[@id=\"container\"]/div/ul/li[3]/div"));
	    Assert.assertTrue((href.isDisplayed()));

		browser.close();       

    }
}