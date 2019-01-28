package testExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;*/
//import org.openqa.selenium.support.ui.Select;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom.BookPageFactory;
import pom.GuestBookingFactory;
import pom.HomePage;
import pom.LoginFactory;
import pom.MultiCity;
import pom.RegistrationFactory;
import pom.SearchFactory;
//import pom.SignUpFactory;
import utils.Excel;
import utils.Util;

public class Base {
	protected WebDriver driver;
	static ExtentReports extent;
	static ExtentTest Test;
protected	LoginFactory loginObj;
	//SignUpFactory SF;
protected	RegistrationFactory registerObj;
protected	SearchFactory searchObj;
protected	BookPageFactory bookObj;
protected GuestBookingFactory guestObj;
protected HomePage homePageObj;
protected MultiCity multicityObj;
	
	
   @BeforeTest
  public void beforeTest()
  {
	  driver=Util.startBrowser(".\\driver\\chromedriver.exe");
	
	  
	  driver.get("https://www.cleartrip.com/");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  loginObj=new LoginFactory(driver);
	  //SF=new SignUpFactory(driver);
	  searchObj = new SearchFactory(driver);
	  registerObj = new RegistrationFactory(driver);
	  bookObj=new BookPageFactory(driver);
	  guestObj=new GuestBookingFactory(driver);
	 /* extent = new ExtentReports();
      extent.attachReporter(new ExtentHtmlReporter("Sample.html"));*/
      Excel.ExcelConfig(".\\Data1.xlsx", "Login");
     
     // action = new Actions(driver);
      
      
      homePageObj = new HomePage(driver);
      multicityObj = new MultiCity(driver); 
   
     
      
  }

  @AfterTest
  public void afterTest() 
  {
	//  driver.quit();
  }
  

  
}
