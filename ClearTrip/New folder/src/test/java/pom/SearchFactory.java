package pom;

//import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

//import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testexecution.Base;
/*import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.corba.se.spi.orbutil.fsm.Action;
 */
public class SearchFactory extends Factory{

	public SearchFactory(WebDriver iDriver) {
		super(iDriver);
	}




	public void search()
	{
		try {
			//Thread.sleep(3000);
			//Element.getElementsProp("E_FROM").get(1).click();


			Element.getElementProp("E_FLIGHT").click();			
			Element.getElementProp("E_ONEWAY").click();
			Thread.sleep(3000);
			Element.getElementProp("E_ROUNDTRIP").click();
			Thread.sleep(3000);
			Element.getElementProp("E_MULTICITY").click();
			Thread.sleep(3000);
			Element.getElementProp("E_CURRENCY").click();
			Thread.sleep(3000);
			Element.getElementProp("E_COUNTRY").click();
			Thread.sleep(3000);
			Element.getElementProp("E_YOURTRIPS").click();
			Thread.sleep(3000);
			Element.getElementProp("E_CANCELLATION").click();
			Thread.sleep(3000);
			Element.getElementProp("E_YOURTRIPS").click();
			Thread.sleep(3000);
			Element.getElementProp("E_CHANGEFLIGHT").click();
			Thread.sleep(3000);
			Element.getElementProp("E_YOURTRIPS").click();
			Thread.sleep(3000);
			Element.getElementProp("E_PRINTTICKET").click();
			Thread.sleep(3000);
			Element.getElementProp("E_FLIGHTICON").click();


		} catch (Exception e) {
			// TODO: handle exception
		}

	}	
	public void oneWay(String source,String destination,String date,String adults, String children, String infants, String classType, String airline) throws Exception
	{
		Element.getElementProp("E_FROM").clear();
		Element.getElementProp("E_FROM").sendKeys(source);	
		Element.getElementProp("E_TO").clear();
		Element.getElementProp("E_TO").sendKeys(destination);
		Element.getElementProp("E_DEPTDATE").clear();
		Element.getElementProp("E_DEPTDATE").sendKeys(date);	
		new Select(Element.getElementProp("E_ADULTS")).selectByValue(adults);
		new Select(Element.getElementProp("E_CHILD")).selectByValue(children);
		new Select(Element.getElementProp("E_INFANTS")).selectByValue(infants);
		//Element.getElementProp("E_MOREOPT").click();
		/*if (Element.getElementProp("E_MOREOPT").isSelected())
		{
			//Element.getElementProp("E_MOREOPT").click();
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(Element.getElementProp("E_MOREOPT")));
			Element.getElementProp("E_CLASSTYPE").sendKeys(classType);
			Element.getElementProp("E_AIRLINE").clear();
			Element.getElementProp("E_AIRLINE").sendKeys(airline);
		}
		 */
		Element.getElementProp("E_SEARCHBUTTON").click();

		try {
			new WebDriverWait(driver, 11).until(ExpectedConditions.invisibilityOf(Element.getElementProp("E_SEARCHBUTTON")));
		}catch(TimeoutException T)
		{
			Base.captureScreenshot("OneWaySearchError");
			driver.navigate().refresh();

		}

	}
	
	
	public void roundTrip(String source,String destination,String depDate,String retDate,String adults, String children, String infants) throws Exception
	{
		
		Element.getElementProp("E_ROUNDTRIP").click();
	
		//new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeSelected(Element.getElementProp("E_FROM")));
		
		Element.getElementProp("E_FROM").clear();
		Element.getElementProp("E_FROM").sendKeys(source);	
		Element.getElementProp("E_TO").clear();
		Element.getElementProp("E_TO").sendKeys(destination);
		Element.getElementProp("E_DEPTDATE").clear();
		Element.getElementProp("E_DEPTDATE").sendKeys(depDate);
		Element.getElementProp("E_RETDATE").clear();
		Element.getElementProp("E_RETDATE").sendKeys(retDate);	
		new Select(Element.getElementProp("E_ADULTS")).selectByValue(adults);
		new Select(Element.getElementProp("E_CHILD")).selectByValue(children);
		new Select(Element.getElementProp("E_INFANTS")).selectByValue(infants);
		//Element.getElementProp("E_MOREOPT").click();
		/*if (Element.getElementProp("E_MOREOPT").isSelected())
		{
			//Element.getElementProp("E_MOREOPT").click();
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(Element.getElementProp("E_MOREOPT")));
			Element.getElementProp("E_CLASSTYPE").sendKeys(classType);
			Element.getElementProp("E_AIRLINE").clear();
			Element.getElementProp("E_AIRLINE").sendKeys(airline);
		}
		 */
		Element.getElementProp("E_SEARCHBUTTON").click();
	

		try {
			new WebDriverWait(driver, 11).until(ExpectedConditions.invisibilityOf(Element.getElementProp("E_SEARCHBUTTON")));
		}catch(TimeoutException T)
		{
			Base.captureScreenshot("RoundTripSearchError");
			driver.navigate().refresh();

		}
	}

	
	
}



