package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class LoginFactory extends Factory {
	
	public LoginFactory(WebDriver iDriver)
	{
		super(iDriver);
	}

		
	public void Login(String username,String Password)
	{
		driver.manage().window().maximize();
		Element.getElementProp("E_YOURTRIPS").click();
		Element.getElementProp("E_SIGNIN").click();
		driver.switchTo().frame(Element.getElementProp("E_FRAMEELEMENT"));
		Element.getElementProp("E_USERNAME").sendKeys(username);
		Element.getElementProp("E_PASSWORD").sendKeys(Password);
		Element.getElementProp("E_CHECKBOX").click();
		Element.getElementProp("E_LOGINBUTTON").click();
		try {
		new WebDriverWait(driver, 11).until(ExpectedConditions.invisibilityOf(Element.getElementProp("E_LOGINBUTTON")));
		}catch(TimeoutException T)
		{driver.switchTo().defaultContent();
			driver.findElement(By.id("close")).click();
		}
	}
		
	public void forgotPassword(String email)
	{
		driver.manage().window().maximize();
		Element.getElementProp("E_YOURTRIPS").click();
		Element.getElementProp("E_SIGNIN").click();
		driver.switchTo().frame(Element.getElementProp("E_FRAMEELEMENT"));
		Element.getElementProp("E_FORGOTPASSWORD").click();
		Element.getElementProp("E_USERNAME").sendKeys(email);
		Element.getElementProp("E_RESET").click();
		try {
			new WebDriverWait(driver, 11).until(ExpectedConditions.invisibilityOf(Element.getElementProp("E_RESET")));
			}catch(TimeoutException T)
			{   driver.switchTo().defaultContent();
				driver.findElement(By.id("close")).click();
			}
	
	}
	
	
}
	
	
		
		
		
		/*
		Element.getElementProp("E_LOGIN").click();
		
		Element.getElementProp("E_EM").sendKeys(username);
		Element.getElementProp("E_PWD").sendKeys(Password);
		Element.getElementProp("E_LG").click();
*/


