package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest
{
	
	
    public void homePageTest() throws InterruptedException 
	{

        // Then test home page
        HomePage hp = new HomePage(BaseTest.getDriver());
        /*boolean productPage = hp.homePage.isDisplayed();
        System.out.println("Test : "+hp.homePage.getText());
        Assert.assertTrue(productPage, "It is Not Home Page");
        */
        
        Assert.assertEquals("Products", hp.homePage.getText(),"It is Not Home Page / Products Page");
       
        hp.addbackPack();
        hp.addbikeLight();
        hp.addtShirt();
        hp.addJacket();
        hp.clickCart();
        
    }
}
