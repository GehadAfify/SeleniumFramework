package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestwithDDTandCSVfile extends TestBase 
{
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	LoginPage loginObj;
	
	CSVReader reader ;
	
	@Test (priority = 1 , alwaysRun = true)
	public void userRegisterSuccessfully() throws CsvValidationException, IOException 
	{
		//get path of csv file 
		String csv_file = System.getProperty(("user.dir")+"\\src\\test\\java\\data\\userdata.csv");
		reader = new CSVReader(new FileReader(csv_file));
		String [] csvCell;
		//while loop will be executed till the last value in csv file 
		while ((csvCell = reader.readNext())!= null) 
		{
			String firstname = csvCell[0];
			String lastname = csvCell [1];
			String email = csvCell[2];
			String password = csvCell[3];
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration(firstname,lastname,email,password);
		Assert.assertTrue(registerObj.successMsg.getText().contains("Your registration completed"));
		registerObj.userLogout();
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.userLogin(email,password);
		Assert.assertTrue(registerObj.logoutLink.isDisplayed());
		registerObj.userLogout();
		}
	}
	
}
