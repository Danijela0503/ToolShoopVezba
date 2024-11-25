package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTest {

    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void initialSetUp (){
        driver = DriverManager.driverSetUp("Chrome");
        driver.get("https://practicesoftwaretesting.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser (){
        driver.quit();
    }


}
