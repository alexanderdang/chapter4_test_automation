package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.cssSelector("#mceu_12 button");

    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
        /*Switches the context from page's DOM to this iframe DOM
        Is private because test as well as user does not need to worry about iframe implementation
         */
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public void increaseIndention(){
        driver.findElement(increaseIndentButton).click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void switchToMainArea(){
        driver.switchTo().parentFrame();
        //Good practice to switch back to parent/page frame after completing task inside iframe
    }

}
