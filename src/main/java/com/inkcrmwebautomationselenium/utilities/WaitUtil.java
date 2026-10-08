package com.inkcrmwebautomationselenium.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil 
{
	WebDriver driver;

	public WaitUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void implicitWait(WebDriver driver , long waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}
	
	public <T> void explicitWait(WebDriver driver, long waitTime,ExpectedCondition <T> expCond)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		wait.until(expCond);
		
	}
	
	public void explicitWaitUsing(WebDriver driver,long waitTime, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWaitUsing(WebDriver driver,long waitTime, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTime)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
