package Com.Test.Utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserFactory {
	public static WebDriver startApplication(WebDriver driver,String browserName, String appURL){
		if(browserName.equals("chrome")){
			System.setProperty("webDriver.chrome.driver","C:\\Navya\\Selenium\\Drivers\\ChromeDriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	public static void quitBrowser(WebDriver driver){
		driver.quit();
	}
}