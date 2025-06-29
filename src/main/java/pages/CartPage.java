package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartPage
{
	WebDriver driver;
	
	@FindBy(className = "subheader")
	public WebElement yourCartPage;
	
	@FindBy(xpath = "//*[text()='Sauce Labs Backpack']") 
	public WebElement backPackText;
	
	@FindBy(xpath = "//*[text()='Sauce Labs Bolt T-Shirt']") 
	public WebElement tShirtText;
	
	@FindBy(xpath = "//*[text()='Sauce Labs Bike Light']") 
	public WebElement bikeLightText;
	
	@FindBy(xpath = "//*[text()='Sauce Labs Fleece Jacket']") 
	public WebElement jacketText;
	

	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
		
	}
}
