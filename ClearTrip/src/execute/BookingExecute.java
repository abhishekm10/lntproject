package execute;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import pom.BookingPom;

public class BookingExecute{
  

@Test
  public void f() throws Exception
  {
	  BookingPom bookpom=new BookingPom();
	
	  bookpom.bookingProcess();
	  
  }
}
