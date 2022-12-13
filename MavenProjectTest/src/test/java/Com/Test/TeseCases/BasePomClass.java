package Com.Test.TeseCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePomClass {
	public static WebDriver driver;
	 
	@BeforeMethod
	public void openapp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Navya\\Selenium\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://apt-public.appspot.com/testing-lab-login.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}
	
	@AfterMethod
	public void Closeapp(ITestResult res) throws IOException, InterruptedException
	{
	if(ITestResult.FAILURE==res.getStatus())
	{
		Generic_SreenShot.getPhoto(driver);
	}
		//driver.quit();
	}
}
