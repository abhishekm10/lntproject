package integrationHarshit;

import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testExecution.Base;
import utils.Excel;
import utils.Util;

//import utils.Excel;

public class LoginAndOneWayIntegration extends Base
{
	@Test(dataProvider="LoginData")
	public void LoginTest(String UN,String PWD) 
	{
		loginObj.Login(UN,PWD);
	}
	
	@DataProvider
	public Object[][] LoginData() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("ValidLogin", 2);
		return data;
	}
	
	@Test(dataProvider="oneWayData",dependsOnMethods = "LoginTest")
	public void oneWaySearch(String source,String destination,String date,String adults, String children,String infants, String classType, String airline) throws Exception 
	{
		searchObj.oneWay( source, destination, date, adults, children, infants, classType, airline);
	//	bookObj.clickFiltersOneWay();
		bookObj.bookFlightOneWay();
	}
	
	@DataProvider
	public Object[][] oneWayData() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("ValidOneWay", 8);
		return data;
	}
	
	

	@Test(/*priority=1*/ dataProvider="guestUserBooking",dependsOnMethods = "oneWaySearch")
	public void payment2Test(String gender,String firstname,String lastname,String date,String month,String year,String mobileno,String cardnumber,String expirymonth,String expiryyear,String cardName,String cvv) throws Exception 
	{
		guestObj.Payment(gender,firstname,lastname,date,month,year,mobileno,cardnumber,expirymonth,expiryyear,cardName,cvv);
		//p.enterEmail(firstname,lastname,mobilenum,gender);
		Util.captureScreenshot("Login_And_Book");
	}
	
	@DataProvider
	public Object[][] guestUserBooking() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("LoginBook",12);
		return data;
		
	}

	
}
