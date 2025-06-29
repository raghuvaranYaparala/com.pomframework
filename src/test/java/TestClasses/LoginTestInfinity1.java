package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.ActionTest;
import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ListernersTest;

@Listeners(ListernersTest.class)
public class LoginTestInfinity1 extends BaseTest
{
	LoginPage loginPage;
	HomePage hp ;
	 CartPage cp;
	 
	 @BeforeClass
	public void initialization()
	{
		 loginPage = new LoginPage(BaseTest.getDriver());
		  hp = new HomePage(BaseTest.getDriver());
		  cp = new CartPage(BaseTest.getDriver());
	}
	
	 
	 
	@Test(priority=1) 
	public void login()
	{
		  	loginPage.enterusername("standard_user");
	        loginPage.enterpassword("secret_sauce");
	        loginPage.clickonloginbutton();	
	}
	
	@Test(priority=2) 
	public void addingItems() throws InterruptedException
	{
		 ActionTest.waitUntilElementVisisble(BaseTest.getDriver(), hp.homePage);
	        
	        Thread.sleep(3000);
	        
	        hp.verifypage();
	        hp.addbackPack();
	        hp.addbikeLight();
	        hp.addtShirt();
	        hp.addJacket();
	        hp.clickCart();
	        
	        Thread.sleep(3000);
	}
	
	@Test(priority=3) 
	public void verifyCartPage() throws InterruptedException
	{
		 
	        
	        String yourCart = cp.yourCartPage.getText();
	        
	        Assert.assertEquals(yourCart,"Your Cart");
	        System.out.println(yourCart);
	        
	        Assert.assertTrue(cp.backPackText.isDisplayed());
	        
	        System.out.println(cp.backPackText.getText());
	        
	        Assert.assertTrue(cp.tShirtText.isDisplayed());
	        
	        System.out.println(cp.tShirtText.getText());
	        Assert.assertTrue(cp.bikeLightText.isDisplayed());
	        
	        System.out.println(cp.bikeLightText.getText());
	        
	        Assert.assertTrue(cp.jacketText.isDisplayed());
	        
	        System.out.println(cp.jacketText.getText());
	        
	        Thread.sleep(3000);
	       // Assert.assertFalse(true);
	}
	
	
	
}
