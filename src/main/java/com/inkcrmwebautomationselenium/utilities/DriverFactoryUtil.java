package com.inkcrmwebautomationselenium.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryUtil 
{
	
	final static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	public static WebDriver getDriver(String browser)
	{
		if(driver.get()==null) 
		{
		switch(browser)
		{
		
		case "Chrome":
		{
			driver.set(new ChromeDriver());
			break;
		}
		
		case "Edge":
		{
			driver.set(new EdgeDriver());
			break;
		}
		
		case "Firefox":
		{
			driver.set(new FirefoxDriver());
			break;
		}
		
		default:
			throw new RuntimeException("No Browser");
		}
		driver.get().manage().window().maximize();
	
	}
	
	return driver.get();
}
	
	public static void closeDriver()
	{
		if(driver.get()!=null)
		{
			driver.get().close();
		}
	
		
	}

}
