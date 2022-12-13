package Com.Test.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass {

	
		@FindBy(xpath="//input[@name='userId']")
		private WebElement uname;
		
		@FindBy(xpath="//input[@name='userPassword']")
		private	WebElement pass;
		
		@FindBy(xpath="//input[@value='Log me in!']")
		private WebElement lgn_btn;
		
		public PomClass(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		}
		
	  public void username(String name)
	 {
		  uname.sendKeys(name);
	 }
	  public void password(String password)
	 {
		  pass.sendKeys(password);
	 }
	  public void login()
	  {
		  lgn_btn.click();
	  }
	  
  }

