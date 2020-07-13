package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement emailafriendBTN;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;
	
	@FindBy (id = "add-to-wishlist-button-4")
	WebElement addtowishlistBTN;
	
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement addtocomparelistBTN;
	
	@FindBy (id = "add-to-cart-button-4")
	WebElement addtocartBTN;
	
	public void openSendEmailtoFriend() 
	{
		clickBTN(emailafriendBTN);
	}
	public void openAddReviewPage() 
	{
		clickBTN(addReviewLink);
	}
	public void AddProductToWishList() 
	{
		clickBTN(addtowishlistBTN);
	}
	
	public void AddProductToCompare() 
	{
		clickBTN(addtocomparelistBTN);
	}
	public void AddProductToCart() 
	{
		clickBTN(addtocartBTN);
	}
}
 