package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Change password")
	WebElement changepasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldpasswordTXT;
	
	@FindBy(id = "NewPassword")
	WebElement newpasswordTXT;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmnewpasswordTXT;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement changepasswordBTN;
	
	@FindBy(css="div.result")
	public WebElement resultLBL;
	
	public void openChangePasswordPage() 
	{
		clickBTN(changepasswordLink);
	}
	
	public void Changeapassword(String oldpassword,String newpassword) 
	{
		setElementTXT(oldpasswordTXT, oldpassword);
		setElementTXT(newpasswordTXT,newpassword);
		setElementTXT(confirmnewpasswordTXT, newpassword);
		clickBTN(changepasswordBTN);
	}
}
