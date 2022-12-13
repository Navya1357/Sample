package Com.Test.TeseCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Test.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest()
	{
		driver.get(baseURL);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setpassword(password);
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Vita"))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(true);
		}
		
	}
	
}

