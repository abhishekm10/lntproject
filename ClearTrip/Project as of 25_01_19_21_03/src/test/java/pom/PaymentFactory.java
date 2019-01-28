package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testexecution.Base;
import utils.LoadProperty;
import utils.Util;

public class PaymentFactory extends Factory{

	Select select;
	public PaymentFactory(WebDriver iDriver)
	{		
		
super(iDriver);
	
	
		
	}

	
	
	public void Payment(String emailid,String gender,String firstname,String lastname,String dob,String mon,String year,String cgender,String cfirstname,String clastname,String cdob,String cmob,String cyear,String igender,String ifirstname,String ilastname,String idob,String imob,String iyear,String mobileno,String number,String month,String year1,String cardName,String cvv,String nationality) throws Exception
	{

			Thread.sleep(3000);
			
			try
			{
				Element.getElementProp("p_insuranceClick").click();
			}catch(Exception E) {}
			
			
			Element.getElementProp("p_continueButton").click();
			Element.getElementProp("p_emailId").sendKeys(emailid);
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(Element.getElementProp("p_continueBooking")));
//			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(etElementProp("p_continueBooking")));

			Element.getElementProp("p_continueBooking").click();
			Thread.sleep(2000);
			
			Element.getElementProp("p_dropDown").sendKeys(gender);
			Thread.sleep(1000);
			Element.getElementProp("p_Fname").sendKeys(firstname);
			Thread.sleep(1000);
			Element.getElementProp("p_Lname").sendKeys(lastname);
			Thread.sleep(1000);
			try {
				Element.getElementProp("p_dob").sendKeys(dob);
				Thread.sleep(1000);
				Element.getElementProp("p_mob").sendKeys(mon);
				Thread.sleep(1000);
				Element.getElementProp("p_year").sendKeys(year);
				Thread.sleep(1000);
				Element.getElementProp("p_AdultNationality").sendKeys(nationality);
				Thread.sleep(5000);
				Element.getElementProp("p_AdultNationality").sendKeys(Keys.RETURN);
				//Element.getElementProp("p_AdultNationality").submit();
				Thread.sleep(1000);
			} catch (Exception e1) {}
			
			try {
				Element.getElementProp("p_dropdownc").sendKeys(cgender);
				Thread.sleep(1000);
				Element.getElementProp("p_Fnamec").sendKeys(cfirstname);
				Thread.sleep(1000);
				Element.getElementProp("p_Lnamec").sendKeys(clastname);
				Thread.sleep(1000);
				Element.getElementProp("p_dobc").sendKeys(cdob);
				Thread.sleep(1000);
				Element.getElementProp("p_mobc").sendKeys(cmob);
				Thread.sleep(1000);
				Element.getElementProp("p_yearc").sendKeys(cyear);
				Thread.sleep(1000);
				try {
					Element.getElementProp("p_ChildNationality").sendKeys(nationality);
					Thread.sleep(5000);
					Element.getElementProp("p_ChildNationality").sendKeys(Keys.RETURN);
					
					//Element.getElementProp("p_ChildNationality").submit();
					Thread.sleep(1000);
				} catch (Exception e) {}
			} catch (Exception e) {}
			
			
			try {
				Element.getElementProp("p_dropdowni").sendKeys(igender);
				Thread.sleep(1000);
				Element.getElementProp("p_Fnamei").sendKeys(ifirstname);
				Thread.sleep(1000);
				Element.getElementProp("p_Lnamei").sendKeys(ilastname);
				Thread.sleep(1000);
				Element.getElementProp("p_dobi").sendKeys(idob);
				Thread.sleep(1000);
				Element.getElementProp("p_mobi").sendKeys(imob);
				Thread.sleep(1000);
				Element.getElementProp("p_yeari").sendKeys(iyear);
				Thread.sleep(1000);
				Element.getElementProp("p_InfantNationality").sendKeys(nationality);
				Thread.sleep(5000);
				Element.getElementProp("p_InfantNationality").sendKeys(Keys.RETURN);
			} catch (Exception e) {}
			
			
			
			
			
			
			Element.getElementProp("p_MobNum").sendKeys(mobileno);
			Element.getElementProp("p_continuePayment").click();
			
			Thread.sleep(3000);
			Element.getElementProp("p_creditCardNumber").sendKeys(number);

			Element.getElementProp("p_expiryMonth").sendKeys(month);
			Element.getElementProp("p_expiryYear").sendKeys(year1);
			Element.getElementProp("p_cardName").sendKeys(cardName);
			Element.getElementProp("p_cvv").sendKeys(cvv);
			//Element.getElementProp("p_termsClick").click();
			Element.getElementProp("p_makepayment").click();
			
	

	}
	
/*	public void enterEmail(String firstname,String lastname,String mobileno,String gender) throws Exception
	{
	
		Thread.sleep(2000);
		Element.getdropDownProp("p_dropDown",gender);
		Element.getElementProp("p_Fname").sendKeys(firstname);;
		Element.getElementProp("p_Lname").sendKeys(lastname);;
		Element.getElementProp("p_MobNum").sendKeys(mobileno);
		Element.getElementProp("p_continuePayment");
	}
	
}*/
}