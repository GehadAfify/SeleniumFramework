package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDDTandExcelFile extends TestBase 
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	LoginPage loginObj;
	@DataProvider (name = "ExcelData" )
	public Object [][] userRegisterData() throws IOException
	{
		// get data from excel reader class
		ExcelReader er = new ExcelReader();
		return er.getExcelData();
	}
	@Test (priority = 1 , alwaysRun = true, dataProvider = "ExcelData")
	public void userRegisterSuccessfully(String fn , String ln , String e , String pw) 
	{
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration(fn,ln,e,pw);
		Assert.assertTrue(registerObj.successMsg.getText().contains("Your registration completed"));
		registerObj.userLogout();
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userLogin(e,pw);
		Assert.assertTrue(registerObj.logoutLink.isDisplayed());
		registerObj.userLogout();
	}
	
	
}
