package Com.Test.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}
	@FindBy(name="userNameOrEmailAddress")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
   
	 @FindBy(xpath="//button[.='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	 public void setUsername(String uname)
	 {
		 txtusername.sendKeys(uname);
	 }
	 
	 public void setpassword(String pwd)
	 {
		 txtpassword.sendKeys(pwd);
	 }
	 
	 public void clickSubmit()
	 {
		 btnLogin.click();
	 }
	
	
}

