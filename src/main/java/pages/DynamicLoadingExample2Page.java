package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadedText = By.cssSelector("#finish h4");
    //private By loadedText = By.id("finish"); - instructor's locator

    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickStart(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
    }

    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }

    /* Extra unused code
    public boolean isStartButtonDisplayed(){
        return driver.findElement(startButton).isDisplayed();
    }
     */
}
