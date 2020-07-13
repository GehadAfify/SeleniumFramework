package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
@FindBy (id = "AddProductReview_Title")
WebElement reviewTitleTXT;

@FindBy (id = "AddProductReview_ReviewText")
WebElement reviewTEXT;

@FindBy (css = "input.button-1.write-product-review-button")
WebElement submitBTN;

@FindBy (id = "addproductrating_4")
WebElement ratingRBTN;

@FindBy(css="div.result")
public WebElement reviewPASS;

	public void AddProductReview(String Title,String reviewMsg) 
	{
		setElementTXT(reviewTitleTXT, Title);
		setElementTXT(reviewTEXT, reviewMsg);
		clickBTN(ratingRBTN);
		clickBTN(submitBTN);
	}
}
