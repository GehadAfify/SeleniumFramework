package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor js;
	public Select select;
	public Actions actions;
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickBTN(WebElement button) 
	{
		button.click();
	}
	protected static void setElementTXT(WebElement txtElement, String value) 
	{
		txtElement.sendKeys(value);
	}
	public void ScrollToBottom() 
	{
		js.executeScript("scrollBy(0,2000)");
	}
	public void clearTextBox(WebElement textBox) 
	{
		textBox.clear();
	}
}
