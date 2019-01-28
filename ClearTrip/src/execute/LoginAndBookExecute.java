package execute;


import org.testng.annotations.Test;
import pom.LoginAndBookingPom;

public class LoginAndBookExecute{

	@Test
	public void f() throws Exception
	{
		LoginAndBookingPom pom=new LoginAndBookingPom();

		pom.loginAndBookProcess();

	}
}
