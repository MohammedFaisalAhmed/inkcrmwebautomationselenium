package com.inkcrmwebautomationselenium.utilities;

import java.io.File;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebElementUIHelperUtil 
{
	WebDriver driver;
	WaitUtil waitUtil; 
	String mainWindow;
	
	public WebElementUIHelperUtil(WebDriver driver)
	{
		this.driver=driver;
		waitUtil= new WaitUtil(driver);
		mainWindow=driver.getWindowHandle();
	}
	
	public void clickWithImplicitWait(WebElement element)
	{
		waitUtil.implicitWait(driver, 10);
		element.click();
	}
	
	public void scrollDownClickWithExplicitWait(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		waitUtil.explicitWait(driver, 10, ExpectedConditions.visibilityOf(element));
		element.click();
		
	}
	
	public void scrollUpwithExplicitWait(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scollBy(0,-500)");
		waitUtil.explicitWait(driver, 20, ExpectedConditions.visibilityOf(element));
		element.click();
		
	}
	
	
    public void clickElementUsingJavaSriptExecutor(WebElement element)
    {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);",element);
    	js.executeScript("arguments[0].click();", element);
    	element.click();
    }
    
    public void switchToNewWindow()
    {
    	Set<String> windowHandles=driver.getWindowHandles();
    	for(String windowHandle:windowHandles)
    	{
    		if(!windowHandle.equals(mainWindow))
    		{
    			driver.switchTo().window(windowHandle);
    		}
    		}
    }
    	
    	public void switchToMainWindow()
    	{
    		driver.switchTo().window(mainWindow);
    	}
    	
    	public void assertPresenceOfElement(WebElement element)
    	{
    		waitUtil.explicitWait(driver, 10, ExpectedConditions.visibilityOf(element));
    	   Assert.assertEquals(element.isDisplayed(),true);
    	
    	}
	
    	public void acceptAlert()
    	{
    		Alert a = driver.switchTo().alert();
    		a.accept();
    		
    	}

    	public void dismissAlert()
    	{
    		Alert a = driver.switchTo().alert();
    		a.dismiss();
    	}
    	
    	public void getText()
    	{
    		Alert a =driver.switchTo().alert();
    		a.getText();
    	}
    	
    	public void assertElementText(WebElement element,String expectedText)
    	{
    		waitUtil.explicitWait(driver, 10, ExpectedConditions.visibilityOf(element));
    		Assert.assertEquals(element.getText(),expectedText);
    	}
	
    	public boolean isElementDisplayed(WebElement element)
    	{
    		try
    		{
    			return element.isDisplayed();
    		}
    		catch(Exception e)
    		{
    			return false;
    		}
    	}
    	
    	public boolean isElementEnabled(WebElement element)
    	{
    	try
    	{
    		return element.isEnabled(); 
    	}
    	catch(Exception e)
    	{
    		return false;
    		
    	}

    	}
	
	
    	public boolean isElementSelected(WebElement element)
    	{
    		
    		try
    		{
    			return element.isSelected();
    		}
    		catch(Exception e)
    		{
    			return false;
    		}
    	}
    	
    	public void switchToFrameByIndex(int index)
    	{
    		driver.switchTo().frame(index);
    	}
    	
    	public void switchToFrameByName(String frameName)
    	{
    		driver.switchTo().frame(frameName);
    	}
    	public void switchToFrameByWebElement(WebElement frameElement)
    	{
    		driver.switchTo().frame(frameElement);
    	}
    	
    	public void switchTodefaultContent()
    	{
    		driver.switchTo().defaultContent();
    	}
	
    	public void switchToParentFrame()
    	{
    		driver.switchTo().parentFrame();
    	}
    	
  public void selectByVisibleText(WebElement element, String value)
  {
	  Select select = new Select(element);
	  select.selectByVisibleText(value);
	  
  }
  
  public void selectByValue(WebElement element, String value)
  {
	  Select select = new Select(element);
	  select.selectByValue(value); 
  }
  
  public void selectByIndex(WebElement element, int index)
  
  {
	  Select select = new Select(element);
	  select.selectByIndex(index); 
  }
    	
  public void mouseHover(WebElement element)
  {
	  Actions action = new Actions(driver);
	  action.moveToElement(element).perform();
	  
  }
  
  public void doubleClick(WebElement element)
  {
	  Actions action = new Actions(driver);
	  action.doubleClick().perform();
  }
  
  public void rightClick(WebElement element)
  {
	  Actions action = new Actions(driver);
	  action.contextClick(element).perform();
  }
  
  public void dragAndDrop(WebElement source, WebElement taget)
  {
	  Actions action= new Actions(driver);
	  action.dragAndDrop(source, taget).perform();
  }
    	
  public void pressEnter()
  {
	 Actions action = new Actions(driver);
	 action.sendKeys(Keys.ENTER).perform();
  }
  
  public void pressTab()
  {
	  Actions action = new Actions(driver);
	  action.sendKeys(Keys.TAB).perform();
  }
  
  public void captureScreenshot(String screenshotName)
  {
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File source =ts.getScreenshotAs(OutputType.FILE);
  }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
}

