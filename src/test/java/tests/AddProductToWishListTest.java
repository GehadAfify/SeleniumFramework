package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest  extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch" ;
	SearchPage searchObj; 
	ProductDetailsPage detailsObj;
	WishListPage wishlistObj;
	
	@Test(priority = 1)
	public void UserCanSearchWithAutoSuggest() 
	{
		try
		{
			searchObj = new SearchPage(driver);
			searchObj.ProductSearchUsingAutoSuggest("macbook");
			detailsObj = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObj.productNamebreadCrumb.getText(), productName);
		} 
		catch (Exception e) {
		System.out.println("Error Occured  "+e.getMessage());
		}
	}
	@Test(priority = 2)
	public void UserCanAddProductToWishlist() 
	{
		detailsObj = new ProductDetailsPage(driver);
		detailsObj.AddProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/"+"wishlist");
		wishlistObj = new WishListPage(driver);
		Assert.assertTrue(wishlistObj.wishlistheader.isDisplayed());
		Assert.assertTrue(wishlistObj.productCell.getText().contains(productName));
	}
	@Test(priority = 3)
	public void UserCanRemoveProductFromWishlist() 
	{
		wishlistObj = new WishListPage(driver);
		wishlistObj.RemoveProductFromWishList();
		Assert.assertTrue(wishlistObj.emptyWLlbl.getText().contains("The wishlist is empty!"));
	}
	
}
