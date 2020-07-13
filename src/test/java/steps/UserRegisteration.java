package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration  extends TestBase{
	HomePage homeObj;
	UserRegisterationPage registerObj;
	@Given("^The user in the home page$")
	public void the_user_in_the_home_page() throws Throwable {
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
	}
	@When ("I click on register link")
	public void I_click_on_register_link()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("I entered the user data") public void I_entered_the_user_data ()
	 * throws Throwable{ registerObj = new UserRegisterationPage(driver);
	 * registerObj.userRegisteration("gehad","afify", "test@mail.com","123456"); }
	 */

	@When("I entered {string},{string},{string},{string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration(firstname,lastname,email,password);
		//throw new io.cucumber.java.PendingException();
	}
	@Then("^The registration page displayed successfully$")
	public void The_registration_page_displayed_successfully () {
		registerObj.userLogout();
	}
}
