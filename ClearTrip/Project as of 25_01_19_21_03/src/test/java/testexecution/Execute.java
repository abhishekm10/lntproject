package testexecution;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.PaymentFactory;
import utils.Excel;
import utils.LoadProperty;
import utils.Util;

public class Execute extends Base
{
	LoadProperty Element;
	
	PaymentFactory p = new PaymentFactory(driver);
		/*@Test(priority=1 ,dataProvider="guestUserBooking")
		public void paymentTest(String emailid) throws Exception 
		{
		p.Payment(emailid);
		
		}*/
		
		@Test(/*priority=1*/ dataProvider="guestUserBooking")
		public void payment2Test(String emailid,String gender,String firstname,String lastname,String mobilenum,String number,String month,String year,String cardName,String cvv) throws Exception 
		{
			p.Payment(emailid,gender,firstname,lastname,mobilenum,number,month,year,cardName,cvv);
			//p.enterEmail(firstname,lastname,mobilenum,gender);
			
		}
		
		@DataProvider
		public Object[][] guestUserBooking() throws Exception
		{
			Object data[][]=Excel.MyDataProvider("Sheet1",10);
			return data;
			
		}
		
	
	
		
		
		
}
