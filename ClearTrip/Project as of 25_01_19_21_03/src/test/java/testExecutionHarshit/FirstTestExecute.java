package testExecution;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import pom.SearchFactory;
//import pom.searchFactory;
//import pom.searchFactory;
import utils.Excel;
//import utils.Util;
import utils.Util;

public class FirstTestExecute extends Base
{
		
	
		@Test(dataProvider="LoginData")
		public void LoginTest(String UN,String PWD) 
		{
			loginObj.Login(UN,PWD);
		}
		
		@DataProvider
		public Object[][] LoginData() throws Exception
		{
			Object data[][]=Excel.MyDataProvider("Login", 2);
			return data;
		}
	
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
			Object data[][]=Excel.MyDataProvider("Register", 7);
			return data;
		}
		
	/*	@Test(dataProvider="emailData")
		public void forgotPasswordTest(String email)
		{
			loginObj.forgotPassword(email);
		}
		@DataProvider
		public Object[][] emailData() throws Exception
		{
			Object data[][]=Excel.MyDataProvider("Login", 1);
			return data;
		}
	*/
		
	@Test(dataProvider="oneWayData")
	public void oneWaySearch(String source,String destination,String date,String adults, String children,String infants, String classType, String airline) 
	{
		searchObj.oneWay( source, destination, date, adults, children, infants, classType, airline);
	}
	
	@DataProvider
	public Object[][] oneWayData() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("OneWay", 8);
		return data;
	}
	
	@Test(dataProvider="roundTripData")
	public void roundTripSearch(String source,String destination,String depDate,String retDate,String adults, String children,String infants) 
	{
		searchObj.roundTrip( source, destination, depDate,retDate, adults, children, infants);
	}
	
	@DataProvider
	public Object[][] roundTripData() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("RoundTrip", 7);
		return data;
	}
		
	
	



		
}
