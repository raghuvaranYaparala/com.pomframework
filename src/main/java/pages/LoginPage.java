package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



public class LoginPage 
{

	WebDriver driver;
	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginbutton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
		
	}
	
	public void enterusername(String name)
	{
		username.sendKeys(name);
	}
	
	public void enterpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickonloginbutton()
	{
		loginbutton.click();
	}
	
	
	
	
    
}
