package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage  extends PageBase
{

	
	//constructor 3ashan 3amlt inheritance from class that has a constructor so must add constructor here too
	public UserRegisterationPage(WebDriver driver) 
	{
		super(driver);
		
	}
	//by default elements are private
	@FindBy(id = "gender-male")
	WebElement genderBTN ;
	
	@FindBy(id = "FirstName")
	WebElement firstnameTXT;
	
	@FindBy(id = "LastName")
	WebElement lastnameTXT;
	
	@FindBy(id = "Email")
	WebElement emailTXT;
	
	@FindBy(id = "Password")
	WebElement passwordTXT;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordTXT;
	
	@FindBy(id = "register-button")
	WebElement registerBTN;
	
	@FindBy(css = "div.result")
	public WebElement successMsg; //3ashan a3rf ashofha fel test w a3mlha assert
	
	@FindBy(css = "a.ico-logout")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myaccountLink ;
	//public 3ashan n2der nshofha fel test 
	//7atet parameters 3ashan lama agy a3mlha call fel test a2der a8yehom w at7kem fihom mtb2ash hardcoded
	public void userRegisteration (String firstName,String lastName,String email,String passWord)
	{
		clickBTN(genderBTN);
		setElementTXT(firstnameTXT, firstName);
		setElementTXT(lastnameTXT, lastName);
		setElementTXT(emailTXT, email);
		setElementTXT(passwordTXT, passWord);
		setElementTXT(confirmpasswordTXT, passWord);
		clickBTN(registerBTN);
		
	}
	
	public void userLogout() 
	{
		clickBTN(logoutLink);
	}
	
	public void OpenMyaccountPage() 
	{
		clickBTN(myaccountLink);
	}
}
