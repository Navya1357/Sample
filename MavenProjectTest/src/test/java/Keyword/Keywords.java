package Keyword;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
	public void click(WebDriver driver, String ObjectName, String typeLocator) 
			throws IOException{
		driver.findElement(this.getObject(ObjectName, typeLocator)).click();
	}

	By getObject(String ObjectName, String typeLocator) throws
	IOException{
		//Object Repository is opened 
		File file = new File(path+"\\Externals\\Object Repository.properties");
		FileInputStream fileInput = new FileInputStream(file);
		//Properties file is read 
		Properties prop = new Properties();
		if(typeLocator.equalsIgnoreCase("XPATH")){
			return By.xpath(prop.getProperty(ObjectName)); 
			// ObjectName is read and its value is returned
		}
		else if(typeLocator.equalsIgnoreCase("ID")){
			return By.id(prop.getProperty(ObjectName));
			// ObjectName is read and its value is returned
		}
		else if(typeLocator.equalsIgnoreCase("NAME")){
			return By.name(prop.getProperty(ObjectName));
			// ObjectName is read and its value is returned
		}
		return null;
	}
}
