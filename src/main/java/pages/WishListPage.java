package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(name = "removefromcart")
	WebElement removeBTN;
	
	@FindBy (css = "td.product")
	public WebElement productCell;
	
	@FindBy(name = "updatecart")
	WebElement updatewishlistBTN;
	
	@FindBy(css = "h1")
	public WebElement wishlistheader;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyWLlbl;

	public void RemoveProductFromWishList() 
	{
		clickBTN(removeBTN);
		clickBTN(updatewishlistBTN);
	}
}
