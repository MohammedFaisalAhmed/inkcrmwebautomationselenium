package com.inkcrmwebautomationselenium.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtil 
{
	static Properties properties;
	static String env;
	static String browser;
	
	public static void loadProperties() 
	{
		try
		{
			properties = new Properties();
			env=System.getProperty("env","dev");
			browser=System.getProperty("browser","chrome");
			FileInputStream fis = new FileInputStream("src/main/resources/configs/"+env+".properties");
			properties.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static String getProperty(String key)
	{
		loadProperties() ;
		return properties.getProperty(key);
		
		
	}
	
	public static String getEnvironment() 
	{
		loadProperties();
		return env;
		
	}
	public static String getBrowser()
	{
		loadProperties();
		return browser;
	}
	
	
	

}
