package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (name = "removefromcart")
	WebElement removefromcartBTN;
	
	@FindBy(css = "a.product-name")
	WebElement productCell;
	
	@FindBy(id = "itemquantity11227")
	WebElement quantityTXT;
	
	@FindBy(css = "input.button-2.update-cart-button")
	WebElement updateshoppingcartBTN;
	
	@FindBy(css = "td.subtotal")
	public WebElement totalLBL;
	
	@FindBy(id = "checkout")
	WebElement checkoutBTN;
	
	@FindBy (id = "termsofservice")
	WebElement agreeBTN;
	
	public void RemoveProductFromCart() 
	{
		clickBTN(removefromcartBTN);
		clickBTN(updateshoppingcartBTN);
	}
	public void UpdateProductQuantityInCart(String quantity) 
	{
		//must clear quantity textbox first
		clearTextBox(quantityTXT);
		setElementTXT(quantityTXT, quantity);
		clickBTN(updateshoppingcartBTN);
	}
	public void OpenCheckOutPage() 
	{
		clickBTN(agreeBTN);
		clickBTN(checkoutBTN);

	}
}
