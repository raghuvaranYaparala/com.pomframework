package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import actions.ActionTest;
public class HomePage
{
	WebDriver driver;
	@FindBy(xpath = "//div[@class='product_label']") 
	public WebElement homePage;

	@FindBy(xpath="//div[@class='inventory_list']//div[1]//div[3]//button[1]")
	private WebElement backPack;
	
	@FindBy(xpath ="//body//div[@id='page_wrapper']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]")
	private WebElement bikeLight;
	
	@FindBy(xpath="//div[3]//div[3]//button[1]")
	private WebElement tShirt;
	
	@FindBy(xpath="//div[4]//div[3]//button[1]")
	private WebElement jacket;
	
	@FindBy(xpath="//*[name()='path' and contains(@fill,'currentCol')]") 
	private WebElement cartListButton;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
		
	}
	
	public void addbackPack()
	{
		ActionTest.waitUntilElementVisisble(driver, backPack);
		backPack.click();
	}
	
	public void addbikeLight()
	{
		
		bikeLight.click();
	}
	
	public void addtShirt()
	{
		
		tShirt.click();
	}
	
	public void addJacket()
	{
		
		jacket.click();
	}
	
	public void clickCart()
	{
		cartListButton.click();
	}
	
	public void verifypage()
	{
		String actual=homePage.getText();
		Assert.assertEquals("Products",actual,"It is Not Home Page / Products Page");
	      
	}
	
}










/*
 * 
xpath("//div[normalize-space()='Sauce Labs Backpack']")
xpath("//div[normalize-space()='Sauce Labs Bike Light']")
xpath("//div[normalize-space()='Sauce Labs Bolt T-Shirt']")
xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']")
 */
