package integration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.MultiCity;
import testexecution.Base;
import utils.Excel;
import utils.Util;


public class MultiCityAndPayment extends Base
{
  
  
 
	@Test (priority=1)
	public void multiCityBooking() throws Exception
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
	
	@Test(priority=2, dataProvider="guestUserBooking",dependsOnMethods="multiCityBooking")
	public void payment2Test(String emailid,String gender,String firstname,String lastname,String dob,String mon,String year,String cgender,String cfirstname,String clastname,String cdob,String cmob,String cyear,String igender,String ifirstname,String ilastname,String idob,String imob,String iyear,String mobilenum,String number,String month,String year1,String cardName,String cvv,String nationality) throws Exception 
	{
		paymentObj.Payment(emailid,gender,firstname,lastname,dob,mon,year,cgender,cfirstname,clastname,cdob,cmob,cyear,igender,ifirstname,ilastname,idob,imob,iyear,mobilenum,number,month,year1,cardName,cvv,nationality);
		//p.enterEmail(firstname,lastname,mobilenum,gender);
		
	}
	
	@DataProvider
	public Object[][] guestUserBooking() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet1",26);
		return data;
		
	}
	
	
	
	
	
}
