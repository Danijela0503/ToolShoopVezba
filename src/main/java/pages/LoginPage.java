package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private By registerYourAccountButton = By.cssSelector("a[data-test='register-link']");
    private By emailField = By.id("email");
    private By passwordField = By.cssSelector("input[data-test='password']");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");
    private By googleButton = By.cssSelector("button[class='google-sign-in-button']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void goToRegisterPage() {
        clickOnElement(registerYourAccountButton);
    }

    public void logInUser(String emailAddress, String password) {
        typeIn(emailField, emailAddress);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
    }


    public boolean isUserOnLogin (){
       return matchesExpectedText(googleButton, "Sign in with Google");
    }



}
