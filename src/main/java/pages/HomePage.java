package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    //private By formAuthenticationLink = By.linkText("Form Authentication"); Not needed after making clickLink method

    public HomePage(WebDriver driver){ //default constructor eliminated, class must have WebDriver passed in when instantiated
        this.driver = driver;
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickFormAuthentication(){
        //driver.findElement(formAuthenticationLink).click(); Not needed after making clickLink method

        clickLink("Form Authentication");
        return new LoginPage(driver);
        //all pages need a WebDriver to interact with browser. Will pass this class's WebDriver that has open session
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword(){
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }
}
