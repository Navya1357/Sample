package Com.Test.TestData;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}	
	@FindBy(name="userNameOrEmailAddress") 
	private WebElement uname;	
	@FindBy(name="password")	
	private WebElement pass;
	@FindBy(xpath="//button[.='Log in]")	 
	private WebElement SigninButton;

	 public void loginToCRM(String usernameApplication, String passwordApplication)
	{
		uname.sendKeys("admin");
		pass.sendKeys("Welcom*123");
		SigninButton.click();

	}
}