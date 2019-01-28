package testexecution;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom.PaymentFactory;
import pom.BookPageFactory;
import pom.GuestBookingFactory;
import pom.HomePage;
import pom.LoginFactory;
import pom.MultiCity;
import pom.RegistrationFactory;
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
  

  
}
