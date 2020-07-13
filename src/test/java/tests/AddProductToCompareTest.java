package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase 
{
	String firstproduct ="Asus N551JK-XO076H Laptop";
	String secondproduct = "Apple MacBook Pro 13-inch";
	
	//1-search for product number 1
	//2-search for product number 2
	//3-add to compare
	//4-clear list
	
	ProductDetailsPage detailsObj;
	HomePage homeObj ;
	ComparePage compareObj;
	SearchPage searchObj; 

	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException 
	{
		homeObj = new HomePage(driver);
		searchObj = new SearchPage(driver);
		detailsObj = new ProductDetailsPage(driver);
		compareObj  = new ComparePage(driver);
		searchObj.ProductSearchUsingAutoSuggest("asus");
		Assert.assertTrue(detailsObj.productNamebreadCrumb.getText().contains(firstproduct));
		detailsObj.AddProductToCompare();
		
		searchObj.ProductSearchUsingAutoSuggest("mac");
		Assert.assertTrue(detailsObj.productNamebreadCrumb.getText().contains(secondproduct));
		detailsObj.AddProductToCompare();
		Thread.sleep(2000);

		driver.navigate().to("https://demo.nopcommerce.com/"+"compareproducts");
		Assert.assertTrue(compareObj.firstproductname.getText().equals("Asus N551JK-XO076H Laptop"));
		Assert.assertTrue(compareObj.secondproductname.getText().equals("Apple MacBook Pro 13-inch"));
		compareObj.CompareProducts();
		
		
	}
	
	@Test(priority = 2)
	public void UserCanClearCompareList() 
	{
		compareObj.ClearCompareList();
		Assert.assertTrue(compareObj.nodataLBL.getText().contains("You have no items to compare."));
	}
}
