package ExcelOperation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Navya\\Selenium\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		  driver.get("https://unicore.azurewebsites.net/account/login");
	}
		
  @Test(dataProvider="LoginData")
  public void LoginTest(String user, String pwd, String exp) {
	
	 WebElement Username = driver.findElement(By.id("Email"));
	 Username.sendKeys(user);	 
	 WebElement Password = driver.findElement(By.id("Password"));
	 Password.sendKeys(pwd);
	 driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
	String exp_title="https://unicore.azurewebsites.net/account/login";
	String act_title=driver.getTitle();
	
	if(exp.equals("valid"))
	{
		if(exp_title.equals(act_title))
		{
			driver.findElement(By.linkText("Logout")).click();
			Assert.assertTrue(true);
		}
		else
		{
			
			Assert.assertTrue(false);
		}
  }
  
	else if(exp.equals("Invalid"))
	{
		if(exp_title.equals(act_title))
		{
			driver.findElement(By.linkText("Logout")).click();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
  }
  }
  
  @DataProvider(name="LoginData")
  public String [][] getData() throws IOException {
	/* String loginData[][]= {
			                   {"admin@yourstore.com","admin","Valid"},
			                   {"admin@yourstore.com","adm","Invalid"},
			                   {"adm@yourstore.com","admin","Invalid"},
			                   {"adm@yourstore.com","adm","Invalid"},
	                        };*/
	  
	  //get the data from excel
	  
	  String path =".\\DataFiles\\TestCasesSample.xlsx";
		  XLUtility xlutil=new XLUtility(path);
		  
		  int totalrows=xlutil.getRowCount("TestData");
	      int totalcols = xlutil.getCellCount("TestData", 1);
	  
	String loginData [][] =new String[totalrows][totalcols];
	
	for(int r=1;r<=totalrows;r++) //1
	{		
	    for(int c=0;c<totalcols;c++) //0
	        {
		      loginData [r-1][c]=xlutil.getCellData("TestData", r, c);
	        }		
	}
	  
	 return loginData;
	 }
	  
  
}



