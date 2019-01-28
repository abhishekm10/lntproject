package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import utils.LoadProperty;

public class Factory {
	WebDriver driver;
	LoadProperty Element;
	
	public Factory(WebDriver iDriver)
	{
		this.driver=iDriver;
		Element=new LoadProperty(".\\OR.property",driver);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}

}
