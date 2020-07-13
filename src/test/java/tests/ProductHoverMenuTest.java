package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase 
{
	HomePage homeObj ;
	
	@Test 
	public void UserCanSelectSubCategoryFromMainMenu() 
	{
		homeObj = new HomePage(driver);
		homeObj.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
