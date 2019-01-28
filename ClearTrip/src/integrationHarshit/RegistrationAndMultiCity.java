package integrationHarshit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.MultiCity;
import testExecution.Base;
import utils.Excel;
import utils.Util;


public class RegistrationAndMultiCity extends Base
{
  
  
  @Test(dataProvider="RegData")
	public void RegistrationTest(String Username,String Password,String firstName,
														String lastName,String mobileNo,String Gender,String Country) throws Exception
	{
	  registerObj.register(Username,Password,firstName,lastName,mobileNo,Gender,Country);
	  Util.captureScreenshot("Singup");
	  
	}
	
	
	@DataProvider
	public Object[][] RegData() throws Exception
	{
		Excel.ExcelConfig(".\\Data1.xlsx", "Register");
		Object data[][]=Excel.MyDataProvider("Register", 7);
		return data;
	}
	
	@Test (dependsOnMethods = "RegistrationTest")
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
