package com.inkcrmwebautomationselenium.utilities;

import org.openqa.selenium.WebDriver;

public class WebElementUIHelperUtil 
{
	WebDriver driver;
	WaitUtil waitUtil; 
	
	public WebElementUIHelperUtil(WebDriver driver)
	{
		this.driver=driver;
		waitUtil= new WaitUtil(driver);
	}
	
	

}
