package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy (id = "Email")
	WebElement emailTXT;

	@FindBy (id = "Password")
	WebElement passwordTXT;
	
	@FindBy (css = "input.button-1.login-button")
	WebElement loginBTN;
	
	public void userLogin (String email , String password) 
	{
		setElementTXT(emailTXT,email);
		setElementTXT(passwordTXT,password);
		clickBTN(loginBTN);
	}
}
