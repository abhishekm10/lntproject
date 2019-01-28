package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookPageFactory extends Factory{

	public BookPageFactory(WebDriver iDriver) {
		super(iDriver);
	}
	
	
	public void clickFiltersOneWay() throws Exception
	{
		Element.getElementProp("noStopstry1").click();
		Thread.sleep(2000);
		Element.getElementProp("oneStopstry1").click();
		Thread.sleep(2000);
		//Element.getElementProp("earlyMorning").click();
		//Thread.sleep(2000);
		Element.getElementProp("morning").click();
		Thread.sleep(2000);
		Element.getElementProp("midDay").click();
		Thread.sleep(2000);
		
		Element.getElementProp("noStopstry1").click();
		Thread.sleep(2000);
		Element.getElementProp("oneStopstry1").click();
		Thread.sleep(2000);
		//Element.getElementProp("earlyMorning").click();
		//Thread.sleep(2000);
		Element.getElementProp("morning").click();
		Thread.sleep(2000);
		Element.getElementProp("midDay").click();
		Thread.sleep(2000);
	}
	
	
	public void bookFlightOneWay()
	{
		Element.getElementProp("Book").click();
	}
	
	
	public void clickFiltersRoundTrip() throws Exception {
		//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(Element.getElementsProp("BookRoundTripButton").get(1)));
		Element.getElementProp("noStopsRTtry1").click();
		Thread.sleep(2000);
		Element.getElementProp("oneStopsRTtry1").click();
		Thread.sleep(2000);
		// Element.getElementProp("earlyMorning").click();
		// Thread.sleep(2000);
		Element.getElementProp("eveningDepartRT").click();
		Thread.sleep(2000);
		Element.getElementProp("midDayDepartRT").click();
		Thread.sleep(2000);
		Element.getElementProp("eveningDepartRT").click();
		Thread.sleep(2000);
		Element.getElementProp("midDayDepartRT").click();
		Thread.sleep(2000);
		Element.getElementProp("eveningReturnRT").click();
		Thread.sleep(2000);
		Element.getElementProp("midDayReturnRT").click();
		Thread.sleep(2000);
		Element.getElementProp("noStopsRTtry1").click();
		Thread.sleep(2000);
		Element.getElementProp("oneStopsRTtry1").click();
		Thread.sleep(2000);
		// Element.getElementProp("earlyMorning").click();
		// Thread.sleep(2000);
		Element.getElementProp("eveningReturnRT").click();
		Thread.sleep(2000);
		Element.getElementProp("midDayReturnRT").click();
		Thread.sleep(2000);

	}

	public void bookRoundTrip() {
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOf(Element.getElementsProp("BookRoundTripButton").get(1)));

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				Element.getElementsProp("BookRoundTripButton").get(1));
	
	
}
}

