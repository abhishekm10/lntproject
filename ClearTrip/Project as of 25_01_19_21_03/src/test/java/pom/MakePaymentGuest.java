package testguesstuser;
import base.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class MakePaymentGuest extends Base {
WebDriver w;
@Test
public void makePayment() throws Exception
{
	
	WebDriverWait wt=new WebDriverWait(w, 30);
w.get("https://www.cleartrip.com/");
w.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
w.get("https://www.cleartrip.com/flights/itinerary/68e0178fe7-1b07-41b8-b9cf-9e819bffbd6b/review");
w.findElement(By.name("insurance")).click();
w.findElement(By.xpath("//*[@id=\"itineraryBtn\"]")).click();
w.findElement(By.name("username")).sendKeys("a@b.com");
//w.findElement(By.name("auth_action")).click();
//w.findElement(By.name("subscribe_action")).click();
w.findElement(By.id("LoginContinueBtn_1")).click();;
//w.findElement(By.name("//*[@id=\"AdultTitle1\"];
Thread.sleep(2000);
wt.until(ExpectedConditions.elementToBeClickable(By.name("AdultTitle1")));
new Select(w.findElement(By.name("AdultTitle1"))).selectByVisibleText("Mrs");
//System.out.println("selected");
w.findElement(By.name("AdultFname1")).sendKeys("Abc");
w.findElement(By.name("AdultLname1")).sendKeys("xyz");
w.findElement(By.id("mobileNumber")).sendKeys("9383628292");
//w.findElement(By.name("use_gst")).click();
w.findElement(By.id("travellerBtn")).click();
//wt.until(ExpectedConditions.elementToBe((By.xpath("//*[@id=\\\"creditCardNumberDisp\\\"]"))));
w.findElement(By.xpath("//*[@id=\"creditCardNumberDisp\"]")).sendKeys("11232455434564");
new Select(w.findElement(By.name("card_expiration_month"))).selectByVisibleText("11");
new Select(w.findElement(By.name("card_expiration_year"))).selectByVisibleText("2020");
w.findElement(By.name("bill_name")).sendKeys("abxc cy");
w.findElement(By.name("cvv_code")).sendKeys("377");
w.findElement(By.name("consent")).click();
System.out.println("printed");
//w.findElement(By.xpath("//*[@id=\"DCTab\"]/a")).click();
//w.findElement(By.xpath("//*[@id=\"flightForm\"]/section[2]/div[4]/div/nav/ul/li[1]/table/tbody[2]/tr[2]/td[3]/button"));

}

}

