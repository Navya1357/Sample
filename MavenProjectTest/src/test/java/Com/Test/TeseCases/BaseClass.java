package Com.Test.TeseCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public String baseURL ="https://unicore.azurewebsites.net/";
	public String username="admin";
	public String password ="Welcome*123";
	public static WebDriver driver;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	    driver=new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown()
	
	{
		driver.quit();
	}
	
}
