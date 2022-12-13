package KeyWords;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keyword1 {
	String path = System.getProperty("user.dir");

	WebDriver driver;

	public void enter_URL(WebDriver driver,String TestData) throws IOException{
		driver.get(TestData);
	}

	public void type(WebDriver driver, String typeLocator, String testdata, String ObjectName) throws IOException{

		driver.findElement(this.getObject(ObjectName,typeLocator)).sendKeys(testdata);
		//driver.findElement(By.xpath("//")).sendKeys(testdata);

	}
	public void wait(WebDriver driver,String ObjectName, String typeLocator) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.getObject(ObjectName,typeLocator))));
	}
	public void click(WebDriver driver,String ObjectName, String typeLocator) throws IOException{
		driver.findElement(this.getObject(ObjectName,typeLocator)).click();
	}
	public String get_currentURL(WebDriver driver){
		String URL = driver.getCurrentUrl();
		System.out.println("print URL "+URL);
		return URL;
	}
	By getObject(String ObjectName, String typeLocator) throws IOException{

		File file = new File(path+"\\Externals\\Object Repository.properties");
		FileInputStream fileInput = new FileInputStream(file);

		Properties prop = new Properties();
		//find by the xpath
		if(typeLocator.equalsIgnoreCase("XPATH")){

			return By.xpath(prop.getProperty(ObjectName));
		}
		//find by the class
		else if(typeLocator.equalsIgnoreCase("CLASSNAME")){

			return By.className(prop.getProperty(ObjectName));

		}
		//find by name locator
		else if(typeLocator.equalsIgnoreCase("NAME")){

			return By.name(prop.getProperty(ObjectName));

		}
		//Find by css lcatoor
		else if(typeLocator.equalsIgnoreCase("CSS")){

			return By.cssSelector(prop.getProperty(ObjectName));

		}
		//find by the link
		else if(typeLocator.equalsIgnoreCase("LINK")){

			return By.linkText(prop.getProperty(ObjectName));

		}
		//find by the partial link
		else if(typeLocator.equalsIgnoreCase("PARTIALLINK")){

			return By.partialLinkText(prop.getProperty(ObjectName));

		}
		return null;

	}

}