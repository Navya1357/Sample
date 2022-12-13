package Com.Test.TeseCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.Test.TestData.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void loginApp()
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.loginToCRM("uname", "pass");
	}
}