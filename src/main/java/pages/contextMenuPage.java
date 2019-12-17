package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class contextMenuPage {

    private WebDriver driver;
    private By alertBox = By.id("hot-spot");

    public contextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void rightClickInBox(){
        WebElement hotSpotBox = driver.findElement(alertBox);

        Actions actions = new Actions(driver);
        actions.moveToElement(hotSpotBox).contextClick().perform();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
}
