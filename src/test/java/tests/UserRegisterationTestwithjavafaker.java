package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestwithjavafaker extends TestBase 
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	LoginPage loginObj;
	Faker fakedata = new Faker();
	String firstname = fakedata.name().firstName();
	String lastname = fakedata.name().lastName();
	String email = fakedata.internet().emailAddress();
	String password = fakedata.number().digits(8).toString();
	
	@Test (priority = 1 , alwaysRun = true)
	public void userRegisterSuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration(firstname,lastname,email,password);
		System.out.print("the user data :"+firstname+" "+lastname+" "+email+" "+password);
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
		loginObj.userLogin(email,password);
		Assert.assertTrue(registerObj.logoutLink.isDisplayed());
	}
}
