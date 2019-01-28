package integrationHarshit;

import org.testng.annotations.Test;


import pom.HomePage;
import pom.MultiCity;
import testExecution.Base;
import utils.Excel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class NewTest extends Base
{

	@Test
	public void test() throws Exception
	{
			System.out.println(driver.getTitle());
			homePageObj.loadPage();
			homePageObj.selectMulticityOption();
			homePageObj.enterCities();
			//WebDriver driverObj = homePageObj.returnWebDriver();
			
			System.out.println(driver.getTitle());
			System.out.println("Current url from test "+driver.getCurrentUrl());
			System.out.println("Current url from test "+driver.getCurrentUrl());
			
			
			
			
			multicityObj = new MultiCity(driver);
			multicityObj.checkTimeSlots();
			multicityObj.checkStops();
			multicityObj.chooseFlight();
			multicityObj.bookFlight();
			
			
			
 	}
	
	
	
	
	
	
	
}

	 


