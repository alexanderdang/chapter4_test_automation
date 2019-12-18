package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromDropDown(String option){
        //Select dropdownElement = new Select(driver.findElement(dropdown)); Done through method to avoid encapsulation access limit
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        //Only want to pass String/text from WebElement to the test class
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
        //Used stream then map then lambda expression
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

    public void changeDropDownMenuAttribute(){
        String script = "arguments[0].setAttribute('multiple', '')";

        var jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript(script, findDropDownElement());
    }
}
