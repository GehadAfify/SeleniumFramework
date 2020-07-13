package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTesteithDDTandJSONFile extends TestBase 
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	LoginPage loginObj;
	
	@Test (priority = 1 , alwaysRun = true)
	public void userRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException 
	{
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.jsonReader();;
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		//registerObj.userRegisteration(jsonReader,jsonReader,jsonReader,jsonReader);
		Assert.assertTrue(registerObj.successMsg.getText().contains("Your registration completed"));
		registerObj.userLogout();
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userLogin("testemail46@gmail.com","123456");
		Assert.assertTrue(registerObj.logoutLink.isDisplayed());
		registerObj.userLogout();

	}
	
}
