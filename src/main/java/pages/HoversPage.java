package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements(figureBox).get(index - 1);
        //findElements returns a list but we use get and pass in the index to specify the specific element
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        //moveToElement (mouse hover) triggers figcaption div HTML element to be visible
        return new FigureCaption(figure.findElement(boxCaption));
        //return HTML div element within HoversPage because test classes should not receive WebElements
    }

    public class FigureCaption{
    /*Is an inner class that represents the figcaption HTML div element. WebElements are not passed to the test-side.
    Class will provide methods that will return things related to the WebElement back to the test-side
     */
        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        public boolean isCaptionDisplayed(){
            //Enable test side to see if caption is displayed
            return caption.isDisplayed();
        }

        public String getTitle(){
            return caption.findElement(header).getText();
        }

        public String getLink(){
            return caption.findElement(link).getAttribute("href");
            //findElement returns the <a> WebElement from which we want the href attribute which is a link
        }

        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}
