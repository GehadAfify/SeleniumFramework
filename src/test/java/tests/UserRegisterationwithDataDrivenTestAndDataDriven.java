package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDataDrivenTestAndDataDriven extends TestBase 
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	LoginPage loginObj;
	
	@DataProvider(name = "testData")
	public static Object [][] userData ()
	{
		return new Object [][] {{"gehad" , "mohamed","gehad@gmail.com","123456"},
			{"hello","user","test@mail.com","111111"}};
		
	}
	
	
	@Test (priority = 1 , alwaysRun = true,dataProvider = "testData")
	public void userRegisterSuccessfully(String fname,String lname,String email,String password) 
	{
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration(fname,lname,email,password);
		Assert.assertTrue(registerObj.successMsg.getText().contains("Your registration completed"));
		registerObj.userLogout();
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userLogin(email,password);
		Assert.assertTrue(registerObj.logoutLink.isDisplayed());
		registerObj.userLogout();

	}
	
}
