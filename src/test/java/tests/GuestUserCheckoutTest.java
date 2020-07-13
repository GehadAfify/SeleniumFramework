package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestUserCheckoutTest extends TestBase
{
	HomePage homeObj ;
	SearchPage searchObj; 
	ProductDetailsPage detailsObj;
	ShoppingCartPage cartpageObj;
	CheckOutPage checkoutObj;
	OrderDetailsPage orderObj;
	String productName = "Apple MacBook Pro 13-inch" ;
	@Test(priority = 1)
	public void UserCanSearchWithAutoSuggest() 
	{
		searchObj = new SearchPage(driver);
		searchObj.ProductSearchUsingAutoSuggest("macbook");
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObj.productNamebreadCrumb.getText(), productName);
	} 
	@Test(priority = 2)
	public void UserCanAddProductToShoppingcart() throws InterruptedException 
	{
		detailsObj = new ProductDetailsPage(driver);
		detailsObj.AddProductToCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/"+"cart");
		cartpageObj = new ShoppingCartPage(driver);
		Assert.assertTrue(cartpageObj.totalLBL.getText().contains("$3,600.00"));
	}
	@Test(priority = 3)
	public void guestUserCanCheckOutProduct() throws InterruptedException 
	{
		checkoutObj = new CheckOutPage(driver);
		cartpageObj.OpenCheckOutPage();
		checkoutObj.CheckOutAsGuest();
		checkoutObj.GuestUserCheckoutProduct("gehadafify","gogooo", "testwa@mail.com", "Egypt", "22ds", "111211","cairo","896342", productName);
		Assert.assertTrue(checkoutObj.productname.isDisplayed());
		Assert.assertTrue(checkoutObj.productname.getText().contains(productName));
		checkoutObj.ConfirmOrder();
		Assert.assertTrue(checkoutObj.thankyouLBL.isDisplayed());
	}
	@Test(priority = 4)
	public void UserCanViewOrderDetails() throws InterruptedException 
	{
		checkoutObj.ViewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObj = new OrderDetailsPage(driver);
		orderObj.printOrderetails();
		Thread.sleep(2000);
		orderObj.DownloadPDFinvoiceOrder();
	}
}
