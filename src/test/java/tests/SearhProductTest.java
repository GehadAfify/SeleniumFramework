package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearhProductTest extends TestBase 
{
	String productName = "Apple MacBook Pro 13-inch" ;
	SearchPage searchObj; 
	ProductDetailsPage detailsObj;
	@Test
	public void UserCanSearchForProduct() 
	{
		searchObj = new SearchPage(driver);
		detailsObj = new ProductDetailsPage(driver);
		searchObj.productSearch(productName);
		searchObj.OpenProductDetailsPage();
		//Assert.assertTrue(detailsObj.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObj.productNamebreadCrumb.getText(), productName);
	}
}
