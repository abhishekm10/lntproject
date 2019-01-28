package testexecution;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.gargoylesoftware.htmlunit.javascript.host.Element;

import pom.BookPageFactory;
import pom.GuestBookingFactory;
import pom.HomePage;
import pom.MultiCity;
import pom.PaymentFactory;
import pom.SearchFactory;
import utils.Excel;
import utils.Util;

public class Base {
	
	
	protected static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest Test;
	protected PaymentFactory paymentObj;
	protected HomePage homePageObj;
	protected MultiCity multicityObj;

	//SignUpFactory SF;
	 
protected	SearchFactory searchObj;
protected	BookPageFactory bookPageObj;
protected GuestBookingFactory guestObj;
	
  @BeforeTest
  public void beforeTest()
  {
	  
	  driver=Util.startBrowser(".\\drivers\\chromedriver.exe");
	
	  
	  driver.get("https://www.cleartrip.com");

	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 

	  searchObj = new SearchFactory(driver);
	
	  bookPageObj=new BookPageFactory(driver);
	  guestObj=new GuestBookingFactory(driver);
	 /* extent = new ExtentReports();
      extent.attachReporter(new ExtentHtmlReporter("Sample.html"));*/
	  paymentObj=new PaymentFactory(driver);
	  homePageObj = new HomePage(driver);
	  multicityObj = new MultiCity(driver); 
	  
	  
	  extent = new ExtentReports();
      extent.attachReporter(new ExtentHtmlReporter("Sample.html"));
      Excel.ExcelConfig(".\\Data1.xlsx", "Sheet1");
  }

  @AfterTest
  public void afterTest() 
  {
	  //driver.quit();
  }
  public static void captureScreenshot(String name) throws Exception
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		String screenshotName =name+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(screenshotName);
		
		FileUtils.copyFile(src, new File(".\\drivers\\"+screenshotName));
		
	}

  
}
