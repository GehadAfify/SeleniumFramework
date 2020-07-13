package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactusPage;
import pages.HomePage;

public class ContactusTest extends TestBase
{
	HomePage homeObj ;
	ContactusPage contactusOBJ;
	
	String fullname = "gehad afify";
	String email = "test@gmail.com";
	String enquiry = "test automation with selenium";

	@Test
	public void UserCanContatctUs() 
	{
		homeObj = new HomePage(driver);
		contactusOBJ = new  ContactusPage(driver);
		homeObj.openContactusPage();
		contactusOBJ.ContactUs(fullname, email, enquiry);
		Assert.assertTrue(contactusOBJ.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}
}
