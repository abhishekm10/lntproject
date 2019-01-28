package integration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testexecution.Base;
import utils.Excel;

public class RoundTripAndPaymentIntegration extends Base {
	@Test(priority=1,dataProvider="roundTripData")
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
	@Test(priority=2,dependsOnMethods="roundTripSearch")
	public void bookRoundTrip() throws Exception 
	{
		bookPageObj.clickFiltersRoundTrip();
		bookPageObj.bookRoundTrip();
	
	}
	
	@Test(priority=3, dataProvider="guestUserBooking",dependsOnMethods="bookRoundTrip")
	public void payment2Test(String emailid,String gender,String firstname,String lastname,String dob,String mon,String year,String cgender,String cfirstname,String clastname,String cdob,String cmob,String cyear,String igender,String ifirstname,String ilastname,String idob,String imob,String iyear,String mobilenum,String number,String month,String year1,String cardName,String cvv,String Nationality) throws Exception 
	{
		paymentObj.Payment(emailid,gender,firstname,lastname,dob,mon,year,cgender,cfirstname,clastname,cdob,cmob,cyear,igender,ifirstname,ilastname,idob,imob,iyear,mobilenum,number,month,year1,cardName,cvv,Nationality);
		//p.enterEmail(firstname,lastname,mobilenum,gender);
		
	}
	
	@DataProvider
	public Object[][] guestUserBooking() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet1",26);
		return data;
		
	}
}
