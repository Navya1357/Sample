package Com.Test.TeseCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Test.PageObject.PomClass;



public class TCOfPom_01  extends BasePomClass {
	@Test  
	public void script() throws IOException
	{
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		PomClass pmc=new PomClass(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		pmc.username("Navyag");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		pmc.password("Nav@123");
		pmc.login();
		String title=driver.getTitle();
		/*if(driver.getTitle().equals("Attention"))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}*/
		System.out.println(title);
		Assert.assertEquals(title, "Attention");
		
	}

}
