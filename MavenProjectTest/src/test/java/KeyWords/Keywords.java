package KeyWords;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keywords {

	String path = System.getProperty("user.dir");
	WebDriver driver;


	public void enter_URL(WebDriver driver,String TestData) throws IOException
	{
		driver.get(TestData);
	}

	public void type(WebDriver driver, String typeLocator, String testdata, String ObjectName) 
	{
		driver.findElement(this.getObject(ObjectName,typeLocator)).sendKeys(testdata);
	}


	public void click(WebDriver driver,String ObjectName, String typeLocator) 
	{
		driver.findElement(this.getObject(ObjectName,typeLocator)).click();
	}

}