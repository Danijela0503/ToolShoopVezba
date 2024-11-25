package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {


    RegisterPage registerPage;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setRegisterPage (){
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void userRegistration1 (){
        homePage.goToLoginPage();
        loginPage.goToRegisterPage();
        registerPage.registerUser();
        loginPage.isUserOnLogin();
        loginPage.logInUser(registerPage.getEmailAddress(), registerPage.getPassword());

        String expectedText = "My account";
        Assert.assertEquals(expectedText, registerPage.actualText(), "User is not registered!");
    }

    @Test
    public void userRegistration2 (){
        homePage.goToLoginPage();
        loginPage.goToRegisterPage();
        registerPage.registerUser();
        loginPage.isUserOnLogin();
        loginPage.logInUser(registerPage.getEmailAddress(), registerPage.getPassword());

        Assert.assertTrue(registerPage.isUserRegistered());
    }




}
