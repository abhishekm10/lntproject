package integration;

import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testexecution.Base;
import utils.Excel;

//import utils.Excel;

public class LoginAndOneWayIntegration extends Base
{
	/*@Test(dataProvider="LoginData")
	public void LoginTest(String UN,String PWD) 
	{
		loginObj.Login(UN,PWD);
	}*/
	
	/*@DataProvider
	public Object[][] LoginData() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("ValidLogin", 2);
		return data;
	}*/
	
	@Test(priority=1,dataProvider="oneWayData")
	public void oneWaySearch(String source,String destination,String date,String adults, String children,String infants, String classType, String airline) throws Exception 
	{
		searchObj.oneWay( source, destination, date, adults, children, infants, classType, airline);
		/*bookObj.clickFiltersOneWay();
		bookObj.bookFlightOneWay();*/
	}
	
	@Test(priority=2,dependsOnMethods="oneWaySearch")
	public void oneWayBook() throws Exception
	{
		bookPageObj.clickFiltersOneWay();
		bookPageObj.bookFlightOneWay();
	}
	
	@DataProvider
	public Object[][] oneWayData() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("ValidOneWay", 8);
		return data;
	}
	
	
	
	

	@Test(priority=3, dataProvider="guestUserBooking",dependsOnMethods="oneWayBook")
	public void payment2Test(String emailid,String gender,String firstname,String lastname,String dob,String mon,String year,String cgender,String cfirstname,String clastname,String cdob,String cmob,String cyear,String igender,String ifirstname,String ilastname,String idob,String imob,String iyear,String mobilenum,String number,String month,String year1,String cardName,String cvv,String nationality) throws Exception 
	{
		paymentObj.Payment(emailid,gender,firstname,lastname,dob,mon, year,cgender,cfirstname,clastname,cdob,cmob,cyear,igender,ifirstname,ilastname,idob,imob,iyear,mobilenum,number,month,year1,cardName,cvv,nationality);
		//p.enterEmail(firstname,lastname,mobilenum,gender);
		
	}
	
	@DataProvider
	public Object[][] guestUserBooking() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet1",26);
		return data;
		
	}

	
}
