package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDDTandPropiritiesFile extends TestBase 
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	LoginPage loginObj;
	String fn = LoadProperties.userData.getProperty("firstname");
	String ln = LoadProperties.userData.getProperty("lastname");
	String e = LoadProperties.userData.getProperty("email");
	String pw = LoadProperties.userData.getProperty("password");



	@Test (priority = 1 , alwaysRun = true)
	public void userRegisterSuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration(fn,ln,e,pw);
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
		loginObj.userLogin(e , pw);
		Assert.assertTrue(registerObj.logoutLink.isDisplayed());
	}
}
