package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By sliderContainer = By.className("sliderContainer");
    private By sliderInput = By.tagName("input");

    private By sliderValue = By.id("range");
    private By slider = By.cssSelector(".sliderContainer input");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    /*public void moveSlider(int value){
        WebElement slider = driver.findElement(sliderContainer); - locator method not successful
        slider.findElement(sliderInput).click();


        for (int i=0; i<value; i++){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }*/

    public void setSliderValue(String value){
        while(!getSliderValue().equals(value)){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue(){
        return driver.findElement(sliderValue).getText();
    }

}
