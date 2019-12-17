package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");
    private String piNumpadCode = Keys.chord(Keys.NUMPAD2, Keys.NUMPAD2, Keys.NUMPAD7);

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text);
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }

    public void enterPi(){
        //driver.findElement(inputField).sendKeys(piNumpadCode);
        //driver.findElement(inputField).sendKeys(Keys.chord(Keys.LEFT_ALT, piNumpadCode));

        //driver.findElement(inputField).sendKeys(Keys.NUMPAD2, Keys.NUMPAD2, Keys.NUMPAD7);
        //driver.findElement(inputField).sendKeys(Keys.chord(Keys.chord(Keys.LEFT_ALT, Keys.NUMPAD2), Keys.chord(Keys.LEFT_ALT, Keys.NUMPAD2), Keys.chord(Keys.LEFT_ALT, Keys.NUMPAD7)));
    }
}
