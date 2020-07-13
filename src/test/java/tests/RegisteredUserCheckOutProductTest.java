package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class RegisteredUserCheckOutProductTest extends TestBase
{
	//1- register user
	//2-search for product
	//3-add to card
	//4-checkout
	//5-log out
	HomePage homeObj ;
	UserRegisterationPage registerObj;
	SearchPage searchObj; 
	LoginPage loginObj;
	ProductDetailsPage detailsObj;
	ShoppingCartPage cartpageObj;
	CheckOutPage checkoutObj;
	OrderDetailsPage orderObj;
	String productName = "Apple MacBook Pro 13-inch" ;

	@Test (priority = 1)
	public void userRegisterSuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openRegisterationPage();
		registerObj = new UserRegisterationPage(driver);
		registerObj.userRegisteration("gehad","afify","testemail07@gmail.com","123456");
		Assert.assertTrue(registerObj.successMsg.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() 
	{
		searchObj = new SearchPage(driver);
		searchObj.ProductSearchUsingAutoSuggest("macbook");
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObj.productNamebreadCrumb.getText(), productName);
	} 
	@Test(priority = 3)
	public void UserCanAddProductToShoppingcart() throws InterruptedException 
	{
		detailsObj = new ProductDetailsPage(driver);
		detailsObj.AddProductToCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/"+"cart");
		cartpageObj = new ShoppingCartPage(driver);
		Assert.assertTrue(cartpageObj.totalLBL.getText().contains("$3,600.00"));
		
	}
	@Test(priority = 4)
	public void UserCanCheckOutProduct() throws InterruptedException 
	{
		checkoutObj = new CheckOutPage(driver);
		cartpageObj.OpenCheckOutPage();
		checkoutObj.RegisteredUserCheckoutProduct("Egypt", "2test", "1111", "madrid", "5642345", productName);
		Assert.assertTrue(checkoutObj.productname.isDisplayed());
		Assert.assertTrue(checkoutObj.productname.getText().contains(productName));
		checkoutObj.ConfirmOrder();
		Assert.assertTrue(checkoutObj.thankyouLBL.isDisplayed());
		//print invoice as pdf or print page
		checkoutObj.ViewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObj = new OrderDetailsPage(driver);
		orderObj.printOrderetails();
		orderObj.DownloadPDFinvoiceOrder();
		
	}
	
	@Test (priority = 5)
	public void RegisteredUserCanLogout() 
	{
		registerObj.userLogout();
	}
}
