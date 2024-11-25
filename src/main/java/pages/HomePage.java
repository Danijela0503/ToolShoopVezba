package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By signInbutton = By.cssSelector("a[data-test='nav-sign-in']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage (){
        clickOnElement(signInbutton);
    }


}
