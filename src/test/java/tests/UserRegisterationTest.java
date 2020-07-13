package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase 
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	LoginPage loginObj;
	
	@Test (priority = 1 , alwaysRun = true)
	public void userRegisterSuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration("gehad","afify","testemail09@gmail.com","123456");
		Assert.assertTrue(registerObj.successMsg.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = {"userRegisterSuccessfully"})
	public void RegisteredUserCanLogout() 
	{
		registerObj.userLogout();
	}
	@Test (dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin() 
	{
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userLogin("testemail46@gmail.com","123456");
		Assert.assertTrue(registerObj.logoutLink.isDisplayed());
	}
}
