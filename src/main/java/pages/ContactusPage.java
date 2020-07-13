package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage extends PageBase
{

	public ContactusPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FullName")
	WebElement nameTXT;
	
	@FindBy(id = "Email")
	WebElement emailTXT;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTXT;
	
	@FindBy(css = "input.button-1.contact-us-button")
	WebElement submitBTN;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void ContactUs(String FullName,String Email,String Enquiry) 
	{
		setElementTXT(nameTXT, FullName);
		setElementTXT(emailTXT, Email);
		setElementTXT(enquiryTXT, Enquiry);
		clickBTN(submitBTN);
	}
}
