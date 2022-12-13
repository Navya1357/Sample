package FrameWork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ExcelOperation.Constants;


public class Action_Keyword {
	public static WebDriver driver;
	
			public static void main(String[] args) {
				
		
		System.setProperty("webdriver.chrome.driver","C:\\Navya\\Selenium\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();	
			}
	public void navigate() 
	{
		driver.get(Constants.URL);
	}
	public void enterUsername() 
	{
		driver.findElement(By.xpath("//input[@name='userNameOrEmailAddress']")).sendKeys(Constants.username);
	}
	public void enterPassword() 
	{
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Constants.password);
	}
	public void clickSignIn() 
	{ 
	driver.findElement(By.xpath("//div[@class='pb-lg-0 pb-5 ng-tns-c253-1']")).click(); 
	}
	public void logout() 
	{ 
	   driver.findElement(By.xpath("//span[@class='bg-success fs-2 fw-bold symbol-label text-inverse-success']")).click();
	   driver.findElement(By.xpath("//a[@class='menu-link px-5']")).click(); 
	} 
	public void closeBrowser() 
	{ 
	driver.quit(); 
	} 

	}

