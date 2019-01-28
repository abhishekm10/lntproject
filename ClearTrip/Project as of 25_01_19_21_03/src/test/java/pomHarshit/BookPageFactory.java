package pom;

import org.openqa.selenium.WebDriver;

public class BookPageFactory extends Factory{

	public BookPageFactory(WebDriver iDriver) {
		super(iDriver);
	}
	
	
	public void clickFiltersOneWay() throws Exception
	{
		Element.getElementProp("noStops").click();
		Thread.sleep(2000);
		Element.getElementProp("oneStops").click();
		Thread.sleep(2000);
		//Element.getElementProp("earlyMorning").click();
		//Thread.sleep(2000);
		Element.getElementProp("morning").click();
		Thread.sleep(2000);
		Element.getElementProp("midDay").click();
		Thread.sleep(2000);
		
		Element.getElementProp("noStops").click();
		Thread.sleep(2000);
		Element.getElementProp("oneStops").click();
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
	
	
	
}

