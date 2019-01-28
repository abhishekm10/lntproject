package testExecution;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Excel;

public class ThirdTestExecute extends Base {
	@Test(/*priority=1*/ dataProvider="guestUserBooking")
	public void payment2Test(String emailid,String gender,String firstname,String lastname,String mobilenum,String number,String month,String year,String cardName,String cvv) throws Exception 
	{
		//guestObj.Payment(emailid,gender,firstname,lastname,mobilenum,number,month,year,cardName,cvv);
		//p.enterEmail(firstname,lastname,mobilenum,gender);
		
	}
	
	@DataProvider
	public Object[][] guestUserBooking() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("LoginBook",10);
		return data;
		
	}
}
