package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiCity extends Factory
{
	
		
		
		
		
		
		public MultiCity(WebDriver webdriverObj)
		{
			super(webdriverObj);
			
		}
		
		
		
		
		
	/*	By chooseFlight1 = By.xpath("/html/body/section[3]/div[5]/section[2]/section/div/form/section[2]/div[4]/div[1]/nav/ul/li[4]/div/label/table/tbody/tr[1]/th[1]/input");
		By chooseFlight2 = By.xpath("/html/body/section[3]/div[5]/section[2]/section/div/form/section[2]/div[4]/div[2]/nav/ul/li[6]/div/label/table/tbody/tr[1]/th[1]/input");
		*/
		//ExcelScript excelScriptMulticity;
	//	ExcelIterator excelIteratorObject = new ExcelIterator();
		
		
		public void loadPage()
		{
			
				System.out.println("Inside Load page");
			
				System.out.println("page loaded sucessfully");
			
			
			
			//excelIteratorObject.startIteration(".\\TestData\\OuterSequence.xlsx", "Sheet1");
			
			
			
		}
		 
	
	/*	Removed the constructor
	 * 
	 * public MultiCity(WebDriver webDriverObj)
		{
				this.webDriverObj = webDriverObj;
				
				
		
				
		}*/
		
		
		
		public void chooseFlight() throws Exception
		
		{
			Element.getElementProp("leftFlight2").click();
			Thread.sleep(1000);
			Element.getElementProp("leftFlight3").click();
			Thread.sleep(1000);
			Element.getElementProp("leftFlight4").click();
			Thread.sleep(1000);
			
			
			
			Element.getElementProp("RightFlight2").click();
			Thread.sleep(1000);
			Element.getElementProp("RightFlight3").click();
			Thread.sleep(1000);
			Element.getElementProp("RightFlight4").click();
			Thread.sleep(1000);
			
			
			
			/*try
			{
				
			
			excelIteratorObject.startIteration(".\\TestData\\OuterSequence.xlsx", "ChooseFlights");	
			}
			catch(Exception e1)
			{
				System.out.println("inside Exception"+e1.getMessage()  );
			}
			*/
			
			
		}
		
		public void checkStops()
		{
			/*By zeroStops = By.xpath("//label[@for='1_1_0_0']");
			By oneStops = By.xpath("//label[@for='1_1_1_0']");
			By twoStops = By.xpath("//label[@for='1_1_2_0']");
			By threeStops = By.xpath("//label[@for='1_1_3_0']");*/
			
			try {
				
			
			
				Element.getElementProp("zeroStopsMC").click();
			Thread.sleep(1000);
			Element.getElementProp("oneStopsMC").click();
			Thread.sleep(1000);
			Element.getElementProp("twoStopsMC").click();
			Thread.sleep(1000);
			Element.getElementProp("threeStopsMC").click();
			Thread.sleep(1000);
			
			
			Element.getElementProp("threeStopsMC").click();
			Thread.sleep(1000);
			Element.getElementProp("twoStopsMC").click();
			Thread.sleep(1000);
			Element.getElementProp("oneStopsMC").click();
			Thread.sleep(1000);
			Element.getElementProp("zeroStopsMC").click();
			Thread.sleep(1000);
			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			/*excelIteratorObject.startIteration(".\\TestData\\OuterSequence.xlsx", "CheckStops");	*/
			
		}
		
		
		public void bookFlight()
		
		{
			/*System.out.println("Before Reading Excel");
			excelIteratorObject.startIteration("D:\\Flight\\FlightProject\\TestData\\OuterSequence.xlsx", "BookFlight");	
			System.out.println("After Reading Excel");*/
			
			Element.getElementProp("bookMC").click();
		}
		
		public void checkTimeSlots() throws Exception 
		
		{
			System.out.println("Inside check timeSlots "+driver+"and url is "+driver.getCurrentUrl());
			
		/*	By  EarlyMorning = By.xpath("//*[contains(text(),'Early Morning')]");
			By morning = By.xpath("/html[1]/body[1]/section[3]/div[2]/section[2]/section[1]/aside[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/nav[1]/ul[1]/li[2]/label[1]");
			By midDay = By.xpath("//*[contains(text(),'Mid-Day')]");
			By evening = By.xpath("//*[contains(text(),'Evening')]");
			By night = By.xpath("//*[contains(text(),'Night')]");*/
			
		
				
			new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'Book')]")));
			System.out.println(Element.getElementProp("earlyMorningMC"));
			//excelIteratorObject.startIteration("D:\\Flight\\FlightProject\\TestData\\OuterSequence.xlsx", "CheckTimeSlots");	
			Element.getElementProp("earlyMorningMC").click();
			Thread.sleep(1000);
			Element.getElementProp("morningMC").click();
			Thread.sleep(1000);
			Element.getElementProp("midDayMC").click();
			Thread.sleep(1000);
			Element.getElementProp("eveningMC").click();
			Thread.sleep(1000);
			Element.getElementProp("nightMC").click();
			Thread.sleep(1000);
			Element.getElementProp("nightMC").click();
			Thread.sleep(1000);
			Element.getElementProp("eveningMC").click();
			Thread.sleep(1000);
			Element.getElementProp("midDayMC").click();
			Thread.sleep(1000);
			Element.getElementProp("morningMC").click();
			Thread.sleep(1000);
			Element.getElementProp("earlyMorningMC").click();
			Thread.sleep(1000);
		System.out.println("Check TimeSlots has been executed");
			
			
			
			/*System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
			webDriverObj = new ChromeDriver();
			webDriverObj.get("https://www.cleartrip.com/flights/results?from1=BOM&to1=GOI&depart_date_1=08/02/2019&multicity=true&from2=GOI&to2=DEL&depart_date_2=30/03/2019&adults=1&childs=0&infants=0&class=Economy&intl=n&num_legs=2&sd=1548158178576&page=loaded");
			webDriverObj.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			webDriverObj.manage().window().maximize();
			webDriverObj.findElement(evening).click();
			*/
			
			
			
			/*JavascriptExecutor javaScriptExecutorObj = (JavascriptExecutor)webDriverObj;
			javaScriptExecutorObj.executeScript("arguments[0].click();", webDriverObj.findElement(evening));
			Thread.sleep(3000);*/
			//webDriverObj.findElement(evening).click();
			
			
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*public void checkAllLinks()
		{
			List<WebElement> AllLinks = webDriverObj.findElements(By.xpath("//a"));
			for (int i = 0; i < AllLinks.size(); i++)
			{
						String title=AllLinks.get(i).getText();
						System.out.println("List of Links are/n");
						AllLinks.get(i).click();
						if (webDriverObj.getTitle().contains("Under"))
							System.out.println("Link for "+title+" is under construction");
							
						else
							System.out.println("Link for "+title+" is working.");
						webDriverObj.navigate().back();
						AllLinks = webDriverObj.findElements(By.xpath("//a"));
			}*/
		
		
		
		
		
	
}
		
		
		

