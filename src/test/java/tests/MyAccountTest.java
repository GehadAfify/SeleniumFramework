package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest  extends TestBase
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;	
	LoginPage loginObj;
	MyAccountPage myaccountObj;
	String oldPassword = "123456";
	String newPassword = "111111";
	String firstName = "gehad";
	String lastName = "afify";
	String email = "testemail499@gmail.com";
	
	@Test (priority = 1 )
	public void userRegisterSuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration(firstName,lastName,email,oldPassword);
		Assert.assertTrue(registerObj.successMsg.getText().contains("Your registration completed"));
	}
	@Test(priority = 2 )
	public void RegisteredUserCanChangePassword() 
	{
		myaccountObj = new MyAccountPage(driver);
		registerObj.OpenMyaccountPage();
		myaccountObj.openChangePasswordPage();
		myaccountObj.Changeapassword(oldPassword, newPassword);
		Assert.assertTrue(myaccountObj.resultLBL.getText().contains("Password was changed"));
		
	}
	@Test (priority = 3 )
	public void RegisteredUserCanLogout() 
	{
		registerObj.userLogout();
	}
	@Test (priority = 4)
	public void RegisteredUserCanLogin() 
	{
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userLogin(email,newPassword);
		Assert.assertTrue(registerObj.logoutLink.isDisplayed());
	}
}
