package utils;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testexecution.Base;

public class LoadProperty extends Base
{
	Properties prop=null;
	By byObj;
	
	public LoadProperty(String Location)
	{
		 prop=new Properties();
		 try {
			prop.load(new FileInputStream(Location));
		 	} catch (Exception e) 
			{
		 		System.out.println("Error with Property file");			
		 		
			} 
	}
	public LoadProperty(String Location,WebDriver driver)
	{	
		this(Location);
		this.driver=driver;
	}
	
	public   String getProp(String Key)
	{
		return prop.getProperty(Key);
	}
	
	public   WebElement getElementProp(String Key)
	{
		WebElement Element=null;
		String LocatorType=prop.getProperty(Key).split(":")[1];
		String LocatorValue=prop.getProperty(Key).split(":")[0];
		System.out.println(LocatorValue);

		if(LocatorType.equalsIgnoreCase("id"))
		{
			byObj = By.id(LocatorValue);
			Element=driver.findElement(By.id(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("name"))
		{
			byObj = By.name(LocatorValue);
			Element=driver.findElement(By.name(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("css"))
		{
			byObj = By.cssSelector(LocatorValue);
			Element=driver.findElement(By.cssSelector(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("linktext"))
		{
			byObj = By.linkText(LocatorValue); 
			Element=driver.findElement(By.linkText(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			byObj = By.xpath(LocatorValue);
			Element=driver.findElement(By.xpath(LocatorValue));
		}
		else if (LocatorType.equalsIgnoreCase("classname"))
		{
			byObj = By.className(LocatorValue);
			Element=driver.findElement(By.className(LocatorValue));

		}
		else 
			System.out.println("invalid locator");
		
		
		return Element;
		
	}
	public By getByObj()
	{
		return byObj;
	}
	public   List<WebElement> getElementsProp(String Key)
	{
		List<WebElement> Element=null;
		String LocatorType=prop.getProperty(Key).split(":")[1];
		String LocatorValue=prop.getProperty(Key).split(":")[0];
		

		if(LocatorType.equalsIgnoreCase("id"))
		{
			Element=driver.findElements(By.id(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("name"))
		{
			Element=driver.findElements(By.name(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("css"))
		{
			Element=driver.findElements(By.cssSelector(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("linktext"))
		{
			Element=driver.findElements(By.linkText(LocatorValue));
		}
		else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			Element=driver.findElements(By.xpath(LocatorValue));
		}
		else 
			System.out.println("invalid locator");
		
		
		return Element;	
	}
	
	public   WebElement getdropDownProp(String Key,String gender)
	{
		Select SELECT;
		WebElement Element=null;
		/*String LocatorValue=prop.getProperty(Key).split("/")[1];*/
		String LocatorType=prop.getProperty(Key).split(":")[1];
		String Locator=prop.getProperty(Key).split(":")[0];
		

		if(Locator.equalsIgnoreCase("id"))
		{
			SELECT=new Select(driver.findElement(By.id(LocatorType)));
			SELECT.selectByVisibleText(gender);
		}
		else if(Locator.equalsIgnoreCase("name"))
		{
			SELECT=new Select(driver.findElement(By.name(LocatorType)));
			SELECT.selectByVisibleText(gender);
		}
		else if(Locator.equalsIgnoreCase("css"))
		{
			SELECT=new Select(driver.findElement(By.name(LocatorType)));
			SELECT.selectByVisibleText(gender);
		}
		
		else if(Locator.equalsIgnoreCase("linktext"))
		{
			SELECT=new Select(driver.findElement(By.name(LocatorType)));
			SELECT.selectByVisibleText(gender);
		}
		
		else if(Locator.equalsIgnoreCase("xpath"))
		{
			SELECT=new Select(driver.findElement(By.name(LocatorType)));
			SELECT.selectByVisibleText(gender);
		}		
		else 
			System.out.println("invalid locator");
		
		
		return Element;
		
	}
	
}