package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFactory extends Factory
{
	
	
	public RegistrationFactory(WebDriver iDriver)
	{
		super(iDriver);
	}

	
	
	public void register(String username,String password,String firstName,String lastName,String mobileNo,String gender,String country) throws Exception
	{
		//Select select;
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				int countryCode=Integer.parseInt(country);
			//	WebDriverWait wait=new WebDriverWait(driver,30);
				Element.getElementProp("User_Link").click();
				Element.getElementProp("Register_Button").click();
			
				driver.switchTo().frame(Element.getElementProp("Switch_Frame"));
				Element.getElementProp("R_Username").sendKeys(username);		
				Element.getElementProp("Check_Button").click();
				
				try {
					Element.getElementProp("CreateAcc_Button").click();
					new WebDriverWait(driver,7).until(ExpectedConditions.invisibilityOf(Element.getElementProp("CreateAcc_Button")));
					Element.getElementProp("R_Password").sendKeys(password);
					System.out.println("password is "+password);
					
					
					
					
					new Select(Element.getElementProp("dropDownValue")).selectByValue(gender);
					Element.getElementProp("First_name").sendKeys(firstName);
					Element.getElementProp("Last_name").sendKeys(lastName);
					new Select(Element.getElementProp("dropDownIndex")).selectByIndex(countryCode);	
					Element.getElementProp("Mobile_no").sendKeys(mobileNo);
					executor.executeScript("arguments[0].click()", Element.getElementProp("Check_Button"));
					//Element.getElementProp("Check_Button").click();
					//wait.until(ExpectedConditions.elementToBeClickable(By.name("Sign_up")))
					Element.getElementProp("Sign_up").click();
					new WebDriverWait(driver,7).until(ExpectedConditions.invisibilityOf(Element.getElementProp("Sign_up")));
	
					new WebDriverWait(driver,12).until(ExpectedConditions.attributeToBeNotEmpty(Element.getElementProp("User_Link"), "title"));
	/*
					Element.getElementProp("User_Link").click();
					Element.getElementProp("Logout").click();*/
					
					Element.getElementProp("E_FLIGHTICON").click();
				
				}
				catch(TimeoutException T)
				{
					driver.switchTo().defaultContent();
					Element.getElementProp("Close").click();
				}
}
}

