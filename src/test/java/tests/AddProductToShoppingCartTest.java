package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase
{
	SearchPage searchObj; 
	ProductDetailsPage detailsObj;
	ShoppingCartPage cartpageObj;
	String productName ="Apple MacBook Pro 13-inch";
	
	@Test (priority = 1)
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
	public void UserCanRemoveProductFromCart() 
	{
		cartpageObj = new ShoppingCartPage(driver);
		cartpageObj.RemoveProductFromCart();
	}
}
