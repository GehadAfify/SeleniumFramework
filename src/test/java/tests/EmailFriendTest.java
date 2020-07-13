package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	LoginPage loginObj;
	String productName = "Apple MacBook Pro 13-inch" ;
	SearchPage searchObj; 
	ProductDetailsPage detailsObj;
	EmailFriendPage emailObj;
	//1-user registration
	@Test (priority = 1 , alwaysRun = true)
	public void userRegisterSuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration("gehad","afify","testemail49@gmail.com","123456");
		Assert.assertTrue(registerObj.successMsg.getText().contains("Your registration completed"));
	}
	//2-search for product
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try
		{
			searchObj = new SearchPage(driver);
			searchObj.ProductSearchUsingAutoSuggest("macbook");
			detailsObj = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObj.productNamebreadCrumb.getText(), productName);
		} 
		catch (Exception e) {
		System.out.println("Error Occured  "+e.getMessage());
		}
	}	
	//3-email to friend
	@Test(priority = 3)
	public void RegisteredUserCanSendProductToFriend() 
	{
		detailsObj.openSendEmailtoFriend();
		emailObj = new EmailFriendPage(driver);
		emailObj.SendEmailToFriend("aaa@test.com", "hello friend");
		Assert.assertTrue(emailObj.successMsg.getText().contains("Your message has been sent."));
	}
	
	//4-user logout
	@Test (priority = 4)
	public void RegisteredUserCanLogout() 
	{
		registerObj.userLogout();
	}
	

}
