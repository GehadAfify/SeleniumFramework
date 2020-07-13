package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase 
{
	String productName = "Apple MacBook Pro 13-inch" ;
	SearchPage searchObj; 
	ProductDetailsPage detailsObj;
	
	@Test
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
}
