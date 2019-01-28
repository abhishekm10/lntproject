package pom;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;

//import testexecution.Base;
//import utils.LoadProperty;

public class GuestBookingFactory extends Factory{
	
	public GuestBookingFactory(WebDriver iDriver)
	{		
		
	super(iDriver);
		
	}

	
	
	public void Payment(String emailid,String gender,String firstname,String lastname,String mobileno,String number,String month,String year,String cardName,String cvv) throws Exception
	{
		WebElement element=Element.getElementProp("p_insuranceClick");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		Thread.sleep(3000);
		Element.getElementProp("p_insuranceClick").click();
		Element.getElementProp("p_continueButton").click();
		Element.getElementProp("p_emailId").sendKeys(emailid);
		Element.getElementProp("p_continueBooking").click();
		Thread.sleep(2000);
		
		/*select=new Select(driver.findElement(By.id("p_dropDown")));
		select.selectByVisibleText(gender);*/
		Element.getElementProp("p_dropDown").sendKeys(gender);
		//driver.findElement(By.name("AdultTitle1")).sendKeys("Mr");
		
		/*Element.getElementProp("p_dropDown").click();
		
		Element.getElementProp("p_dropDown").sendKeys(gender);*/
		Element.getElementProp("p_Fname").sendKeys(firstname);
		Element.getElementProp("p_Lname").sendKeys(lastname);
		Element.getElementProp("p_MobNum").sendKeys(mobileno);
			
		Element.getElementProp("p_continuePayment").click();
		Thread.sleep(3000);
		Element.getElementProp("p_creditCardNumber").sendKeys(number);
	/*	Element.getElementProp("p_expiryMonth").sendKeys(number);
		Element.getElementProp("p_expiryYear").sendKeys(number);*/
		Element.getElementProp("p_expiryMonth").sendKeys(month);
		Element.getElementProp("p_expiryYear").sendKeys(year);
		Element.getElementProp("p_cardName").sendKeys(cardName);
		Element.getElementProp("p_cvv").sendKeys(cvv);
		Element.getElementProp("p_termsClick").click();
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
