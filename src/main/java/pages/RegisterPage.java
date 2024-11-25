package pages;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class RegisterPage extends BasePage {

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By dobField = By.id("dob");
    private By addressField = By.id("address");
    private By postcodeField = By.id("postcode");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By countryField = By.id("country");
    private By phoneField = By.id("phone");
    private By emailField = By.id("email");
    private By passwordField = By.cssSelector("input[data-test='password']");
    private By registerButton = By.cssSelector("button[data-test='register-submit']");

    private By myAccountPageTite = By.cssSelector("h1[data-test='page-title']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    Faker faker = new Faker(new Locale("en-US"));

    String emailAddress = faker.internet().emailAddress();
    String password = faker.internet().password(8, 12, true, true,
            true);

    public void registerUser() {
        typeIn(firstNameField, faker.name().firstName());
        typeIn(lastNameField, faker.name().lastName());
        typeIn(dobField, "12111999");
        typeIn(addressField, faker.address().fullAddress());
        typeIn(postcodeField, faker.address().zipCode());
        typeIn(cityField, faker.address().city());
        typeIn(stateField, faker.address().state());
        selectCountry();
        typeIn(phoneField, faker.number().digits(10));
        typeIn(emailField, emailAddress);
        typeIn(passwordField, password);
        clickOnElement(registerButton);
    }

    public void selectCountry() {
        WebElement element = getElement(countryField);
        Select select = new Select(element);
        select.selectByVisibleText("France");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String actualText() {
        return getText(myAccountPageTite).trim();
    }

    public boolean isUserRegistered (){
        return matchesExpectedText(myAccountPageTite, "My account");
    }







}
