package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.ActionTest;
import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelReader;

public class LoginTestInfinity extends BaseTest {

    LoginPage loginPage;
    HomePage hp;
    CartPage cp;

    @BeforeMethod
    public void innotitialization() {
        loginPage = new LoginPage(BaseTest.getDriver());
        hp = new HomePage(BaseTest.getDriver());
        cp = new CartPage(BaseTest.getDriver());
    }

    
    
    @Test(dataProvider = "userData", dataProviderClass = ExcelReader.class,groups = {"dataDriven"})
    public void fullFlow(String username, String password) throws InterruptedException, IOException {
        // Step 1: Login
        loginPage.enterusername(username);
        loginPage.enterpassword(password);
        loginPage.clickonloginbutton();

        // Step 2: Home Page actions
        Assert.assertEquals("Products", hp.homePage.getText(), "It is Not Home Page / Products Page");
        hp.addbackPack();
        hp.addbikeLight();
        hp.addtShirt();
        hp.addJacket();
        hp.clickCart();

        // Step 3: Cart Page validations
        Thread.sleep(2000);
        

        String yourCart = cp.yourCartPage.getText();
        Assert.assertEquals(yourCart, "Your Cart");

        Assert.assertTrue(cp.backPackText.isDisplayed());
        System.out.println("Backpack: " + cp.backPackText.getText());

        Assert.assertTrue(cp.tShirtText.isDisplayed());
        System.out.println("T-Shirt: " + cp.tShirtText.getText());

        Assert.assertTrue(cp.bikeLightText.isDisplayed());
        System.out.println("Bike Light: " + cp.bikeLightText.getText());

        Assert.assertTrue(cp.jacketText.isDisplayed());
        System.out.println("Jacket: " + cp.jacketText.getText());

        Thread.sleep(2000);
        

        // Optional: Logout or reset state for next login
        
        
    }
    

}
