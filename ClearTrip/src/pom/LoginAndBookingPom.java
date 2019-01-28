package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Excel;


public class LoginAndBookingPom 
{

	protected WebDriver driver;


	public  void openBrowser(String Location)
	{
		if(Location.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",Location);
			driver=new ChromeDriver();
		}
		else if(Location.contains("gecko"))
		{
			System.setProperty("webdriver.gecko.driver",Location);
			driver=new FirefoxDriver();
		}
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public  void openUrl(String URL)
	{
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public  void sendKeys(String Locator,String LocatorValue,String inputdata)
	{
		switch(Locator)
		{
		case "name":
			try {
				Thread.sleep(7000);
				//driver.findElement(By.name(LocatorValue)).sendKeys(inputdata);
				((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute("+inputdata+");",driver.findElement(By.name(LocatorValue)) );

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "id":
			driver.findElement(By.id(LocatorValue)).sendKeys(inputdata);
		/*	try {
				Thread.sleep(7000);
				//driver.findElement(By.name(LocatorValue)).sendKeys(inputdata);
				((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute("+inputdata+");",driver.findElement(By.name(LocatorValue)) );

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	
			break;
		case "css":
			driver.findElement(By.cssSelector(LocatorValue)).sendKeys(inputdata);
			break;
		case "link":
			driver.findElement(By.linkText(LocatorValue)).sendKeys(inputdata);
			break;
		case "xpath":
			driver.findElement(By.xpath(LocatorValue)).sendKeys(inputdata);
			break;
		default:
			System.out.println("Invalid Locator Specified");
		}
	}
	public  void click(String Locator,String LocatorValue)
	{
		switch(Locator)
		{
		case "name":
			driver.findElement(By.name(LocatorValue)).click();;
			break;
		case "id":
			driver.findElement(By.id(LocatorValue)).click();;
			break;
		case "css":
			driver.findElement(By.cssSelector(LocatorValue)).click();;
			break;
		case "link":
			driver.findElement(By.linkText(LocatorValue)).click();;
			break;
		case "xpath":
			driver.findElement(By.xpath(LocatorValue)).click();;
			break;
		default:
			System.out.println("Invalid Locator Specified");	
		}}

	public  void dropdownSelect(String locatorType,String locatorValue,String Locator) 
	{

		switch(locatorType)
		{
		case "name":
			new Select(driver .findElement(By.name(locatorValue))).selectByValue(Locator);
			break;
		case "id":
			new Select(driver.findElement(By.name(locatorValue))).selectByValue(Locator);
			break;
		case "css":
			new Select(driver .findElement(By.name(locatorValue))).selectByValue(Locator);
			break;
		case "link":
			new Select(driver .findElement(By.name(locatorValue))).selectByValue(Locator);
			break;
		case "xpath":
			new Select(driver .findElement(By.name(locatorValue))).selectByValue(Locator);
			break;
		default:
			System.out.println("Invalid Locator Type Specified");
		}
	}

	/*public  void screenShot() throws Exception
	{

			TakesScreenshot t=(TakesScreenshot)driver;
			File src=t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File(".\\"+driver.getTitle()+".png"));

	}*/

	public  void closeBrowser()
	{
		driver.quit();
	}

	/*public void implicitWait(String time)
	{
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(time),TimeUnit.SECONDS);

	}*/

	public void explicitWait(String locatorType,String locatorValue,String time)
	{
		WebDriverWait wt=new WebDriverWait(driver, Integer.parseInt(time));
		//wt.until(ExpectedConditions.elementToBeClickable(By.name("AdultTitle1")));
		switch(locatorType)
		{
		case "name":
			wt.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
			break;
		case "id":
			wt.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
			break;
		case "css":
			wt.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
			break;
		case "link":
			wt.until(ExpectedConditions.elementToBeClickable(By.linkText(locatorValue)));
			break;
		case "xpath":
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
			break;
		default:
			System.out.println("Invalid Locator Type Specified");
		}
	}

	public  void select(String locatorType, String locatorValue)
	{
		WebElement checkBox = driver.findElement(By.id(locatorValue));

		if (checkBox.isSelected()) {
		    System.out.println("User active check box is already checked");
		    driver.findElement(By.id(locatorValue)).click();
		} 
		else
		    System.out.println("User active check box is not checked");
			driver.findElement(By.id(locatorValue)).click();

	}
	
	public  void switchFromFrame(String Locator,String LocatorValue)
	{
		
		
		WebElement element = driver.findElement(By.name(LocatorValue));

		driver.switchTo().frame(element);
	}
	



	public void loginAndBookProcess() throws Exception  
	{
		Excel.ExcelConfig("C:\\Users\\vshadmin\\Desktop\\Project\\Login.xlsx", "Sheet1");

		for(int i=1;i<=Excel.ROWNUM();i++)
		{
			String A=Excel.Read(i, 0);
			switch(A)
			{
			case "openBrowser":
				openBrowser(Excel.Read(i, 3));
				break;
			case "openUrl":
				openUrl(Excel.Read(i, 3));
				break;
			case "sendKeys":
				sendKeys(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
				break;
			case "click":
				click(Excel.Read(i, 1), Excel.Read(i, 2));
				break;



			case "dropdownSelect"://for dropdown button
				dropdownSelect(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
				break;

				/*case "screenshot": screenShot();
			break;*/

			case "closeBrowser": closeBrowser();
			break;
			/*	
			case "implicitWait": implicitWait(Excel.Read(i, 3));
			break;*/

			case "wait": explicitWait(Excel.Read(i, 1),Excel.Read(i, 2),Excel.Read(i, 3));
			break;


			}
		}

	}

}
