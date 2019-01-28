package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testexecution.Base;
import utils.Excel;

public class HomePage extends Factory
{
	public HomePage(WebDriver webDriverObj)
	{
		super(webDriverObj);
	}
	
			public void loadPage()
			{
				//driver.navigate().to("http:\\cleartrip.com");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
				
			}
			
			
			public void selectMulticityOption()
			{
				Element.getElementProp("multiCityRadio").click();
				//System.out.println("multicity has been selected");
			}
			
			public void enterCities() throws Exception
			{
				if(Element.getElementProp("removeButton").isDisplayed())
				{
					//System.out.println("Element has been found");
					Thread.sleep(1000);
					Element.getElementProp("removeButton").click();
				}
		
				Excel.ExcelConfig(Element.getProp("excelPath"), Element.getProp("sheetName"));
				
				//Entering 1st and 2nd city
				Element.getElementProp("city1").sendKeys(Excel.Read(1, 0));
				Thread.sleep(1000);
				Element.getElementProp("city2").sendKeys(Excel.Read(1, 1));
				Thread.sleep(1000);
				
				//entering date
				Element.getElementProp("date1calender").click();
				WebDriverWait waitdate1 = new WebDriverWait(driver, 20);
				Element.getElementProp("date1");
				WebElement date1 = waitdate1.until(ExpectedConditions.visibilityOfElementLocated(Element.getByObj()));
				date1.click();
				
				//entering 3rd city
				Element.getElementProp("city2down").click();
				Thread.sleep(1000);
				Element.getElementProp("city3").sendKeys(Excel.Read(1, 2));;
				Thread.sleep(1000);
				
				//selecting date for second flight
				Element.getElementProp("date2calender").click();
				WebDriverWait waitdate2 = new WebDriverWait(driver, 20);
				Element.getElementProp("date2");
				WebElement date2 = waitdate2.until(ExpectedConditions.visibilityOfElementLocated(Element.getByObj()));
				date2.click();
				
				//selecting dropdown
				new Select(Element.getElementProp("adultsDropDown")).selectByVisibleText(Excel.Read(1, 3));
				new Select(Element.getElementProp("childrenDropDown")).selectByVisibleText(Excel.Read(1, 4));
				new Select(Element.getElementProp("infantDropDown")).selectByVisibleText(Excel.Read(1, 5));
				
				//Clicking the search Button
				Base.captureScreenshot("MulticitySearchSuccessful");
				Element.getElementProp("searchButton").click();
				
				
				
				
				
				
				
				
				
				}
			
			
			
			
			public String getCurrentUrl()
			{
				String url = driver.getCurrentUrl();
				return url;
			}
			public WebDriver  returnWebDriver()
			{
				return driver;
			}
			

}
