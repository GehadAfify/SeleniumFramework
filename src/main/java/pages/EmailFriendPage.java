package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "FriendEmail")
	WebElement friendEmailTXT;
	
	//@FindBy(id="YourEmailAddress")
	//WebElement myemail;

	@FindBy(id="PersonalMessage")
	WebElement personalMsgTXT;
	
	@FindBy(css="input.button-1.send-email-a-friend-button")
	WebElement sendemailBTN;
	
	@FindBy(css="div.result")
	public WebElement successMsg;
	
	public void SendEmailToFriend(String frindEmail,String personalmessage ) 
	{
		setElementTXT(friendEmailTXT, frindEmail);
		setElementTXT(personalMsgTXT, personalmessage);
		clickBTN(sendemailBTN);
	}
}
