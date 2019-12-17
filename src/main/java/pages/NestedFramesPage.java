package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;
    private String topFrameName = "frame-top";
    private String bottomFrameName = "frame-bottom";
    //private By leftFrameBody = By.xpath("/html/body");
    private By frameBody = By.tagName("body");

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    public void switchToTopFrame(){
        driver.switchTo().frame(topFrameName);
    }

    public void switchToBottomFrame(){
        driver.switchTo().frame(bottomFrameName);
    }

    public void printFrameIndexSize(){
        System.out.println(driver.findElements(By.tagName("frame")).size());
        //Used to detect if any frames inside the <html> or <frame> and how many
    }

    public void switchToFrameByIndex(int index){
        driver.switchTo().frame(index);
    }

    public String getBodyText(){
        String bodyText = driver.findElement(frameBody).getText();
        return bodyText;
    }

    public void switchToOuterParentFrame(){
        driver.switchTo().parentFrame();
    }
}

/* Instructor's solution
public class NestedFramesPage {

    private WebDriver driver;
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    public String getLeftFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit left to top
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }

    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }

    private String getFrameText(){
        return driver.findElement(body).getText();
    }
}
 */
