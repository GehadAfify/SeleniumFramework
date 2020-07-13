package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}
	@FindBy(linkText = "Register")
	WebElement registerLink ;
	
	@FindBy(linkText = "Log in")
	WebElement loginLLink;
	
	@FindBy (linkText = "Contact us")
	WebElement contactusLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencylist;
	
	@FindBy(css = "span.price.actual-price")
	public WebElement priceLBL;
	
	@FindBy(linkText = "Computers")
	WebElement computerMenu;
	
	@FindBy(linkText = "Notebooks ")
	WebElement notebooksMenu;
	public void openRegisterationPage() 
	{
		clickBTN(registerLink);
	}
	public void openLoginPage() 
	{
		clickBTN(loginLLink);
	}
	public void openContactusPage() 
	{
		ScrollToBottom();
		clickBTN(contactusLink);
	}
	public void changeCurrency() 
	{
		select = new Select (currencylist);
		select.selectByVisibleText("Euro");
	}
	public void selectNotebooksMenu() 
	{
		actions.moveToElement(computerMenu).moveToElement(notebooksMenu)
		.click().build().perform();//to simulate as user using
	}
	
}
