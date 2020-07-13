package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "small-searchterms")
	WebElement searchTXT;
	
	@FindBy (css = "input.button-1.search-box-button")
	WebElement searchBTN;
	
	@FindBy (id = "ui-id-1")
	List<WebElement> productList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle ;
	
	public void productSearch(String productName) 
	{
		setElementTXT(searchTXT, productName);
		clickBTN(searchBTN);
	}
	
	public void  OpenProductDetailsPage () 
	{
		clickBTN(productTitle);
	}
	
	public void ProductSearchUsingAutoSuggest(String searchTxt) 
	{
		setElementTXT(searchTXT, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();
	}
}
