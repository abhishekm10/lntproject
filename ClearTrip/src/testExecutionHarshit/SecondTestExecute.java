package testExecution;

import org.testng.annotations.Test;

public class SecondTestExecute extends Base
{
  

	@Test
	public void bookOneWay() throws Exception 
	{
		bookObj.clickFiltersOneWay();
		bookObj.bookFlightOneWay();
	}

}
