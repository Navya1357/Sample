package Com.Test.TestData;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Com.Test.Utilities.BrowserFactory ;
public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void setup()

	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver= BrowserFactory .startApplication(driver, "Chrome","https://unicore.azurewebsites.net/account/login");
	}
	@AfterClass
	public void teardown()
	{
	//	BrowserFactory .quitBrowser(driver);
	}
}