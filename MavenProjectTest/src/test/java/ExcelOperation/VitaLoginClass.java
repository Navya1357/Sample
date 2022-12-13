package ExcelOperation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.Test.TeseCases.Generic_SreenShot;

public class VitaLoginClass {
	
    static ExceloperationOfVita excel = new ExceloperationOfVita();    
    static String excelFilePath =constanatsClassVita.TestData_FILEPATH;
	static WebDriver driver;
	
	@BeforeClass
	public void setup() 
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Navya\\Selenium\\Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
	}


   @Test
   public void loginTest() throws InterruptedException, IOException
   {
	  
	   driver.get(constanatsClassVita.URL);
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   
	   excel.setExcelFile(excelFilePath, "TestCasesSample");

	   
	   for(int i=1;i<=excel.getRowCountInSheet();i++)
       {
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   
		   WebElement username = driver.findElement(By.xpath("//input[@name='userNameOrEmailAddress']"));
		   username.sendKeys(excel.getCellData(i, 0));
		  
		   WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		  	   passWord.sendKeys(excel.getCellData(i, 1));
		  	   
		  	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   WebElement logbtn = driver.findElement(By.xpath("/html/body/app-root/ng-component/div/div/div[1]/div/ng-component/div[1]/form/div[4]/button"));
		   logbtn.click();
		   
		   WebElement Ok = driver.findElement(By.xpath("/html/body/div/div/div[6]/button[1]"));
		   Ok.click();
		   
		   username.clear();
		   passWord.clear();
		   
		   String title = driver.getTitle();
		   if(title.equals("Vita"))
		   {
			   excel.setCellValue(i, 2, "Passed", excelFilePath);
		   }
		   else
		   {
			   excel.setCellValue(i, 2, "Failed", excelFilePath);
		   }	
       }
	   
   }
   
   @AfterClass
   public void tearDown (ITestResult res) throws InterruptedException 
	{
	if(ITestResult.FAILURE==res.getStatus())
	{
		Generic_SreenShot.getPhoto(driver);
	}
		//driver.quit();
	}
}
