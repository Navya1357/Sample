package Com.Test.TeseCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Generic_SreenShot {
	public static void getPhoto(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
            FileUtils.copyFile(screenshot, new File("C:\\Navya\\New folder\\LoginhomePageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}
