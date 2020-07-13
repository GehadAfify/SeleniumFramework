package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css= "input.button-1.login-button")
	WebElement loginBtn;
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement checkoutGuestBTN;
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstNameTXT;
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastNameTXT;
	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTXT;
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement CountryList;
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTXT;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1TXT;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalcodeTXT;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTXT;
	@FindBy(css = "input.button-1.new-address-next-step-button")
	WebElement continue1;
	@FindBy(id = "shippingoption_1")
	WebElement shipmethodCheck;
	@FindBy(css = "input.button-1.shipping-method-next-step-button")
	WebElement continue2;
	@FindBy(id = "paymentmethod_0")
	WebElement paymentmethodCheck;
	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement continue3;
	
	@FindBy(css = "input.button-1.payment-info-next-step-button")
	WebElement continue4;
	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement confirmBTN;
	
	@FindBy(css = "a.product-name")
	public WebElement productname;
	@FindBy(css = "h1")
	public WebElement thankyouLBL;
	@FindBy(css = "div.title")
	WebElement successMsg;
	@FindBy(linkText = "Click here for order details.")
	WebElement orderdetailsLink;
	
	@FindBy(css = "input.button-1.order-completed-continue-button")
	WebElement continue5;

	public void RegisteredUserCheckoutProduct(String country,String address, String postalcode,String city,String phone,String productName) throws InterruptedException 
	{
		select = new Select(CountryList);
		select.selectByVisibleText(country);
		setElementTXT(address1TXT, address);
		setElementTXT(postalcodeTXT, postalcode);
		setElementTXT(cityTXT, city);
		setElementTXT(phoneTXT, phone);
		clickBTN(continue1);
		clickBTN(shipmethodCheck);
		clickBTN(continue2);
		Thread.sleep(2000);
		clickBTN(paymentmethodCheck);
		Thread.sleep(2000);
		clickBTN(continue3);
		Thread.sleep(2000);
		clickBTN(continue4);
	}
	public void ConfirmOrder() throws InterruptedException 
	{
		
		Thread.sleep(1000);
		clickBTN(confirmBTN);
	}
	public void ViewOrderDetails() 
	{
		clickBTN(orderdetailsLink);
	}
	
	//checkout for guest user
	public void GuestUserCheckoutProduct(String firstName,String LastName,String email,
			String country,String address, String postalcode,String city,String phone,String productName) throws InterruptedException 
	{
		setElementTXT(firstNameTXT, firstName);
		setElementTXT(lastNameTXT, LastName);
		setElementTXT(emailTXT, email);
		select = new Select(CountryList);
		select.selectByVisibleText(country);
		setElementTXT(address1TXT, address);
		setElementTXT(postalcodeTXT, postalcode);
		setElementTXT(cityTXT, city);
		setElementTXT(phoneTXT, phone);
		clickBTN(continue1);
		clickBTN(shipmethodCheck);
		clickBTN(continue2);
		Thread.sleep(2000);
		clickBTN(paymentmethodCheck);
		Thread.sleep(2000);
		clickBTN(continue3);
		Thread.sleep(2000);
		clickBTN(continue4);
	}
	public void CheckOutAsGuest() {
		clickBTN(checkoutGuestBTN);
	}
}
